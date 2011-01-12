package core;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.document.mongodb.MongoTemplate;
import org.springframework.data.document.mongodb.SimpleMongoConverter;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.mongodb.Mongo;

@Repository
public class MongoPersonRepository implements PersonRepository {

	private final MongoTemplate mongoDbTemplate;

	@Autowired
	private MongoPersonRepository(Mongo mongo) {
		Assert.notNull(mongo, "Mongo is required");
		mongoDbTemplate = new MongoTemplate(mongo, "test", new SimpleMongoConverter());
	}

	public int count() {
		return (int) this.mongoDbTemplate.getCollection("people").count();
	}

	public List<Person> getAll() {
		return this.mongoDbTemplate.getCollection("people", Person.class);
	}

	public void add(Person person) {
		this.mongoDbTemplate.insert("people", person);
	}

}
