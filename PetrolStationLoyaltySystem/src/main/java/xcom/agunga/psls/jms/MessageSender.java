/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xcom.agunga.psls.jms;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author agunga
 */
public class MessageSender {
    
    public void sendMessage(String message) {
        try {
            InitialContext initialContext = new InitialContext();
 
            QueueConnectionFactory queueConnectionFactory  = (QueueConnectionFactory) initialContext.lookup("java:jboss/exported/jms/agungaConnectionFactory");
            QueueConnection connection = queueConnectionFactory.createQueueConnection("agunga2", "@chris21");
            connection.start();
            QueueSession queueSession = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
            Queue queue = (Queue) initialContext.lookup("default");
            QueueSender queueSender = queueSession.createSender(queue);
            TextMessage textMessage = queueSession.createTextMessage();
            textMessage.setText(message);
            queueSender.send(textMessage);
            System.out.println("Message Queued fot Sending.");
        } catch (NamingException | JMSException ex) {
            System.out.println("Exception : " + ex.getMessage()); 
        }
    }

}
