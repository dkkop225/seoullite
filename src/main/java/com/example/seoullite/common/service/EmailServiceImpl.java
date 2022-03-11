package com.example.seoullite.common.service;

import com.example.seoullite.common.util.RedisUtil;
import com.example.seoullite.user.model.User;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.UUID;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void sendMail(User user) throws IOException {

        Email from = new Email("dkkdev225@gmail.com");
        Email toEmail = new Email(user.getEmail());
        String subject = "Seoullite SendGrid Test";

        String key = UUID.randomUUID().toString();
        String encodingPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodingPassword);

        Content content = new Content("text/plain", "<h1>[이메일 인증]</h1> <p>아래 링크를 클릭하시면 이메일 인증이 완료됩니다.</p> " +
                "<a href='http://localhost:8080/user/signup/confirm?key="+key+" target='_blank'>이메일 인증 확인</a>");
        Mail mail = new Mail(from, subject, toEmail, content);

        SendGrid sg = new SendGrid("");
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);



            if(response.getStatusCode() == 202) {
                redisUtil.setDataExpireMinute(key,user,10);
            }

        } catch (IOException ex) {
            throw ex;
        }

    }
}

