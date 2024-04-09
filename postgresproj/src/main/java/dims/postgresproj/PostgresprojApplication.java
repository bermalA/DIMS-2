package dims.postgresproj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class PostgresprojApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostgresprojApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**") // Apply CORS to all endpoints
						.allowedOrigins("*") // Allow requests from any origin
						.allowedMethods("GET", "POST", "PUT", "DELETE") // Allow specified methods
						.allowedHeaders("*"); // Allow all headers
			}
		};
	}
}
