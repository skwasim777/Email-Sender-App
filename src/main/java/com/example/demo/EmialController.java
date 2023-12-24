package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/email")
public class EmialController {
	@Autowired
	private EmailService emailService;
	
	  @PostMapping("/send")
	    public String sendEmail() {
	        String to = "MDFARHAN8961@gmail.com"; // Replace with HR's email address
	        String subject = "Job Application";
	        String body = "Dear HR, please find my resume attached.";
	        String resumeFilePath = "F:\\Wasim Data\\CV\\skwasim.pdf";// Replace with the actual path to your resume

	        emailService.sendEmailWithAttachment(to, subject, body, resumeFilePath);

	        return "Email sent successfully!";
	    }
}
