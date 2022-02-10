package com.example.seoullite.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping(value="/signUp")
    public String signUpUser() {
        return "signup";
    }
}
