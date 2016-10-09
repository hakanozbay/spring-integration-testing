package com.hakanozbay.example.spring.integration;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	AbstractApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/integration/spring-integration-context.xml");
    	context.registerShutdownHook();
    	context.start();
    	
    	Gateway gateway = context.getBean("gateway", Gateway.class);
    	gateway.sendMessage("Hello world!");
    	
    	context.stop();
    	context.close();
    }
}
