package core;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.graph.neo4j.finder.FinderFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

@Repository
public class Neo4jPersonRepository implements PersonRepository {

	private FinderFactory finderFactory;

	@Autowired
	private Neo4jPersonRepository(FinderFactory finderFactory) {
		Assert.notNull(finderFactory, "FinderFactory is required");
		this.finderFactory = finderFactory;
	}

	public int count() {
		return (int) this.finderFactory.getFinderForClass(Person.class).count();
	}

	public List<Person> getAll() {
		List<Person> people = new ArrayList<Person>();
		for (Person p :  this.finderFactory.getFinderForClass(Person.class).findAll()) {
			people.add(p);
		}
		return people;
	}

	public void add(Person person) {
		// no need to call this - added when new Person() is called
	}

}
