package com.example.Emailsender.service;

import javax.mail.MessagingException;

import org.springframework.stereotype.Service;


public interface EmailSenderService {
    void sendEmail(String to, String subject, String message);

	void sendEmailWithAttachment(String to, String subject, String message, String attachment) throws MessagingException;
}