package com.sopehl.activemq.connection;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;

import org.apache.activemq.command.ActiveMQTextMessage;

/**
 * <p>Listen the broker(queue or topic) by MQ consumer
 * 
 * @author okan.pehlivan
 *
 */
public class ActiveMQListener implements MessageListener{

	public void onMessage(Message message) {
		 if (message instanceof ActiveMQTextMessage) {
             ActiveMQTextMessage textMessage = (ActiveMQTextMessage) message;
              try {
                  System.out.println(textMessage.getText());
              } catch (JMSException e) {
                  e.printStackTrace();
              }
          }	
	}
	
	public void startToListenMessage(MessageConsumer consumer) {
		try {
			consumer.setMessageListener(this);
		} catch (JMSException e) {
			System.out.println("JMS listening problem. Detail: " + e);
		}
	}

}
