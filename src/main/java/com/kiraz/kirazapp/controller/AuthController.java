package com.kiraz.kirazapp.controller;

import com.kiraz.kirazapp.base.BaseResponse;
import com.kiraz.kirazapp.model.Users;
import com.kiraz.kirazapp.model.dto.RegisterDTO;
import com.kiraz.kirazapp.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> createUser(@Valid @RequestBody RegisterDTO registerDTO){
        authService.saveUser(registerDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/user")
    public BaseResponse getUser(){
        BaseResponse baseResponse = new BaseResponse<>();
        ArrayList<String> messagesList = new ArrayList<>();
        List<Users> usersList = authService.getUser();
        if (usersList==null){
            baseResponse.setSuccess(false);
            messagesList.add("Kullanıcı listesi getirilemedi");
            baseResponse.setMessages(messagesList);
            baseResponse.setData(null);
        }
        messagesList.add("Kullanıcıların listesi");
        baseResponse.setSuccess(true);
        baseResponse.setMessages(messagesList);
        baseResponse.setData(authService.getUser());
        return baseResponse;
    }
}