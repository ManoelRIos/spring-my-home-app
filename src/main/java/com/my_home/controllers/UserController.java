package com.my_home.controllers;

import com.my_home.domain.user.RequestUser;
import com.my_home.domain.user.User;
import com.my_home.domain.user.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserRepository repository;

  @SuppressWarnings("rawtypes")
  @GetMapping
  public ResponseEntity getAllUsers() {
    var allUsers = repository.findAllByActiveTrue();
    return ResponseEntity.ok(allUsers);
  }

  @SuppressWarnings("rawtypes")
  @PostMapping
  public ResponseEntity registerUser(@RequestBody @Valid RequestUser data) {
    System.out.println(data);

    User newUser = new User(data);

    System.out.println(data);
    repository.save(newUser);
    return ResponseEntity.ok(newUser);
  }

  @SuppressWarnings("rawtypes")
  @PutMapping
  @Transactional
  public ResponseEntity updateUser(@RequestBody @Valid RequestUser data) {
    System.out.println(data);
    Optional<User> optionalUser = repository.findById((data.id()));
    if (optionalUser.isPresent()) {
      User user = optionalUser.get();
      user.setUsername(data.username());
      user.setPassword(data.password());
      user.setFirstName(data.firstName());
      user.setLastName(data.lastName());
      return ResponseEntity.ok(user);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @SuppressWarnings("rawtypes")
  @DeleteMapping("/{id}")
  @Transactional
  public ResponseEntity deleteUser(@PathVariable String id) {
    // repository.deleteById(id);
    // return ResponseEntity.noContent().build();
    Optional<User> optionalUser = repository.findById(id);
    if (optionalUser.isPresent()) {
      User user = optionalUser.get();
      user.setActive(0);
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }

}
