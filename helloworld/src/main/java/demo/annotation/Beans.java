package demo.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import core.DefaultGreetingGenerator;
import core.GreetingGenerator;
import core.GreetingService;
import core.SimpleGreetingService;

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
