package core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcDemo {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml", JdbcDemo.class);
		PersonRepository personRepository = context.getBean(PersonRepository.class);
		System.out.println(personRepository.count());
	}

}
