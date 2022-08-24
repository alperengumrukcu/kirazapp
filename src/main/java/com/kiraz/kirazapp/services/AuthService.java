package com.kiraz.kirazapp.services;

import com.kiraz.kirazapp.model.Users;
import com.kiraz.kirazapp.model.dto.RegisterDTO;
import com.kiraz.kirazapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByEmail(username);
        if (user==null){
            throw new UsernameNotFoundException("Kullanıcı bulunamadı.");
        }
        ArrayList<GrantedAuthority> roller = new ArrayList<>();
        if(user.getIsAdmin()){
            SimpleGrantedAuthority rol = new SimpleGrantedAuthority("ADMIN");
            roller.add(rol);
        }
        else {
            SimpleGrantedAuthority rol = new SimpleGrantedAuthority("USER");
        roller.add(rol);
        }
        return new User(user.getEmail(),user.getPassword(),roller);
    }
    public void saveUser(RegisterDTO registerDTO) {
        registerDTO.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
       Users saveUser = changeUser(registerDTO);
       userRepository.save(saveUser);
    }
    public Users changeUser(RegisterDTO registerDTO){
        return new Users(registerDTO.getName(),registerDTO.getSurname(),registerDTO.getPassword(),registerDTO.getEmail(),registerDTO.getPhoneNumber());
    }

    public List<Users> getUser() {
        return userRepository.findAll();
    }
}
