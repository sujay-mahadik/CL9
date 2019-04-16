import javax.jms.*;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Publisher {
	private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
	
	public static void main(String[] args) throws JMSException {
		ConnectionFactory connectionfactory = new ActiveMQConnectionFactory(url);
		Connection connection = connectionfactory.createConnection();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Topic topic = session.createTopic("CL9");
		
		MessageProducer producer = session.createProducer(topic);
		
		TextMessage message = session.createTextMessage();
		message.setText("This is new Message from Publisher");
		
		producer.send(message);
		
		System.out.println("Sent Message: " + message.getText());
		
		connection.close();
	}
}

