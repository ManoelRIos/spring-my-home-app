package com.my_home.controllers;

import com.my_home.domain.user.RequestUser;
import com.my_home.domain.user.User;
import com.my_home.domain.user.UserRespository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

// import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserRespository respository;

  @SuppressWarnings("rawtypes")
  @GetMapping
  public ResponseEntity getAllUsers() {
    var allUsers = respository.findAll();
    return ResponseEntity.ok(allUsers);
  }

  @SuppressWarnings("rawtypes")
  @PostMapping
  public ResponseEntity registerUser(@RequestBody @Valid RequestUser data) {
    User newUser = new User(data);

    System.out.println(data);
    respository.save(newUser);
    return ResponseEntity.ok().build();
  }

}
