package com.shop.ClotheShop.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        System.out.println("LOGIN TRY: " + username);

        if (!username.equals("root")) {

            throw new UsernameNotFoundException(
                    "User not found");
        }

        return User.builder()

                .username("root")

                .password("root")

                .roles("USER")

                .build();
    }

}