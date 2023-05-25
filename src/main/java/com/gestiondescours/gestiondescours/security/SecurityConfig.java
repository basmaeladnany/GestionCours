package com.gestiondescours.gestiondescours.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.formLogin();
        httpSecurity.authorizeHttpRequests().requestMatchers("/createCours").hasAnyRole("ADMIN","PROFESSEUR");
        httpSecurity.authorizeHttpRequests().requestMatchers("/saveCours").hasAnyRole("ADMIN");
        httpSecurity.authorizeHttpRequests().requestMatchers("/showCours").hasAnyRole("ADMIN");
        httpSecurity.authorizeHttpRequests().requestMatchers("/updateCours").hasAnyRole("ADMIN");
        httpSecurity.authorizeHttpRequests().requestMatchers("/deleteCours").hasAnyRole("ADMIN");
        httpSecurity.authorizeHttpRequests().requestMatchers("/coursList").hasAnyRole("ADMIN","PROFESSEUR","DIRECTEUR");

        httpSecurity.authorizeHttpRequests().anyRequest().authenticated();
        return httpSecurity.build();
    }
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        return new InMemoryUserDetailsManager(
                User.withUsername("etudiant").password(passwordEncoder.encode("etudiant")).roles("ADMIN","USER").build(),
                User.withUsername("professeur").password(passwordEncoder.encode("professeur")).roles("PROFESSEUR").build(),
                User.withUsername("directeur").password(passwordEncoder.encode("directeur")).roles("DIRECTEUR").build()
        );
    }


}