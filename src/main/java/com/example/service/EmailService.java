package com.example.service;

import com.example.model.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    public String sendMail(Mail mailDetail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("alexepure70@gmail.com");
        message.setTo(mailDetail.getTomail());
        message.setSubject(mailDetail.getSubject());
        message.setText(mailDetail.getBody());
        emailSender.send(message);
        return "done";
    }

}
