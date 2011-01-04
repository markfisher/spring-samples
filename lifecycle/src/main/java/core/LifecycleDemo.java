package core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifecycleDemo {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml", LifecycleDemo.class);
		System.out.println("getting 'testBean'");
		Object bean = context.getBean("testBean");
		System.out.println("got: " + bean);
	}

}
