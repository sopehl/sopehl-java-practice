package com.sopehl.activemq.connection;

import javax.jms.JMSException;
import javax.jms.MessageProducer;

import org.apache.activemq.command.ActiveMQTextMessage;

/**
 * <p>Send the message to broker(queue or topic) by produce/publisher
 * 
 * @author okan.pehlivan
 *
 */
public class ActiveMQMessageSender {
	
	private MessageProducer producer;
	
	private ActiveMQTextMessage messageText;

	public ActiveMQMessageSender(MessageProducer producer) {
		super();
		this.producer = producer;
		this.messageText = new ActiveMQTextMessage();
	}
	
	public void sendMessage(String text) {
		try {
			messageText.setText(text);
			producer.send(this.messageText);
		} catch (JMSException e) {
			System.out.println("JMS sending message problem. Details:" + e);
		}
	}
	
}
