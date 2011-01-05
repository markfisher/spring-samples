package core;

import org.springframework.web.client.RestTemplate;

public class RestClientDemo {

	public static void main(String[] args) {
		RestTemplate template = new RestTemplate();
		String result = template.getForObject("http://localhost:8080/mvc", String.class);
		System.out.println(result);
	}

}
