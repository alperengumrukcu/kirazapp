package com.kiraz.kirazapp.services;

import com.kiraz.kirazapp.model.Users;
import com.kiraz.kirazapp.model.dto.RegisterDTO;
import com.kiraz.kirazapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    public void saveUser(RegisterDTO registerDTO) {
       Users saveUser = changeUser(registerDTO);
       saveUser.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
       userRepository.save(saveUser);
    }

    public Users changeUser(RegisterDTO registerDTO){
        return new Users(registerDTO.getName(),registerDTO.getSurname(),registerDTO.getPassword(),registerDTO.getEmail(),registerDTO.getPhoneNumber());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
