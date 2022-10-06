package com.example.Emailsender.controller;


import javax.mail.MessagingException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Emailsender.resource.EmailMessage;
import com.example.Emailsender.service.EmailSenderService;

@RestController
public class EmailController {

    private final EmailSenderService emailSenderService;

    public EmailController(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    @PostMapping("/send-email")
    public ResponseEntity sendEmail(@RequestBody EmailMessage emailMessage) {
        this.emailSenderService.sendEmail(emailMessage.getTo(), emailMessage.getSubject(), emailMessage.getMessage());
        return ResponseEntity.ok("Success");
    }
    @PostMapping("/send-emailattachment")
    public ResponseEntity sendEmailWithAttachment(@RequestBody EmailMessage emailMessage) throws MessagingException {
    	this.emailSenderService.sendEmailWithAttachment(emailMessage.getTo(), emailMessage.getSubject(), emailMessage.getMessage(),"C:\\Users\\isha.swaroop\\Documents\\dbms.txt");
        return ResponseEntity.ok("Success");
    	
    	
    }
    
}
