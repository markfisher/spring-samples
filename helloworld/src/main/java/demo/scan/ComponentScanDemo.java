package demo.scan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import core.GreetingService;

public class ComponentScanDemo {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml", ComponentScanDemo.class);
		GreetingService service = context.getBean(GreetingService.class);
		service.greet("World");
	}
}
