package pe.gob.minsa.vacuna.vacunacore.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import pe.gob.minsa.vacuna.vacunacore.dto.PersonaDTO;
import pe.gob.minsa.vacuna.vacunacore.utils.ConfigurationProperties;
import pe.gob.minsa.vacuna.vacunacore.utils.DateUtils;
import pe.gob.minsa.vacuna.vacunacore.utils.RestUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PacienteServiceImpl implements PacienteService {

    private static final Logger LOGGER = LogManager.getLogger(RestUtils.class);

    @Autowired
    private RestUtils restUtils;

    @Autowired
    private DateUtils dateUtils;

    @Autowired
    private ConfigurationProperties configurationProperties;

    @Override
    public List<PersonaDTO> findPacienteByDni(String dni) {
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
                p.setEdadMeses(dateUtils.diffInMonths(p.getFechaNacimiento()));
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
}
