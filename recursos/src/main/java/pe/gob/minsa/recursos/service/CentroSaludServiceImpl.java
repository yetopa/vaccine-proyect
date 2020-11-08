package pe.gob.minsa.recursos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.gob.minsa.recursos.entity.CentroSaludEntity;
import pe.gob.minsa.recursos.entity.PersonalMedicoEntity;
import pe.gob.minsa.recursos.repository.CentroSaludRepository;
import pe.gob.minsa.recursos.repository.PersonallMedicoRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CentroSaludServiceImpl implements CentroSaludService{

    @Autowired
    private CentroSaludRepository centroSaludRepository;

    @Autowired
    private PersonallMedicoRepository personallMedicoRepository;

    @Override
    public List<CentroSaludEntity> findByName(String name) {
        return centroSaludRepository.findByNombreCentroSaludStartsWith(name);
    }

    @Override
    public List<PersonalMedicoEntity> findPersonalMedicoByCentroSalud(CentroSaludEntity centroSaludEntity) {

        return personallMedicoRepository.findByCentroSaludByCentroSaludId(centroSaludEntity);
    }

    @Override
    public List<CentroSaludEntity> findCentroSaludByPersonalMedico(Integer personalMedicoId) {
        return personallMedicoRepository.findCentroSaludByPersonaId(personalMedicoId.intValue());
    }

    @Override
    public PersonalMedicoEntity savePersonalMedico(PersonalMedicoEntity personalMedicoEntity) {
        return personallMedicoRepository.save(personalMedicoEntity);
    }
}
