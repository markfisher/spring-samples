package demo.repository;

import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.keyvalue.redis.connection.RedisConnectionFactory;
import org.springframework.data.keyvalue.redis.core.RedisTemplate;

import core.Person;
import core.PersonRepository;
import core.RedisHashPersonRepository;

public class RedisHashDemo {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml", RedisHashDemo.class);
		
		// clear out old test data first
		RedisConnectionFactory connectionFactory = context.getBean(RedisConnectionFactory.class);
		RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>(connectionFactory);
		Set<String> keys = redisTemplate.keys(RedisHashPersonRepository.REDIS_KEY_PATTERN);
		if (keys != null && keys.size() > 0) {
			redisTemplate.delete(keys);
		}
		
		PersonRepository personRepository = context.getBean(RedisHashPersonRepository.class);
		
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
