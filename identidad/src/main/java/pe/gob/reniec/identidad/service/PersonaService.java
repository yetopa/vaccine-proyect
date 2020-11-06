package pe.gob.reniec.identidad.service;

import pe.gob.reniec.identidad.entity.PersonaEntity;

import java.util.List;

public interface PersonaService {

    public List<PersonaEntity> findPersonaByDni(String dni);
    public List<PersonaEntity> findAllPersona();
}
