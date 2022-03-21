package com.examly.springapp.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogInController {

    @GetMapping("/admin/dashboard")
    @ResponseBody
    public String adminDashboard(){
        return "Welcome to admin Dashboard";
    }

    @GetMapping("/user/dashboard")
    @ResponseBody
    public String userDashboard(){
        return "Welcome to User Dashboard";
    }
}
