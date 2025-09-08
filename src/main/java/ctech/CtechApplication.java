package ctech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "ctech")
public class CtechApplication {

	public static void main(String[] args) {
		SpringApplication.run(CtechApplication.class, args);
	}

}
