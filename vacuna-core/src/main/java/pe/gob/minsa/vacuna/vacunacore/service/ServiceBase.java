package pe.gob.minsa.vacuna.vacunacore.service;

import org.springframework.beans.factory.annotation.Autowired;

import pe.gob.minsa.vacuna.vacunacore.utils.ConfigurationProperties;
import pe.gob.minsa.vacuna.vacunacore.utils.DateUtils;
import pe.gob.minsa.vacuna.vacunacore.utils.RestUtils;

public class ServiceBase {

    @Autowired
    protected RestUtils restUtils;

    @Autowired
    protected DateUtils dateUtils;
    
    @Autowired
    protected ConfigurationProperties configurationProperties;
}
