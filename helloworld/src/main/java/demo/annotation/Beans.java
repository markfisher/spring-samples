package demo.annotation;

import greeting.DefaultGreetingGenerator;
import greeting.GreetingGenerator;
import greeting.GreetingService;
import greeting.SimpleGreetingService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {

	@Bean
	public GreetingService service() {
		return new SimpleGreetingService(generator());
	}

	@Bean
	public GreetingGenerator generator() {
		return new DefaultGreetingGenerator();
	}

}
