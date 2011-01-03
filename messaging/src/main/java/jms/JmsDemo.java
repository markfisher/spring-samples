package jms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

public class JmsDemo {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("jms/config.xml");
		JmsTemplate template = context.getBean(JmsTemplate.class);
		template.convertAndSend("samples.queue", "Hello JMS");
	}

}
