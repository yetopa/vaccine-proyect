package pe.gob.minsa.recursos.facade;

import java.util.List;

import pe.gob.minsa.recursos.entity.PersonalMedicoEntity;

public interface PersonalMedicoFacade {

	public List<PersonalMedicoEntity> listaPersonalMedico() throws Exception;
}
