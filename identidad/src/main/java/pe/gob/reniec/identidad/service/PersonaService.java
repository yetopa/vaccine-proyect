package pe.gob.reniec.identidad.service;

import pe.gob.reniec.identidad.entity.PersonaEntity;

import java.util.List;

public interface PersonaService {

    public List<PersonaEntity> findPersonaByDni(String dni) throws Exception;
    public List<PersonaEntity> findAllPersona() throws Exception;;
    public List<PersonaEntity> findByNombreOrApellido(String nombre) throws Exception;;
    public PersonaEntity findByUniqueDni(String dni) throws Exception;;
    public PersonaEntity findByPersonId(Long personaId) throws Exception;;
}
