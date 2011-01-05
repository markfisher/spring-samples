package core;

import org.springframework.util.Assert;

public class SimpleGreetingService implements GreetingService {

	private final GreetingGenerator generator;

	public SimpleGreetingService(GreetingGenerator generator) {
		Assert.notNull(generator, "generator is required");
		this.generator = generator;
	}

	public void greet(String name) {
		String greeting = generator.format(name);
		System.out.println(greeting);
	}

}
