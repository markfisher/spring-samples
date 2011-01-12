package core;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.keyvalue.redis.connection.RedisConnectionFactory;
import org.springframework.data.keyvalue.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

@Repository
public class RedisSetPersonRepository implements PersonRepository {

	public static final String REDIS_KEY = "core.Person";
	
	private final RedisTemplate<String, Person> personTemplate;

	@Autowired
	private RedisSetPersonRepository(RedisConnectionFactory connectionFactory) {
		Assert.notNull(connectionFactory, "RedisConnectionFactory is required");
		this.personTemplate = new RedisTemplate<String, Person>(connectionFactory);
	}

	public int count() {
		return personTemplate.getSetOps().size(REDIS_KEY).intValue();
	}

	public List<Person> getAll() {
		Set<Person> peeps = this.personTemplate.getSetOps().members(REDIS_KEY);
		List<Person> people = new ArrayList<Person>();
		for (Person p : peeps) {
			people.add(p);
		}
		return people;
	}

	public void add(Person person) {
		this.personTemplate.getSetOps().add(REDIS_KEY, person);
	}

}
