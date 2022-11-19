package com.davyd.email.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.davyd.email.enums.StatusEmail;
import com.davyd.email.models.EmailModel;
import com.davyd.email.repositories.EmailRepository;

@Service
public class EmailService {

	@Autowired
	EmailRepository repository;
	
	@Autowired
	JavaMailSender mailSender;

	public EmailModel sendEmail(EmailModel emailModel) {
		emailModel.setSendDateEmail(LocalDateTime.now());
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(emailModel.getEmailFrom());
			message.setTo(emailModel.getEmailTo());
			message.setSubject(emailModel.getSubject());
			message.setText(emailModel.getText());
			
			mailSender.send(message);
			
			emailModel.setStatusEmail(StatusEmail.SENT);
		} catch (MailException e) {
			emailModel.setStatusEmail(StatusEmail.ERROR);
		} finally {
			return repository.save(emailModel);
		}
		
		
	}
}
