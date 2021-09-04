package com.avocado.imsApp.controllers;

import com.avocado.imsApp.dto.UserRequest;
import com.avocado.imsApp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;


    @PostMapping
    public ResponseEntity<String> saveUserDetails(@RequestBody UserRequest userRequest){
        this.userService.saveUser(userRequest);
        return new ResponseEntity<String>(HttpStatus.CREATED);
    }
}
