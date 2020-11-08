package pe.gob.minsa.recursos.facade;

import pe.gob.minsa.recursos.entity.CentroSaludEntity;
import pe.gob.minsa.recursos.entity.PersonalMedicoEntity;

import java.util.List;

public interface CentroSaludFacade {
    public PersonalMedicoEntity savePersonalMedico(PersonalMedicoEntity personalMedicoEntity);
    public List<CentroSaludEntity> findCentroSaludByPersonalMedicoId(Integer personalMedicoId);
}
