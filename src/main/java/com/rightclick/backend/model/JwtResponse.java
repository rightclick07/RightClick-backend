package com.rightclick.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
    @Getter
    @Setter
    @AllArgsConstructor
    public class JwtResponse {

        private String token;
        private final String type = "Bearer";
        private Long id;
        private String username;
        private String email;
        private String password;
        private List<String> roles;

        public JwtResponse() {
        }
    }

