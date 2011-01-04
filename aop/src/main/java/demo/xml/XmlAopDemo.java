package demo.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import core.Bank;

public class XmlAopDemo {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("demo/xml/config.xml");
		Bank bank = context.getBean(Bank.class);
		bank.credit("abc", 100);
	}

}
