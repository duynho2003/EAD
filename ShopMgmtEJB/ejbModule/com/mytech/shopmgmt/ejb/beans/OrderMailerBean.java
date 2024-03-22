package com.mytech.shopmgmt.ejb.beans;

import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.jms.MapMessage;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;

/**
 * Message-Driven Bean implementation class for: OrderMailerBean
 */
@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/orderMessageTopic2208a"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "jakarta.jms.Queue") }, messageListenerInterface = MessageListener.class)
public class OrderMailerBean implements MessageListener {

	/**
	 * Default constructor.
	 */
	public OrderMailerBean() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see MessageListener#onMessage(Message)
	 */
	public void onMessage(Message message) {

		try {
			if (message instanceof MapMessage) {
				MapMessage mailerMessage = (MapMessage) message;
				System.out.println("------------onMessage------------");
				System.out.println("From: " + message.getStringProperty("from".toString()));
				System.out.println("To: " + message.getStringProperty("to".toString()));
				System.out.println("Subject: " + message.getStringProperty("subject".toString()));
				System.out.println("Content: " + message.getStringProperty("content".toString()));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
