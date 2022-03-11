package com.example.seoullite.user.controller;

import com.example.seoullite.common.service.EmailService;
import com.example.seoullite.user.model.User;
import com.example.seoullite.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

@RestController
@RequestMapping("/user")
public class UserRestController {

    @Autowired
    EmailService emailService;

    @Autowired
    UserService userService;

    @PostMapping("/join")
    public String join( User user) throws IOException {

        emailService.sendMail(user);

        return "null";
    }

    @GetMapping("/signup/confirm")
    public void signupConfirm(@RequestParam("key")String key, HttpServletResponse response) throws IOException, TimeoutException {
        userService.registerUser(key);

        response.sendRedirect("http://localhost:8080/login");
    }


}
