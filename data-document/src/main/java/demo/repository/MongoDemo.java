package demo.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mongodb.Mongo;

import core.Person;
import core.PersonRepository;

public class MongoDemo {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml", MongoDemo.class);
		
		// clear out old test data first
		Mongo mongo = context.getBean(Mongo.class);
		mongo.getDB("test").getCollection("people").drop();
		
		PersonRepository personRepository = context.getBean(PersonRepository.class);
		
		// add some people
		Person mark = new Person("Mark");
		Map<String, Object> marksPersonalInfo = new HashMap<String, Object>();
		marksPersonalInfo.put("Project Lead", "Spring Integration");
		marksPersonalInfo.put("Location", "Cambridge, MA");
		mark.setPersonalInfo(marksPersonalInfo);
		personRepository.add(mark);
		Person thomas = new Person("Thomas");
		Map<String, Object> thomasPersonalInfo = new HashMap<String, Object>();
		thomasPersonalInfo.put("Hobby", "photography");
		thomasPersonalInfo.put("Sport", "soccer");
		thomasPersonalInfo.put("Location", "Stratham, NH");
		thomas.setPersonalInfo(thomasPersonalInfo);
		personRepository.add(thomas);
		
		System.out.println("There are currently " + personRepository.count() + " people in the DB:");
		List<Person> people = personRepository.getAll();
		for (Person person : people) {
			System.out.println(person);
			if (person.getPersonalInfo().containsKey("Interests")) {
				System.out.println(person.getPersonalInfo().get("Interests").getClass().getName());
				System.out.println(person.getPersonalInfo().get("Interests"));
			}
		}

	}

}
