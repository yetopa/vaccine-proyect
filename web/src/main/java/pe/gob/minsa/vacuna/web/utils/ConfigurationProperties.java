package pe.gob.minsa.vacuna.web.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationProperties {

    @Value("${service.core.vacuna.url}")
    public String url_vacuna_core;
    
}
