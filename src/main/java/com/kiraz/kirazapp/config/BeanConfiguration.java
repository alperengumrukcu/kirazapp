package com.kiraz.kirazapp.config;

import com.kiraz.kirazapp.model.dto.RegisterDTO;
import com.kiraz.kirazapp.services.AuthService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class BeanConfiguration {
    @Bean
    public MessageSource messageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
    @Bean
    public LocalValidatorFactoryBean validatorFactoryBean(){
        LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
        factoryBean.setValidationMessageSource(messageSource());
        return factoryBean;
    }
    @Bean
    CommandLineRunner runner (AuthService authService){
        return args -> {
            authService.saveUser(new RegisterDTO("alperen","gümrükçü","12345","alperen.gumrukcu@gmail.com","5533089796"));
            authService.saveUser(new RegisterDTO("abdulkadir","gümrükçü","12345","abdulkadir.gumrukcu@gmail.com","5078900167"));
            authService.saveUser(new RegisterDTO("said","demir","12345","said.demir@gmail.com","5452873139"));
            authService.saveUser(new RegisterDTO("berk","koşal","12345","berk.kosal@gmail.com","5344567897"));
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
