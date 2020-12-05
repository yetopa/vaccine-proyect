package pe.gob.minsa.recursos.facade;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import pe.gob.minsa.recursos.entity.CentroSaludEntity;
import pe.gob.minsa.recursos.entity.PersonalMedicoEntity;
import pe.gob.minsa.recursos.service.CentroSaludService;

@RestController
@RequestMapping("/centroSalud")
public class CentroSaludFacadeImpl implements CentroSaludFacade {
	
	private static final Logger LOGGER = LogManager.getLogger(CentroSaludFacadeImpl.class);

    @Autowired
    private CentroSaludService centroSaludService;

    @Override
    @PostMapping("/medico")
    public PersonalMedicoEntity savePersonalMedico(@RequestBody PersonalMedicoEntity personalMedicoEntity) throws Exception{
    	LOGGER.info(":: savePersonalMedico :: {}", personalMedicoEntity);
        try {
			return centroSaludService.savePersonalMedico(personalMedicoEntity);
		} catch (Exception e) {
			LOGGER.error(e);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"No se puede guardar al personal medico");
		}
    }

    @Override
        @GetMapping("/{personalMedicoId}/byPersonId")
    public List<CentroSaludEntity> findCentroSaludByPersonalMedicoId(@PathVariable(name = "personalMedicoId") Integer personalMedicoId) throws Exception{
    	LOGGER.info(":: findCentroSaludByPersonalMedicoId :: {}", personalMedicoId);
        try {
			return centroSaludService.findCentroSaludByPersonalMedico(personalMedicoId);
		} catch (Exception e) {
			LOGGER.error(e);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se puede encontrar el centro de salud");
		}
    }
    
    @Override
    @GetMapping
    public List<CentroSaludEntity> listarCentrosSalud () throws Exception{
    	try {
    		return centroSaludService.listaCentroSalud();
    	} catch (Exception e) {
    		LOGGER.error(e);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se puede listar los centros de salud .. :(");
		}
    }
}
