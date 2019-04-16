import java.io.IOException;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Subscriber {
	private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
	
	public static void main(String[] args) throws JMSException {
		ConnectionFactory connectionfactory = new ActiveMQConnectionFactory(url);
		Connection connection = connectionfactory.createConnection();
		connection.start();
		
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Topic topic = session.createTopic("CL9");
		
		MessageConsumer consumer = session.createConsumer(topic);
		MessageListener listner = new MessageListener() {
			public void onMessage(Message message) {
				try {
					if(message instanceof TextMessage) {
						TextMessage textMessage = (TextMessage) message;
						System.out.println("Received Message: " + textMessage.getText());
						
					}
					
				}
				catch(JMSException e) {
					e.printStackTrace();
				}
			}
		};
		consumer.setMessageListener(listner);
		try {
			System.in.read();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		connection.close();
	}
}