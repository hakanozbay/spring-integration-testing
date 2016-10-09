package com.hakanozbay.example.spring.integration;

import org.springframework.stereotype.Component;

@Component
public class MessageReceiver 
{
	public void receiveMessage(String message)
	{
		System.out.println("Message received - " + message);
	}
}
