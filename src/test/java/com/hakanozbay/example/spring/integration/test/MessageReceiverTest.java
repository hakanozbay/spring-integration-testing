package com.hakanozbay.example.spring.integration.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.messaging.Message;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hakanozbay.example.spring.integration.Gateway;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/spring/integration/spring-integration-test-context.xml")
@DirtiesContext(classMode=ClassMode.AFTER_EACH_TEST_METHOD)
public class MessageReceiverTest 
{
	@Autowired
	QueueChannel testMessageChannel;
	
	@Autowired
	Gateway gateway;
	
	@Test
	public void testMessageChannelSendAndReceive()
	{
		assertNotNull(testMessageChannel);
		assertNotNull(gateway);
		
		final String textMessage = "Test Message!";
		
		gateway.sendMessage(textMessage);
		
		Message<?> message = testMessageChannel.receive();
		assertNotNull(message);
		String receivedMessage = (String) message.getPayload();
		
		assertEquals(textMessage, receivedMessage);
		
		System.out.println("Message received in test channel -" + textMessage);
		
	}
}
