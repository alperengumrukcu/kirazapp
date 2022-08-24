package com.kiraz.kirazapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;

@Data
@Validated
@AllArgsConstructor
@NoArgsConstructor
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