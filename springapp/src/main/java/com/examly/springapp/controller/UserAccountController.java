package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.examly.springapp.model.UserAccount;
import com.examly.springapp.service.UserAccountService;

@RestController
@RequestMapping("/api")
public class UserAccountController {

    @Autowired
    private UserAccountService userAccountService;

    @PostMapping("/users")
    public ResponseEntity<UserAccount> createUser(@RequestBody UserAccount userAccount) {
        UserAccount saved = userAccountService.saveUserAccount(userAccount);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/user-accounts/{id}")
    public String getUserAccount(@PathVariable Long id) {
        return "UserAccount";
    }
}
