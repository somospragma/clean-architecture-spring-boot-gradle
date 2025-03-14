package co.com.theluguiant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CleanArchitectureSpringBootGradleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CleanArchitectureSpringBootGradleApplication.class, args);
	}

}
