package com.brevo.app.backendcs2.services;

import com.brevo.app.backendcs2.dto.UserDTO;

import org.springframework.stereotype.Service;

@Service
public interface UserServiceInterface {

        public UserDTO createUser(UserDTO userDTO);
    
}
