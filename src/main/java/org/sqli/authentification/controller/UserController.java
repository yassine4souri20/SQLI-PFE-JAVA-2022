package org.sqli.authentification.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.sqli.authentification.dto.RequestUserLogin;
import org.sqli.authentification.service.UserService;

import org.sqli.authentification.utils.Constatnts;
@RestController

@RequestMapping(Constatnts.AUTHENTICATION_ENDPOINT)
public class UserController {


    @Autowired
    UserService userService;

    @PostMapping("/authenticate")
    public ResponseEntity<?> auth(@RequestBody RequestUserLogin requestUserLogin) {
        return userService.findByLoginPassword(requestUserLogin.getLogin(), requestUserLogin.getPassword());
    }













}
