package com.kiraz.kirazapp.services;

import com.kiraz.kirazapp.model.Users;
import com.kiraz.kirazapp.model.dto.RegisterDTO;
import com.kiraz.kirazapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;
    public void saveUser(RegisterDTO registerDTO) {
       Users saveUser = changeUser(registerDTO);
       userRepository.save(saveUser);
    }

    public Users changeUser(RegisterDTO registerDTO){
        return new Users(registerDTO.getName(),registerDTO.getSurname(),registerDTO.getPassword(),registerDTO.getEmail(),registerDTO.getPhoneNumber());
    }

}
