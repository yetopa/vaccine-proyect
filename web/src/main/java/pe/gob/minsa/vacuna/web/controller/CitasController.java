package pe.gob.minsa.vacuna.web.controller;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import pe.gob.minsa.vacuna.web.bean.CitaDTO;
import pe.gob.minsa.vacuna.web.bean.CitaPersonaDTO;
import pe.gob.minsa.vacuna.web.bean.ResponseBaseBean;
import pe.gob.minsa.vacuna.web.message.RabbitMQSender;
import pe.gob.minsa.vacuna.web.utils.ConfigurationProperties;
import pe.gob.minsa.vacuna.web.utils.RestUtils;

@Controller
public class CitasController extends BaseController{

    private static final Logger LOGGER = LogManager.getLogger(Dashboard.class);

    @Autowired
    private RestUtils restUtils;

    @Autowired
    private ConfigurationProperties configurationProperties;
    
   @Autowired
   RabbitMQSender rabbitSender;
       
    
	@RequestMapping(value="/citas", method= RequestMethod.GET)
	public ModelAndView citas() {
		LOGGER.info("load citas ... ");
        ModelAndView modelo = new ModelAndView("appview/citas/citas");
        return modelo;
	}
	
    @RequestMapping(value="/citas/lista/show", method=RequestMethod.GET)
    public String listaCita(Model modelo) throws Exception {
        LOGGER.info("load lista citas...");
        
        Map<String, Object> pathVariable = new HashMap<>();
        Map<String, String> header = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        
        List<CitaPersonaDTO> citas;
        try {
        	citas = restUtils.callService(configurationProperties.url_vacuna_core + "/cita/personas", List.class, HttpMethod.GET, null, pathVariable, null, null, header );
        	modelo.addAttribute(KEY_MODEL_LISTA_CITAS,citas);
            modelo.addAttribute(KEY_MODEL_LISTA_CITAS_SIZE, citas.size());
            modelo.addAttribute("updatedate", Calendar.getInstance().getTime());
            return "appview/citas/listaCitas";
        } catch (Exception e) {
        	LOGGER.error(e);
    		this.getResponseBaseBean().setCode(CODE_RESPONSE_ERROR);
            getResponseBaseBean().setMessage(e.getMessage());
            throw new Exception("Error al intentar listar citas");
		}
        
        
    }
    
    @RequestMapping(value = "/citas", method = RequestMethod.POST)
    public @ResponseBody ResponseBaseBean saveTriaje(@RequestBody CitaDTO cita) {
    	try {
    		rabbitSender.send(cita);
        	this.getResponseBaseBean().setCode(CODE_SUCCESS);
    	} catch (Exception e) {
    		LOGGER.error(e);
    		this.getResponseBaseBean().setCode(CODE_RESPONSE_ERROR);
            getResponseBaseBean().setMessage(e.getMessage());
		}
    	return getResponseBaseBean();
    }
    
    
    
	
	
}
