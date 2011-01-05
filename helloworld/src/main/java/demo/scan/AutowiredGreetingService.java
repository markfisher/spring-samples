package demo.scan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import core.GreetingGenerator;
import core.GreetingService;

@Service
public class AutowiredGreetingService implements GreetingService {

	private final GreetingGenerator generator;

	@Autowired
	public AutowiredGreetingService(GreetingGenerator generator) {
		Assert.notNull(generator, "generator is required");
		this.generator = generator;
	}

	public void greet(String name) {
		String greeting = generator.format(name);
		System.out.println(greeting);
	}

}
