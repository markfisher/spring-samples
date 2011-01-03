package amqp;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RabbitDemo {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("amqp/config.xml");
		AmqpTemplate template = context.getBean(AmqpTemplate.class);
		template.convertAndSend("samples.queue", "Hello AMQP");
	}

}
