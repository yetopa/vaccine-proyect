package pe.gob.reniec.identidad.facade;

import pe.gob.reniec.identidad.entity.PersonaEntity;

import java.util.List;

public interface PersonaFacade {

    public List<PersonaEntity> findPersonaByDni(String dni) throws Exception;
    public List<PersonaEntity> findAllPersona() throws Exception;
    public List<PersonaEntity> findByName(String nombre) throws Exception;
    public PersonaEntity findByUniqueDni(String dni) throws Exception;
    public PersonaEntity findByPersonaId(Long personaId) throws Exception;
}
