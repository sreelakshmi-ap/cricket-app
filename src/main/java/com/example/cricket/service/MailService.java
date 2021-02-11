package com.example.cricket.service;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	private JavaMailSender javaMailSender;

	@Autowired
	public MailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}


	public void sendEmail(String user, String subject, String body) throws MailException, MessagingException {
		try {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user);
		mail.setSubject(subject);
		mail.setText(body);

		javaMailSender.send(mail);
		}
		catch(MailException mex)
		{
			System.out.println(mex.getMessage());
		}
	}

}
