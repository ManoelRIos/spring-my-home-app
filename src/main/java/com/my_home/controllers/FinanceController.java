package com.my_home.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/finance")
public class FinanceController {


  @GetMapping
  public String getAllFinances() {
      return "ola";
  }
  
}
