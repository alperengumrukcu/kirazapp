package com.kiraz.kirazapp.model;

import com.kiraz.kirazapp.base.BaseEntity;
import lombok.Data;

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

}
