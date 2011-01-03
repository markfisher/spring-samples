package demo;

import greeting.DefaultGreetingGenerator;
import greeting.GreetingGenerator;
import greeting.SimpleGreetingService;

public class SimpleDemo {

	public static void main(String[] args) {
		GreetingGenerator generator = new DefaultGreetingGenerator();
		SimpleGreetingService service = new SimpleGreetingService(generator);
		service.greet("World");
	}

}
