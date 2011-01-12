package demo.repository;

import java.util.Collections;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.keyvalue.redis.connection.RedisConnectionFactory;
import org.springframework.data.keyvalue.redis.core.RedisTemplate;

import core.Person;
import core.PersonRepository;
import core.RedisSetPersonRepository;

public class RedisSetDemo {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml", RedisSetDemo.class);
		
		// clear out old test data first
		RedisConnectionFactory connectionFactory = context.getBean(RedisConnectionFactory.class);
		new RedisTemplate<String, Person>(connectionFactory)
				.delete(Collections.singletonList(RedisSetPersonRepository.REDIS_KEY));
		
		PersonRepository personRepository = context.getBean(RedisSetPersonRepository.class);
		
		// add some people
		Person mark = new Person("Mark");
		mark.setCity("Cambridge");
		mark.setState("MA");
		personRepository.add(mark);
		Person thomas = new Person("Thomas");
		thomas.setState("NH");
		personRepository.add(thomas);
		
		System.out.println("There are currently " + personRepository.count() + " people in the DB:");
		List<Person> people = personRepository.getAll();
		for (Person person : people) {
			System.out.println(person);
		}

	}

}
