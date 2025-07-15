package com.example.Ecom.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()  // 🔐 Disable CSRF for Postman testing
                .authorizeHttpRequests()
                .requestMatchers("/auth/signup", "/auth/login").permitAll()  // ✅ Allow these
                .anyRequest().authenticated()  // 🔒 Others need authentication
                .and()
                .httpBasic(); // or .formLogin() if you plan a UI later

        return http.build();
    }
}
