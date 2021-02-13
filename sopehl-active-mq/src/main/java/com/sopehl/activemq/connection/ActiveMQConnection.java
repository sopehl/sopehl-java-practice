package com.sopehl.activemq.connection;

import javax.jms.*;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.sopehl.activemq.model.ActiveMQConstants;

/**
 * <p> Provide the MQ connection {@link Connection}.
 * 
 * @author okan.pehlivan
 *
 */
public class ActiveMQConnection {

	private ConnectionFactory factory;
	
    public ActiveMQConnection() {
		super();
		this.factory = new ActiveMQConnectionFactory(ActiveMQConstants.ACTIVEMQ_BROKER_URL);
	}

	public Connection createAndStartNewConnection() {
		Connection connection = null;
    	try {
    		connection = this.factory.createConnection(ActiveMQConstants.ACTIVEMQ_USERNAME, ActiveMQConstants.ACTIVEMQ_PASSWORD);
    		connection.start();
		} catch (JMSException e) {
			System.err.println("JMS connection problem. Details:" + e);
		}
    	
    	return connection;
    }
	
}
