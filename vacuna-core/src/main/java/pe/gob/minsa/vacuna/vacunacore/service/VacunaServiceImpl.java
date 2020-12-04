package pe.gob.minsa.vacuna.vacunacore.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import pe.gob.minsa.vacuna.vacunacore.dto.TriajeDTO;
import pe.gob.minsa.vacuna.vacunacore.utils.RestUtils;

@Service
public class VacunaServiceImpl extends ServiceBase implements VacunaService {

	private static final Logger LOGGER = LogManager.getLogger(RestUtils.class);
    
	@Override
	public TriajeDTO saveTriaje(TriajeDTO dto) {
		Map pathVariable = new HashMap<>();
        Map header = new HashMap();
        
        TriajeDTO triajeDTO = new TriajeDTO();
        ObjectMapper mapper = new ObjectMapper();

        try {
        	triajeDTO =  restUtils.callService(configurationProperties.url_dao_vacuna + "/vacuna/triaje", TriajeDTO.class, HttpMethod.POST, dto, pathVariable, null, null, header );
        } catch (Exception e){
            LOGGER.error("Error mientras se intento guardar  triaje", e);
        }
		return triajeDTO;
	}

	@Override
	public TriajeDTO validateTriajeByPersonaId(Long personaId) {
		return null;
	}

}
