package com.example.seoullite.common.service;

import java.io.IOException;

public interface EmailService {

    void sendMail(String to) throws IOException;

}
