package demo.xml;

import greeting.GreetingService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringXmlDemo {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("demo/xml/beans.xml");
		GreetingService service = context.getBean(GreetingService.class);
		service.greet("World");
	}

}
