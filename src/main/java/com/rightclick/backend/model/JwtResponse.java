package com.rightclick.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
    @Setter
    @AllArgsConstructor
    public class JwtResponse {

        private String token;
        private final String type = "Bearer";
        private Integer id;
        private String username;
        private String email;
        private String password;
        private String role;

        public JwtResponse() {
        }

    }

