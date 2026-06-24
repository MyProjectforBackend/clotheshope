package com.shop.ClotheShop.config;

import com.shop.ClotheShop.service.CustomUserDetailsService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(
            HttpSecurity http,
            AuthenticationProvider authProvider) throws Exception {

        http
                .csrf(csrf -> csrf.disable())

                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/swagger-ui/**",
                                "/v3/api-docs/**",
                                "/swagger-ui.html")
                        .permitAll()

                        .anyRequest().authenticated())

                .authenticationProvider(authProvider)

                .httpBasic(withDefaults())

                .sessionManagement(session -> session.sessionCreationPolicy(
                        SessionCreationPolicy.STATELESS));

        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(
            CustomUserDetailsService uds) {

        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(uds);

        provider.setPasswordEncoder(passwordEncoder());

        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        return NoOpPasswordEncoder.getInstance();

    }

}