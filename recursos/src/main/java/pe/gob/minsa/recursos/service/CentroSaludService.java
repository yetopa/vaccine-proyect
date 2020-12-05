package pe.gob.minsa.recursos.service;

import pe.gob.minsa.recursos.entity.CentroSaludEntity;
import pe.gob.minsa.recursos.entity.PersonalMedicoEntity;

import java.util.List;

public interface CentroSaludService {

    public List<CentroSaludEntity> findByName(String name);
    public List<PersonalMedicoEntity> findPersonalMedicoByCentroSalud(CentroSaludEntity centroSaludEntity);
    public List<CentroSaludEntity> findCentroSaludByPersonalMedico(Integer personalMedicoId);
    public PersonalMedicoEntity savePersonalMedico(PersonalMedicoEntity personalMedicoEntity);


}

