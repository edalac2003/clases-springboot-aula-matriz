package com.curso.spring.entities.lib;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.curso.spring.entities.lib.constants.MessageStatus;

import lombok.Data;

@Entity
@Table(name = "NOTIFICATIO_REGISTER")
@Data
public class NotificationRegister {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne
	private Customer customer;
	@Column(name = "SENT_DATE")
	private Date sentDate;
	@Column(name = "MESSAGE_STATUS")
	private MessageStatus messagesStatus;
	@Column(name = "MESSAGES")
	private String message;
}
