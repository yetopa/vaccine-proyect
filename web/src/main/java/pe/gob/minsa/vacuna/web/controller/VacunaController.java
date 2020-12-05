package pe.gob.minsa.vacuna.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import pe.gob.minsa.vacuna.web.bean.PacienteDTO;
import pe.gob.minsa.vacuna.web.bean.ResponseBaseBean;
import pe.gob.minsa.vacuna.web.bean.TriajeDTO;
import pe.gob.minsa.vacuna.web.utils.ConfigurationProperties;
import pe.gob.minsa.vacuna.web.utils.RestUtils;

@Controller
public class VacunaController extends BaseController {

	private static final Logger LOGGER = LogManager.getLogger(VacunaController.class);
	
	@Autowired
    private RestUtils restUtils;
	
	
	@Autowired
    private ConfigurationProperties configurationProperties;
	
	@RequestMapping(value = "/vacuna/triaje", method = RequestMethod.POST)
	public @ResponseBody ResponseBaseBean saveTriaje(@RequestBody TriajeDTO triajeDTO) {
		
		try {
			Map<String, Object> pathVariable = new HashMap<>();
            Map<String, String> header = new HashMap<>();
            TriajeDTO triajeReturn = new TriajeDTO();
            Map<String, Object> pacienteDTO ;
            ObjectMapper mapper = new ObjectMapper();
            
            pathVariable.put("personaId", triajeDTO.getPersonaId());
            pacienteDTO =
                    mapper.convertValue(restUtils.callService(configurationProperties.url_vacuna_core + "/paciente/{personaId}/personaId", Map.class, HttpMethod.GET,null, pathVariable, null, null, header ),
                           Map.class);
            if (pacienteDTO != null &&  pacienteDTO.get("pacienteId") != null) {
            	triajeDTO.setPacienteId(Long.valueOf((Integer) pacienteDTO.get("pacienteId")));
            	triajeReturn =
            			mapper.convertValue(restUtils.callService(configurationProperties.url_vacuna_core + "/triaje", TriajeDTO.class, HttpMethod.POST, triajeDTO, pathVariable, null, null, header ),
            					TriajeDTO.class);            	
            	this.getResponseBaseBean().setData(triajeReturn);
            	this.getResponseBaseBean().setCode(CODE_SUCCESS);
            } else {
    			this.getResponseBaseBean().setCode(CODE_RESPONSE_ERROR);
                getResponseBaseBean().setMessage("No se encontro el paciente");
            }
            
		} catch (Exception e) {
			LOGGER.error(e);
			this.getResponseBaseBean().setCode(CODE_RESPONSE_ERROR);
            getResponseBaseBean().setMessage(e.getMessage());
		}
		return getResponseBaseBean();
	}
}
