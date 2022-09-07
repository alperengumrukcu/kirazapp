package com.kiraz.kirazapp.filter;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class CustomAuthorizationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
       if(request.getServletPath().equals("/login")) {filterChain.doFilter(request,response);}
       else {
           Authentication authentication = new UsernamePasswordAuthenticationToken("alperen123@gmail.com","12345",new ArrayList<>());
           SecurityContextHolder.getContext().setAuthentication(authentication);
           filterChain.doFilter(request,response);
       }
       }
    }