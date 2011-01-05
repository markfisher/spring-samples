package demo.annotation;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import core.GreetingService;

public class SpringAnnotationDemo {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
		GreetingService service = context.getBean(GreetingService.class);
		service.greet("World");
	}

}
