package pe.gob.minsa.vacuna.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.gob.minsa.vacuna.web.bean.PacienteDTO;
import pe.gob.minsa.vacuna.web.bean.ResponseBaseBean;
import pe.gob.minsa.vacuna.web.utils.ConfigurationProperties;
import pe.gob.minsa.vacuna.web.utils.RestUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                 mapper.convertValue(restUtils.callService(configurationProperties.url_reniec + "/paciente/{dni}/uniqueDni", PacienteDTO.class, HttpMethod.GET, null, pathVariable, null, null, header ),
                        PacienteDTO.class);

            this.getResponseBaseBean().setData(pacientes);

        } catch (Exception e){
            this.getResponseBaseBean().setCode(CODE_RESPONSE_ERROR);
            getResponseBaseBean().setMessage(e.getMessage());
            e.printStackTrace();
        }
        return  getResponseBaseBean();
    }

}
