package demo.transaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import core.PersonRepository;

public class TxDemo {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml", TxDemo.class);
		PersonRepository repository = context.getBean(PersonRepository.class);
		PersonService service = context.getBean(PersonService.class);
		System.out.println("before: " + repository.count());
		try {
			service.addPeople();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("after: " + repository.count());
	}

}
