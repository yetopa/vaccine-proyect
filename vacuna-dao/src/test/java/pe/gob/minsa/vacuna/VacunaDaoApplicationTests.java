package pe.gob.minsa.vacuna;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
@ComponentScan(basePackages = {
		"pe.gob.minsa.vacuna"
		})
class VacunaDaoApplicationTests{



}
