package com.example.seoullite.common.service;

import com.example.seoullite.user.model.User;

import java.io.IOException;

public interface EmailService {

    void sendMail(User user) throws IOException;

}
