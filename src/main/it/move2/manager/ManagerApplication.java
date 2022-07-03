package it.move2.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagerApplication.class, args);
		System.out.println(System.getenv("EXAMPLE_ENVIRONMENT_KEY"));
	}

}
