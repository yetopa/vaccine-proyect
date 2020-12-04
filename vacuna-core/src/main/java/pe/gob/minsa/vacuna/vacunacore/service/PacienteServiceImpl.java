package pe.gob.minsa.vacuna.vacunacore.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import pe.gob.minsa.vacuna.vacunacore.dto.PacienteDTO;
import pe.gob.minsa.vacuna.vacunacore.dto.PersonaDTO;
import pe.gob.minsa.vacuna.vacunacore.utils.RestUtils;

@Service
public class PacienteServiceImpl extends ServiceBase implements PacienteService {

    private static final Logger LOGGER = LogManager.getLogger(RestUtils.class);

    
    @Override
    public List<PersonaDTO> findPersonaByDni(String dni) {
        Map pathVariable = new HashMap<>();
        pathVariable.put("dni",dni);
        Map header = new HashMap();
        List listPersonResponse = new ArrayList<>();
        List<PersonaDTO> lstPersonaDTP = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();

        try {
            listPersonResponse =  restUtils.callService(configurationProperties.url_reniec + "/persona/{dni}/dni", List.class, HttpMethod.GET, null, pathVariable, null, null, header );
            lstPersonaDTP = mapper.convertValue(listPersonResponse, new TypeReference<List<PersonaDTO>>() { });
            for (PersonaDTO p: lstPersonaDTP) {
                p.setEdadMeses(dateUtils.ageInMonths(p.getFechaNacimiento()));
            }
        } catch (Exception e){
            LOGGER.error("Error mientras se intento buscar  persona por DNI", e);
        }

        return lstPersonaDTP;
    }

    @Override
    public List<PersonaDTO> findPacienteByNames(String nombre) {
        Map pathVariable = new HashMap<>();
        pathVariable.put("nombre", nombre);
        Map header = new HashMap();
        List<PersonaDTO> listPerson = new ArrayList<>();

        try {
            listPerson =  restUtils.callService(configurationProperties.url_reniec + "/persona/{nombre}/nombre", List.class, HttpMethod.GET, null, pathVariable, null, null, header );
        } catch (Exception e){
            LOGGER.error("Error mientras se intento buscar  persona por Nombre", e);
        }

        return listPerson;
    }

    @Override
    public PersonaDTO findPacienteByUniqueDNI(String dni) {
        Map pathVariable = new HashMap<>();
        pathVariable.put("dni", dni);
        Map header = new HashMap();
        PersonaDTO personaDTO = new PersonaDTO();
        ObjectMapper mapper = new ObjectMapper();

        try {

            personaDTO = mapper.convertValue(
                    restUtils.callService(configurationProperties.url_reniec + "/persona/{dni}/uniqueDni", Object.class, HttpMethod.GET, null, pathVariable, null, null, header ),
                    PersonaDTO.class);
            personaDTO.setEdadMeses(dateUtils.ageInMonths(personaDTO.getFechaNacimiento()));
        } catch (Exception e){
            LOGGER.error("Error mientras se intento buscar  persona por DNI", e);
        }
        return personaDTO;
    }

	@Override
	public PacienteDTO findPacienteByPesonaId(Long personaId) {
		
		Map pathVariable = new HashMap<>();
        pathVariable.put("personaId",personaId);
        Map header = new HashMap();
        
        
        PersonaDTO personaDTO = new PersonaDTO();
        PacienteDTO pacienteDTO = new PacienteDTO();

        
        try {
        	personaDTO =  restUtils.callService(configurationProperties.url_reniec + "/persona/{personaId}/personaId", PersonaDTO.class, HttpMethod.GET, null, pathVariable, null, null, header );
        	if (personaDTO != null ) {
        		pathVariable.clear();
        		pathVariable.put("personaId", personaDTO.getPersonaId());
        		pacienteDTO = restUtils.callService(configurationProperties.url_dao_vacuna + "/paciente/byPersonaId/{personaId}", PacienteDTO.class, HttpMethod.GET, null, pathVariable, null, null, header );
        		if (pacienteDTO != null ) {
        			personaDTO.setEdadMeses(dateUtils.ageInMonths(personaDTO.getFechaNacimiento()));
        			pacienteDTO.setPersonaDTO(personaDTO);
        		}
        	}
            
        } catch (Exception e){
            LOGGER.error("Error mientras se intento buscar  paciente por personaId", e);
        }
        
		return pacienteDTO;
	}


}
