package com.projet.hopital.endPoint;


import com.projet.hopital.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailSendController {
    @Autowired  
    private EmailService emailService;

    @GetMapping("/send-email")
    public String sendEmail() {
        String to = "s.omaddi02@gmail.com";
        String subject = "Test Email";
        String body = "This is "+ to +" a test email from Spring Boot.";
        emailService.sendEmail(to, subject, body);

        return "email-sent-successfully";
    }
}
