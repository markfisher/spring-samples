package core;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.keyvalue.redis.connection.RedisConnectionFactory;
import org.springframework.data.keyvalue.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

@Repository
public class RedisHashPersonRepository implements PersonRepository {
	
	public static final String REDIS_KEY_PREFIX = "core.Person::";

	public static final String REDIS_KEY_PATTERN = REDIS_KEY_PREFIX + "*";

	private final StringRedisTemplate redisTemplate;

	@Autowired
	private RedisHashPersonRepository(RedisConnectionFactory connectionFactory) {
		Assert.notNull(connectionFactory, "RedisConnectionFactory is required");
		this.redisTemplate = new StringRedisTemplate();
		this.redisTemplate.setConnectionFactory(connectionFactory);
	}

	public int count() {
		return this.redisTemplate.keys(REDIS_KEY_PATTERN).size();
	}

	public List<Person> getAll() {
		Set<String> keys = this.redisTemplate.keys(REDIS_KEY_PATTERN);
		List<Person> people = new ArrayList<Person>();
		for (String k : keys) {
			Object name = this.redisTemplate.getHashOps().get(k, "name");
			Person p = new Person(name != null ? name.toString() : "?");
			Object city = this.redisTemplate.getHashOps().get(k, "city");
			if (city != null) {
				p.setCity(city.toString());
			}
			Object state = this.redisTemplate.getHashOps().get(k, "state");
			if (state != null) {
				p.setState(state.toString());
			}
			people.add(p);
		}
		return people;
	}

	public void add(Person person) {
		// create a unique key for the hash set
		String keyToUse = REDIS_KEY_PREFIX + person.getName();
		this.redisTemplate.getHashOps().set(keyToUse, "name", person.getName());
		if (person.getCity() != null) {
			this.redisTemplate.getHashOps().set(keyToUse, "city", person.getCity());
		}
		if (person.getState() != null) {
			this.redisTemplate.getHashOps().set(keyToUse, "state", person.getState());
		}
	}

}
