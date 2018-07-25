package com.execom.pomodoro.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class TestController {

    
    @GetMapping()
    public String home() {
        final String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return "Welcome, " + username;
    }
}