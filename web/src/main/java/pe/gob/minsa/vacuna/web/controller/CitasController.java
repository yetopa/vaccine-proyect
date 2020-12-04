package pe.gob.minsa.vacuna.web.controller;

import java.util.Calendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import pe.gob.minsa.vacuna.web.bean.CitaDTO;
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
    public ModelAndView showSearchCustomer(){
        LOGGER.info("load lista citas...");
        ModelAndView modelo = new ModelAndView("appview/citas/lista");
        modelo.addObject("updatedate", Calendar.getInstance().getTime());
        return modelo;
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
