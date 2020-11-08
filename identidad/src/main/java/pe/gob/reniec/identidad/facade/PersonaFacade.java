package pe.gob.reniec.identidad.facade;

import pe.gob.reniec.identidad.entity.PersonaEntity;

import java.util.List;

public interface PersonaFacade {

    public List<PersonaEntity> findPersonaByDni(String dni);
    public List<PersonaEntity> findAllPersona();
    public List<PersonaEntity> findByName(String nombre);
    public PersonaEntity findByUniqueDni(String dni);
}
