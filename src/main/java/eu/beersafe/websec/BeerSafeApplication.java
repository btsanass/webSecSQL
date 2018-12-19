package eu.beersafe.websec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"eu.beersafe.websec", "eu.beersafe.websec.controllers", "eu.beersafe.websec.data"})
public class BeerSafeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeerSafeApplication.class, args);
	}
}
