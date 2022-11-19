package com.davyd.email.controllers;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.davyd.email.dtos.EmailDto;
import com.davyd.email.models.EmailModel;
import com.davyd.email.services.EmailService;

@RestController
public class EmailController {

	@Autowired
	EmailService emailService;

	@PostMapping("/sending-email")
	public ResponseEntity<EmailModel> sendindEmail(@RequestBody @Valid EmailDto emailDto) {
		EmailModel emailModel = new EmailModel();
		BeanUtils.copyProperties(emailDto, emailModel);
		emailService.sendEmail(emailModel);

		return new ResponseEntity<>(emailModel, HttpStatus.CREATED);
	}
}
