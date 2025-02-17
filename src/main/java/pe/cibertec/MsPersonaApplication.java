package pe.cibertec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableDiscoveryClient
public class MsPersonaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsPersonaApplication.class, args);
		System.out.println("ms-persona iniciado correctamente");
	}

}
