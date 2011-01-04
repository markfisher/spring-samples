package demo.xml;

import org.aspectj.lang.JoinPoint;

public class LoggingAdvice {

	public void log(JoinPoint jp) {
		System.out.println("about to " + jp.getSignature().getName());
	}

}
