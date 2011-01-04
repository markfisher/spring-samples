package demo.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import core.Bank;

public class AnnotationDemo {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml", AnnotationDemo.class);
		Bank bank = context.getBean(Bank.class);
		bank.credit("abc", 100);
		bank.debit("abc", 99.99);
	}

}
