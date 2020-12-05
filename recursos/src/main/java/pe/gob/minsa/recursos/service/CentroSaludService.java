package pe.gob.minsa.recursos.service;

import pe.gob.minsa.recursos.entity.CentroSaludEntity;
import pe.gob.minsa.recursos.entity.PersonalMedicoEntity;

import java.util.List;

public interface CentroSaludService {

    public List<CentroSaludEntity> findByName(String name) throws Exception;
    public List<PersonalMedicoEntity> findPersonalMedicoByCentroSalud(CentroSaludEntity centroSaludEntity) throws Exception;
    public List<CentroSaludEntity> findCentroSaludByPersonalMedico(Integer personalMedicoId) throws Exception;
    public PersonalMedicoEntity savePersonalMedico(PersonalMedicoEntity personalMedicoEntity) throws Exception;
	List<CentroSaludEntity> listaCentroSalud() throws Exception;


}

