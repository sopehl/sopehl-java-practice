package com.sopehl.activemq;

import javax.jms.Connection;
import javax.jms.MessageConsumer;

import com.sopehl.activemq.connection.ActiveMQConnection;
import com.sopehl.activemq.connection.ActiveMQListener;
import com.sopehl.activemq.connection.ActiveMQSession;
import com.sopehl.activemq.model.ActiveMQConstants;

/**
 * Main class to trigger consumer listener
 * 
 * @author okan.pehlivan
 *
 */
public class ActiveMQConsumer {
	
	public static void main(String[] args) {
		/**
		 * Main structure:
		 * 
		 * createConnection -> session -> createConsumer -> listen(queue or topic)
		 * 
		 */
		ActiveMQConnection connection = new ActiveMQConnection();
		Connection mqConnection = connection.createAndStartNewConnection();
		
		ActiveMQSession session = new ActiveMQSession(mqConnection);
		
		MessageConsumer consumer = session.createNewConsumer(mqConnection, ActiveMQConstants.MESSAGE_QUEUE_NAME);
		
		ActiveMQListener messageListener = new ActiveMQListener();
		messageListener.startToListenMessage(consumer);
	}
	
}
