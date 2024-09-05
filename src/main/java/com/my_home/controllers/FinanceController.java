package com.my_home.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my_home.domain.finance.FinanceRepository;
import com.my_home.domain.finance.RequestFinance;
import com.my_home.domain.finance.Finance;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/finance")
public class FinanceController {

  @Autowired
  private FinanceRepository repository;

  @SuppressWarnings("rawtypes")
  @GetMapping
  public ResponseEntity getAllFinances() {
    var allFinances = repository.findAll();
    return ResponseEntity.ok(allFinances);
  }

  @SuppressWarnings("rawtypes")
  @PostMapping
  public ResponseEntity registerFinance(@RequestBody @Valid RequestFinance data) {
    Finance newFinance = new Finance(data);

    repository.save(newFinance);
    return ResponseEntity.ok(newFinance);
  }

}
