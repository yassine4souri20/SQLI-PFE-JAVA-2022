package org.sqli.authentification.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.sqli.authentification.dto.RequestUser;
import org.sqli.authentification.dto.RequestUserLogin;
import org.sqli.authentification.service.impl.UserServiceImpl;
import org.sqli.authentification.utils.Constants;

@RestController
@RequestMapping(Constants.AUTHENTICATION_ENDPOINT)
public class UserController {


    @Autowired
    UserServiceImpl userService;

    @PostMapping("/authenticate")
    public ResponseEntity<?> auth(@RequestBody RequestUserLogin requestUserLogin) {
        return userService.findByLoginPassword(requestUserLogin.getLogin(), requestUserLogin.getPassword());
    }


    @DeleteMapping("/remove/{login}")
    public ResponseEntity<?> deleteUser(@PathVariable String login) {
        return userService.deleteUserByLogin(login);

    }

    @PostMapping("/add")
    public ResponseEntity<?> saveUser(@RequestBody RequestUser userRequest) {
        return userService.addUser(userRequest);
    }










}
