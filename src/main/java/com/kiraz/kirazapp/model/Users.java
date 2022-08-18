package com.kiraz.kirazapp.model;

import com.kiraz.kirazapp.base.BaseEntity;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@Data
public class Users extends BaseEntity {

    private String name;
    private String surname;
    private String password;
    private String email;
    private String phoneNumber;
    private Boolean isAdmin;
    private Boolean emailStatus=false;
    private Boolean rowStatus=true;

    public Users(String name, String surname, String password, String email, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Users() {

    }
}
