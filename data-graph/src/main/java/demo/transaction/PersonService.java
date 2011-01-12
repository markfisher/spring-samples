package demo.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import core.Person;
import core.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;

	@Autowired
	private OtherService other;

	@Transactional
	public void addPeople() {
		this.repository.add(new Person("Larry"));
		this.repository.add(new Person("Curly"));
		this.repository.add(new Person("Moe"));
		other.execute();
	}

}
