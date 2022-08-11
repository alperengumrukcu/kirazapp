package com.kiraz.kirazapp.model.dto;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;

@Data
@Validated
public class RegisterDTO {
    private String name;
    private String surname;
    @NotBlank(message = "{registerdto.passwordisBlank}")
    private String password;
    @NotBlank(message = "{registerdto.emailisBlank}")
    @Email(message = "{registerdto.isEmail}")
    private String email;
    private String phoneNumber;
}