package core;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class TestBean {

	public TestBean(String someArg) {
		log("constructed with " + someArg);
	}

	public void setSomeProperty(String someProperty) {
		log("setting " + someProperty);
	}

	@PostConstruct
	public void init() {
		log("init");
	}

	@PreDestroy
	public void close() {
		log("close");
	}

	private void log(String s) {
		System.out.println(this.getClass().getName() + ":" + s);
	}

}
