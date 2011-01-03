package demo.annotation;

import greeting.GreetingService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAnnotationDemo {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
		GreetingService service = context.getBean(GreetingService.class);
		service.greet("World");
	}

}
