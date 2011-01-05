package demo.scan;

import org.springframework.stereotype.Component;

import core.GreetingGenerator;

@Component
public class AnnotatedGreetingGenerator implements GreetingGenerator {

	public String format(String name) {
		return "Hello " + name;
	}

}
