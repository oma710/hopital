package com.projet.hopital.endPoint;


import com.projet.hopital.service.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailSendController {
    @Autowired
    private EmailServiceImpl emailServiceImpl;

    @GetMapping("/send-email")
    public String sendEmail() {
        String to = "s.omaddi02@gmail.com";
        String subject = "Test Email";
        String body = "This is "+ to +" a test email from Spring Boot.";
        emailServiceImpl.sendEmail(to, subject, body);

        return "email-sent-successfully";
    }
}
