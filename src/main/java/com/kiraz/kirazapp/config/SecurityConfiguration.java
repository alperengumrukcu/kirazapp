package com.kiraz.kirazapp.config;

import com.kiraz.kirazapp.filter.CustomAuthFilter;
import com.kiraz.kirazapp.filter.CustomAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration{

    @Autowired
    private AuthenticationManager authenticationManager;

    @Bean
    protected SecurityFilterChain filtersChain(HttpSecurity http) throws Exception {
        http.httpBasic().disable();
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/auth/**").permitAll();
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(new CustomAuthFilter(authenticationManager));
        http.addFilterBefore(new CustomAuthorizationFilter(), CustomAuthFilter.class);
        return http.build();
    }
}