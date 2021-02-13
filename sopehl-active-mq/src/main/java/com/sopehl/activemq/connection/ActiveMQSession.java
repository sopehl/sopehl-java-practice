package com.sopehl.activemq.connection;

import javax.jms.*;

/**
 * <p> Provides the MQ session and producer/consumer to send/listen the message queue.
 * 
 * @author okan.pehlivan
 *
 */
public class ActiveMQSession {

	private Session currentSession;
	
	public ActiveMQSession(Connection connection) {
		this.currentSession = this.createNewSession(connection);
	}
	
	public Session getCurrentSession() {
		return this.currentSession;
	}
	
	private Session createNewSession(Connection connection) {
		try {
			this.currentSession = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
		} catch (JMSException e) {
			System.out.println("JMS session creation problem. Details:" + e);
		}
		
		return this.currentSession;
	}

	private Destination createNewQueueDestination(String queueName) {
		Destination destionation = null;
		
		try {
			destionation = this.currentSession.createQueue(queueName);
		} catch (JMSException e) {
			System.out.println("JMS destination creation problem. Details:" + e);
		}
		
		return destionation;
	}
	
	public MessageProducer createNewProducer(Connection connection, String queueName) {
		Session session = this.createNewSession(connection);
		Destination destination = this.createNewQueueDestination(queueName);

		MessageProducer messageProducer = null;
		try {
			messageProducer = session.createProducer(destination);
		} catch (JMSException e) {
			System.out.println("JMS producer creation problem. Details:" + e);
		}
		
		return messageProducer;
	}
	
	public MessageConsumer createNewConsumer(Connection connection, String queueName) {
		Session session = this.createNewSession(connection);
		Destination destination = this.createNewQueueDestination(queueName);

		MessageConsumer messageConsumer = null;
		try {
			messageConsumer = session.createConsumer(destination);
		} catch (JMSException e) {
			System.out.println("JMS producer creation problem. Details:" + e);
		}
		
		return messageConsumer;
	}
	
	public void closeSession() {
		try {
			this.currentSession.close();
		} catch (JMSException e) {
			System.out.println("JMS session close problem. Details:" + e);
		}
	}
	
}
