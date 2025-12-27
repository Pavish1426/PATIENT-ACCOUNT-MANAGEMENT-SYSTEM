package com.examly.springapp.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account-status-logs")
public class AccountStatusLogController {

    @GetMapping("/{id}")
    public String getAccountStatusLog(@PathVariable Long id) {
        return "AccountStatusLog";
    }
}
