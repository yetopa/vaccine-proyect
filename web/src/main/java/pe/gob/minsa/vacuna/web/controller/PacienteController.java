package pe.gob.minsa.vacuna.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import pe.gob.minsa.vacuna.web.bean.PacienteDTO;
import pe.gob.minsa.vacuna.web.bean.ResponseBaseBean;
import pe.gob.minsa.vacuna.web.utils.ConfigurationProperties;
import pe.gob.minsa.vacuna.web.utils.RestUtils;

@Controller
public class PacienteController extends BaseController {

    private static final Logger LOGGER = LogManager.getLogger(Dashboard.class);

    @Autowired
    private RestUtils restUtils;

    @Autowired
    private ConfigurationProperties configurationProperties;

    @RequestMapping(value = "/paciente/{dni}/byDni" , method = RequestMethod.GET)
    public @ResponseBody
    ResponseBaseBean
    searchPacienteByDni(@PathVariable(name = "dni") String dni){


        try {
            Map<String, Object> pathVariable = new HashMap<>();
            pathVariable.put("dni",dni);
            PacienteDTO pacientes;
            Map<String, String> header = new HashMap<>();
            ObjectMapper mapper = new ObjectMapper();

            pacientes =
                 mapper.convertValue(restUtils.callService(configurationProperties.url_vacuna_core + "/paciente/{dni}/uniqueDni", PacienteDTO.class, HttpMethod.GET, null, pathVariable, null, null, header ),
                        PacienteDTO.class);

            this.getResponseBaseBean().setData(pacientes);

        } catch (Exception e){
            this.getResponseBaseBean().setCode(CODE_RESPONSE_ERROR);
            getResponseBaseBean().setMessage(e.getMessage());
        }
        return  getResponseBaseBean();
    }

}
