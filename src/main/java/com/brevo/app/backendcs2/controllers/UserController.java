package com.brevo.app.backendcs2.controllers;

import com.brevo.app.backendcs2.dto.UserDTO;
import com.brevo.app.backendcs2.models.request.UserDetailRequestModel;
import com.brevo.app.backendcs2.models.response.UserRest;
import com.brevo.app.backendcs2.services.UserServiceInterface;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/users") // http://localhost:8080/users
public class UserController     {

    @Autowired
    UserServiceInterface userService;

    @GetMapping //estamos obteniendo los usuarios
    public String getUser() {
        return "Obtener usuarios";
    }

    //Aqui estamos creando un usuario.
    @PostMapping
    public UserRest createrUser(@RequestBody UserDetailRequestModel userDetails){  
            UserRest userToReturn = new UserRest();
            UserDTO userDTO = new UserDTO();
            extracted(userDetails, userDTO);
            UserDTO createrUser = userService.createUser(userDTO);
            BeanUtils.copyProperties(createrUser, userToReturn);

        return userToReturn;
    }

    private void extracted(UserDetailRequestModel userDetails, UserDTO userDTO) {
        BeanUtils.copyProperties(userDetails, userDTO);
    }

}
