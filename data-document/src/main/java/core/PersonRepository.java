package core;

import java.util.List;

public interface PersonRepository {

	int count();

	List<Person> getAll();

	void add(Person person);

}
