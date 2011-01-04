package demo.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

	@Before("execution(* *..Bank.debit(..)) && args(accountId, amount)")
	public void logDebit(String accountId, double amount) {
		System.out.println("about to debit " + amount + " from " + accountId);
	}

	@Before("execution(* *..Bank.credit(..)) && args(accountId, amount)")
	public void logCredit(String accountId, double amount) {
		System.out.println("about to credit " + amount + " to " + accountId);
	}

}
