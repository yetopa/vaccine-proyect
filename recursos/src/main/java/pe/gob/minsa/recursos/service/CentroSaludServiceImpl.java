package pe.gob.minsa.recursos.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.minsa.recursos.entity.CentroSaludEntity;
import pe.gob.minsa.recursos.entity.PersonalMedicoEntity;
import pe.gob.minsa.recursos.repository.CentroSaludRepository;
import pe.gob.minsa.recursos.repository.PersonallMedicoRepository;

@Service
public class CentroSaludServiceImpl implements CentroSaludService{

	private static final Logger LOGGER = LogManager.getLogger(CentroSaludServiceImpl.class);
	
    @Autowired
    private CentroSaludRepository centroSaludRepository;

    @Autowired
    private PersonallMedicoRepository personallMedicoRepository;

    @Override
    public List<CentroSaludEntity> findByName(String name) throws Exception{
    	LOGGER.info("::findByName :: {}", name);
        return centroSaludRepository.findByNombreCentroSaludStartsWith(name);
    }

    @Override
    public List<PersonalMedicoEntity> findPersonalMedicoByCentroSalud(CentroSaludEntity centroSaludEntity) throws Exception{
    	LOGGER.info("::findByName :: {}", centroSaludEntity);
        return personallMedicoRepository.findByCentroSaludByCentroSaludId(centroSaludEntity);
    }

    @Override
    public List<CentroSaludEntity> findCentroSaludByPersonalMedico(Integer personalMedicoId) throws Exception{
    		LOGGER.info("::findCentroSaludByPersonalMedico :: {}", personalMedicoId);
			return personallMedicoRepository.findCentroSaludByPersonaId(personalMedicoId.intValue());
    }

    @Override
    public PersonalMedicoEntity savePersonalMedico(PersonalMedicoEntity personalMedicoEntity) throws Exception{
    	LOGGER.info("::savePersonalMedico :: {}", personalMedicoEntity);
        return personallMedicoRepository.save(personalMedicoEntity);
    }
    
    @Override
    public List<CentroSaludEntity> listaCentroSalud () throws Exception {
    	LOGGER.info("::listaCentroSalud ::");
    	return  centroSaludRepository.findAll();
    }
}
