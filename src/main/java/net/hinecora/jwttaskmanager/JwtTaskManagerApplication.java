package net.hinecora.jwttaskmanager;

import net.hinecora.jwttaskmanager.auth.AuthenticationService;
import net.hinecora.jwttaskmanager.auth.RegisterRequest;
import net.hinecora.jwttaskmanager.task.Priority;
import net.hinecora.jwttaskmanager.task.Status;
import net.hinecora.jwttaskmanager.task.TaskRequest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import static net.hinecora.jwttaskmanager.user.Role.ADMIN;
import static net.hinecora.jwttaskmanager.user.Role.MANAGER;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class JwtTaskManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtTaskManagerApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			AuthenticationService service
	) {
		return args -> {
			var admin = RegisterRequest.builder()
					.firstName("Admin")
					.lastName("Admin")
					.email("admin@mail.com")
					.password("password")
					.role(ADMIN)
					.build();
			System.out.println("Admin token: " + service.register(admin).getAccessToken());

			var manager = RegisterRequest.builder()
					.firstName("Admin")
					.lastName("Admin")
					.email("manager@mail.com")
					.password("password")
					.role(MANAGER)
					.build();
			System.out.println("Manager token: " + service.register(manager).getAccessToken());
		};
	}

}
