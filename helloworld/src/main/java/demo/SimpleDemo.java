package demo;

import core.DefaultGreetingGenerator;
import core.GreetingGenerator;
import core.SimpleGreetingService;

public class SimpleDemo {

	public static void main(String[] args) {
		GreetingGenerator generator = new DefaultGreetingGenerator();
		SimpleGreetingService service = new SimpleGreetingService(generator);
		service.greet("World");
	}

}
