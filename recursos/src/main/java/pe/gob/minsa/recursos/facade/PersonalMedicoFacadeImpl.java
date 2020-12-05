package pe.gob.minsa.recursos.facade;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import pe.gob.minsa.recursos.entity.PersonalMedicoEntity;
import pe.gob.minsa.recursos.service.PersonalMedicoService;

@RestController("/personalMedico")
public class PersonalMedicoFacadeImpl implements PersonalMedicoFacade {

	private static final Logger LOGGER = LogManager.getLogger(PersonalMedicoFacadeImpl.class);
	
	@Autowired
	private PersonalMedicoService personalMedicoService;
	
	@Override
	@GetMapping
	public List<PersonalMedicoEntity> listaPersonalMedico() throws Exception {
		LOGGER.info(":: listaPersonalMedico :: ");
		try {
			return personalMedicoService.listaPersonalMedico();
		} catch (Exception e) {
			LOGGER.error(e);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"No se puede guardar al personal medico");
		}
		
	}

}
