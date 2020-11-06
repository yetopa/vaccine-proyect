package pe.gob.reniec.identidad.repository;

import org.springframework.data.repository.CrudRepository;
import pe.gob.reniec.identidad.entity.PersonaEntity;

import java.util.List;

public interface PersonaRepository extends CrudRepository<PersonaEntity, Long> {

    /*@Query("SELECT p from PersonaEntity where p.dni like :dni")
    public List<PersonaEntity> getPersonaEntityByDni(String dni);*/

    public List<PersonaEntity> findByDniStartsWith(String dni);
}
