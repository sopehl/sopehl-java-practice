package com.sopehl.activemq;

import java.util.UUID;

import javax.jms.Connection;
import javax.jms.MessageProducer;

import com.sopehl.activemq.connection.ActiveMQConnection;
import com.sopehl.activemq.connection.ActiveMQMessageSender;
import com.sopehl.activemq.connection.ActiveMQSession;
import com.sopehl.activemq.model.ActiveMQConstants;

/**
 * Main class to trigger the data producer
 * 
 * @author okan.pehlivan
 *
 */
public class ActiveMQProducer {
	
	public static void main(String[] args) throws InterruptedException {
		/**
		 * Main structure:
		 * 
		 * createConnection -> session -> createProducer -> sendMessage(queue or topic)
		 * 
		 */
		ActiveMQConnection connection = new ActiveMQConnection();
		Connection mqConnection = connection.createAndStartNewConnection();
		
		ActiveMQSession session = new ActiveMQSession(mqConnection);
		
		// creation of producer with related session.
		MessageProducer producer = session.createNewProducer(mqConnection, ActiveMQConstants.MESSAGE_QUEUE_NAME);
		ActiveMQMessageSender messageSender = new ActiveMQMessageSender(producer);
		
		int i = 0;
		while(i < 50) {
			messageSender.sendMessage("SOP-" + UUID.randomUUID().toString());
			i++;
			Thread.sleep(1000);
		}
		
		session.closeSession();
		
	}
	
}
