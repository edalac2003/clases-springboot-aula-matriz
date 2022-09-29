package com.curso.spring.message.service.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.spring.entities.lib.NotificationRegister;

@RestController
@RequestMapping("/message-sender")
public class MessageSenderController {

	@PostMapping("/send")
	public NotificationRegister SendNotification(NotificationRegister notificacionRegister) {
		return null;
	}
}
