package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import java.io.File; // Add this import statement

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
	@Autowired
	private JavaMailSender javaMailSender;
	
	 public void sendEmailWithAttachment(String to, String subject, String body, String filePath) {
	        MimeMessage message = javaMailSender.createMimeMessage();
	        MimeMessageHelper helper;

	        try {
	            helper = new MimeMessageHelper(message, true);
	            helper.setTo(to);
	            helper.setSubject(subject);
	            helper.setText(body, true);

	            // Attach your resume or any other file
	            // Replace "application/pdf" with the appropriate MIME type
	            File file = new File("F:\\Wasim Data\\CV\\skwasim.pdf");
	            InputStreamSource source = new FileSystemResource(file);
	            helper.addAttachment("skwasim.pdf", source, "application/pdf");

	            javaMailSender.send(message);
	        } catch (MessagingException e) {
	            e.printStackTrace(); // Handle exception appropriately
	        }
	    }
}
