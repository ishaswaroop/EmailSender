package com.example.Emailsender.serviceimpl;


import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.Emailsender.service.EmailSenderService;

@Service
public class EmailSenderServiceImpl implements EmailSenderService {

    private final JavaMailSender mailSender;

    public EmailSenderServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

	@Override
	public void sendEmail(String to, String subject, String message) {
		

	        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
	        simpleMailMessage.setFrom("ishaswaroop122@gmail.com");
	        simpleMailMessage.setTo(to);
	        simpleMailMessage.setSubject(subject);
	        simpleMailMessage.setText(message);

	        this.mailSender.send(simpleMailMessage);
	    }

	@Override
	
		// TODO Auto-generated method stub
		 public void sendEmailWithAttachment(String toEmail,String body,String subject,String attachment) throws MessagingException {

          MimeMessage mimeMessage = mailSender.createMimeMessage();

             MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

               mimeMessageHelper.setFrom("ishaswaroop122@gmail.com");
               mimeMessageHelper.setTo(toEmail);
                mimeMessageHelper.setText(body);
                  mimeMessageHelper.setSubject(subject);

      FileSystemResource fileSystem= new FileSystemResource(new File(attachment));

      mimeMessageHelper.addAttachment(fileSystem.getFilename(),fileSystem);

     this.mailSender.send(mimeMessage);
    

	}
		
	}

    
