package pe.gob.reniec.identidad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.gob.reniec.identidad.entity.PersonaEntity;
import pe.gob.reniec.identidad.repository.PersonaRepository;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService{

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public List<PersonaEntity> findPersonaByDni(String dni) {
        return personaRepository.findByDniStartsWith(dni);
    }

    @Override
    public List<PersonaEntity> findAllPersona() {
        return (List<PersonaEntity>) personaRepository.findAll();
    }

    @Override
    public List<PersonaEntity> findByNombreOrApellido(String nombre) {
        return personaRepository.findByNombreStartsWithOrApellidoPaternoStartsWithOrApellidoMaternoStartsWith(
                nombre, nombre, nombre
        );
    }

    @Override
    public PersonaEntity findByUniqueDni(String dni) {
        return personaRepository.findByDni(dni);
    }
}
