package ma.emsi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "ma.emsi.model")
public class ClassManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClassManagementApplication.class, args);
	}

}
