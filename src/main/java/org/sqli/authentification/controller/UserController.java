package org.sqli.authentification.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.sqli.authentification.entitie.User;
import org.sqli.authentification.service.UserService;

import java.util.List;


@RestController
@RequestMapping("/rest/api/")
public class UserController {

 @Autowired(required = true)
 private UserService userRepository;


 @PostMapping("/auth")
 public Status loginUser( @RequestBody User user) {
  List<User> users = userRepository.findAll();
  for (User other : users) {

   if (other.equals(user)) {
    user.setLogin("aLogin");
    user.setPassword("aPassword");

    userRepository.save(user);
    return Status.SUCCESS;
   }
  }
  return Status.FAILURE;
 }


 @DeleteMapping("/users/all")
 public Status deleteUsers() {
  userRepository.deleteAll();
  return Status.SUCCESS;
 }






}
