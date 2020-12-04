package pe.gob.minsa.vacuna.vacunacore.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import pe.gob.minsa.vacuna.vacunacore.dto.CitaDTO;
import pe.gob.minsa.vacuna.vacunacore.dto.PersonaDTO;
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

	@Override
	public CitaDTO saveCita(CitaDTO cita) {
		
		Map pathVariable = new HashMap<>();
        Map header = new HashMap();
        
        CitaDTO citaDTO = new CitaDTO();
        
        ObjectMapper mapper = new ObjectMapper();
        
        try {
        	citaDTO =  restUtils.callService(configurationProperties.url_dao_vacuna + "/vacuna/cita", CitaDTO.class, HttpMethod.POST, cita, pathVariable, null, null, header );
        } catch (Exception e) {
        	LOGGER.error("Error mientras se intento guardar  triaje", e);
		}
		return cita;
	}

	@Override
	public List<CitaDTO> listaCitas() {
		
		Map pathVariable = new HashMap<>();
        Map header = new HashMap();
        
        List<CitaDTO> liscitas = new ArrayList<>();
		
        try {
        	liscitas =  restUtils.callService(configurationProperties.url_dao_vacuna + "/vacuna/cita", List.class, HttpMethod.GET, null, pathVariable, null, null, header );
        } catch (Exception e) {
        	LOGGER.error("Error mientras se intento listar  citas", e);
        	
		}
		return liscitas;
	}

}
