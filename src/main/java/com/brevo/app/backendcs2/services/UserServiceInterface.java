package com.brevo.app.backendcs2.services;

import com.brevo.app.backendcs2.dto.UserDTO;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

public interface UserServiceInterface extends UserDetailsService {
        public UserDTO createUser(UserDTO userDTO);
    }