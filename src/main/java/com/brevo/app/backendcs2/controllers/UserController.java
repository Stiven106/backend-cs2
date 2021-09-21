package com.brevo.app.backendcs2.controllers;

import com.brevo.app.backendcs2.models.request.UserDetailRequestModel;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/users") // http://localhost:8080/users
public class UserController     {

    @GetMapping
    public String getUser() {
        return "Obteniendo usuario";
    }

    @DeleteMapping
    public String deleteUser() {
        return "Borrando usuario";
    }

    @PostMapping
    public String createUser(@RequestBody UserDetailRequestModel userDetails) {
        return "Creando usuario";
    }

}
