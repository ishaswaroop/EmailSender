package com.example.Emailsender;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.example.Emailsender.service.EmailSenderService;

@SpringBootApplication
public class EmailsenderApplication {
    
	
	
	public static void main(String[] args) {
		SpringApplication.run(EmailsenderApplication.class, args);
	}
	

	}


