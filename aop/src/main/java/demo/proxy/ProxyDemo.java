package demo.proxy;

import org.springframework.aop.framework.ProxyFactory;

import core.Bank;
import core.StubBank;

public class ProxyDemo {

	public static void main(String[] args) {
		StubBank target = new StubBank();
		LoggingAdvice advice = new LoggingAdvice();
		ProxyFactory pf = new ProxyFactory(target);
		pf.addAdvice(advice);
		Bank bank = (Bank) pf.getProxy();
		bank.debit("abc", 100);
		bank.credit("abc", 200);
	}

}
