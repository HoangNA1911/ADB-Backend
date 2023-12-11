package dental_clinic.dental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class DentalApplication {

	public static void main(String[] args) {
		SpringApplication.run(DentalApplication.class, args);
	}



}
