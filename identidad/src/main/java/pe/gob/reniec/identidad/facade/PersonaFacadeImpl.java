package pe.gob.reniec.identidad.facade;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import pe.gob.reniec.identidad.entity.PersonaEntity;
import pe.gob.reniec.identidad.service.PersonaService;

@RestController
@RequestMapping("/persona")
public class PersonaFacadeImpl implements PersonaFacade{

	private static final Logger LOGGER = LogManager.getLogger(PersonaFacadeImpl.class);
    @Autowired
    private PersonaService personaService;

    @Override
    @GetMapping("/{dni}/dni")
    public List<PersonaEntity> findPersonaByDni(@PathVariable(name = "dni") String dni) throws Exception {
    	LOGGER.info("::findPersonaByDni:: {}", dni);
        try {
			return personaService.findPersonaByDni(dni);
		} catch (Exception e) {
			LOGGER.error(e);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("No se pudo completar la busqueda de persona por DNI: %d", dni) ) ;
		}
    }

    @Override
    @GetMapping("")
    public List<PersonaEntity> findAllPersona() throws Exception{
    	LOGGER.info("::findAllPersona::");
        try {
			return personaService.findAllPersona();
		} catch (Exception e) {
			LOGGER.error(e);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se puede listar las personas");
		}
    }

    @Override
    @GetMapping("/{nombre}/nombre")
    public List<PersonaEntity> findByName(@PathVariable(name = "nombre") String nombre)  throws Exception {
    	LOGGER.info("::findByName::");
        try {
			return personaService.findByNombreOrApellido(nombre);
		} catch (Exception e) {
			LOGGER.error(e);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se puede buscar persona por nombre");
		}
    }

    @Override
    @GetMapping("/{dni}/uniqueDni")
    public PersonaEntity findByUniqueDni(@PathVariable(name = "dni") String dni)  throws Exception {
    	LOGGER.info("::findByUniqueDni::");
        try {
			return personaService.findByUniqueDni(dni);
		} catch (Exception e) {
			LOGGER.error(e);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se puede buscar personas por DNI");
		}
    }

	@Override
	@GetMapping("/{personaId}/personaId")
	public PersonaEntity findByPersonaId(@PathVariable(name = "personaId")Long personaId)  throws Exception{
		LOGGER.info("::findByPersonaId::");
		try {
			return personaService.findByPersonId(personaId);
		} catch (Exception e) {
			LOGGER.error(e);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se puede listar personas");
		}
	}


}
