package pe.gob.reniec.identidad.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.reniec.identidad.entity.PersonaEntity;
import pe.gob.reniec.identidad.repository.PersonaRepository;

@Service
public class PersonaServiceImpl implements PersonaService{

	private static final Logger LOGGER = LogManager.getLogger(PersonaServiceImpl.class);
	
    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public List<PersonaEntity> findPersonaByDni(String dni) throws Exception {
    		LOGGER.info("::findPersonaByDni:: {}", dni);
			return personaRepository.findByDniStartsWith(dni);
    }

    @Override
    public List<PersonaEntity> findAllPersona() throws Exception{
    	LOGGER.info("::findAllPersona::");
        return (List<PersonaEntity>) personaRepository.findAll();
    }

    @Override
    public List<PersonaEntity> findByNombreOrApellido(String nombre) throws Exception{
    	LOGGER.info("::findByNombreOrApellido::");
        return personaRepository.findByNombreStartsWithOrApellidoPaternoStartsWithOrApellidoMaternoStartsWith(
                nombre, nombre, nombre
        );
    }

    @Override
    public PersonaEntity findByUniqueDni(String dni) throws Exception{
    	LOGGER.info("::findByUniqueDni::");
        return personaRepository.findByDni(dni);
    }

	@Override
	public PersonaEntity findByPersonId(Long personaId) throws Exception{
		LOGGER.info("::findByPersonId::");
		return personaRepository.findByPersonaId(personaId);
	}
}
