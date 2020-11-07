package pe.gob.minsa.vacuna.vacunacore.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationProperties {

    @Value("${service.reniec.url}")
    public String url_reniec;

    @Value("${service.minsa.url}")
    public String url_minsa;
}
