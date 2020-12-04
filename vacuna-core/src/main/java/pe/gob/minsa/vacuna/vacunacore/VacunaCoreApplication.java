package pe.gob.minsa.vacuna.vacunacore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@SpringBootApplication
public class VacunaCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(VacunaCoreApplication.class, args);
	}

	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2).select().
				apis(RequestHandlerSelectors.basePackage("pe.gob.minsa.vacuna.vacunacore.rest")).
				// apis(RequestHandlerSelectors.any()).
				paths(PathSelectors.any()).build();
	}
}
