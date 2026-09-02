package in.strikes.crudSpringBootDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class CrudSpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringBootDemoApplication.class, args);
	}
}
