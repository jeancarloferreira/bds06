package com.devsuperior.movieflix.controller;

import com.devsuperior.movieflix.dto.UserDTO;
import com.devsuperior.movieflix.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping(value = "/profile")
    public ResponseEntity<UserDTO> profileForCurrentUser(){
        UserDTO dto = userService.profileForCurrentUser();
        return ResponseEntity.ok().body(dto);
    }
}
