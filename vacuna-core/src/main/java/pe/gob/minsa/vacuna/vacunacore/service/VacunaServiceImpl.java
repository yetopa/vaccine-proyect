package pe.gob.minsa.vacuna.vacunacore.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import pe.gob.minsa.vacuna.vacunacore.dto.CitaDTO;
import pe.gob.minsa.vacuna.vacunacore.dto.CitaPersonaDTO;
import pe.gob.minsa.vacuna.vacunacore.dto.PacienteDTO;
import pe.gob.minsa.vacuna.vacunacore.dto.PersonaDTO;
import pe.gob.minsa.vacuna.vacunacore.dto.TriajeDTO;
import pe.gob.minsa.vacuna.vacunacore.utils.RestUtils;

@Service
public class VacunaServiceImpl extends ServiceBase implements VacunaService {

	private static final Logger LOGGER = LogManager.getLogger(RestUtils.class);
	
	@Autowired
	private PacienteService pacienteService;
    
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
	
	@Override
	public List<CitaPersonaDTO> listaCitasPersona() {
		
		List<CitaPersonaDTO> listacitas = new ArrayList<>();
		
		try {
			Map pathVariable = new HashMap<>();
	        Map header = new HashMap();
	        
			List liscitas =  restUtils.callService(configurationProperties.url_dao_vacuna + "/vacuna/cita", List.class, HttpMethod.GET, null, pathVariable, null, null, header );
			ObjectMapper mapper = new ObjectMapper();
			
			List<CitaDTO> listaMapped  = mapper.convertValue(liscitas, new TypeReference<List<CitaDTO>>() { });
			for(CitaDTO c : listaMapped) {
				PacienteDTO paciente = pacienteService.findPacienteByPesonaId(c.getPersona_id());
				CitaPersonaDTO cita = new CitaPersonaDTO();
				cita.setApellidoMaterno(paciente.getPersonaDTO().getApellidoMaterno());
				cita.setApellidoPaterno(paciente.getPersonaDTO().getApellidoPaterno());
				cita.setCitaId(c.getCita_id());
				cita.setDni(paciente.getPersonaDTO().getDni());
				cita.setEdadMeses(paciente.getPersonaDTO().getEdadMeses());
				cita.setFechaNacimiento(paciente.getPersonaDTO().getFechaNacimiento());
				cita.setFecha(c.getFecha());
				cita.setNombre(paciente.getPersonaDTO().getNombre());
				cita.setSexo(paciente.getPersonaDTO().getSexo());
				listacitas.add(cita);
			};
			
		 } catch (Exception e) {
	        	LOGGER.error("Error mientras se intento listar  citas de personas", e);
	        	
			}
		
		return listacitas;
	}

}
