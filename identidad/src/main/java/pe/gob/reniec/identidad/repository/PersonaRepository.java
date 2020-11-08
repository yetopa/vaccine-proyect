package pe.gob.reniec.identidad.repository;

import org.springframework.data.repository.CrudRepository;
import pe.gob.reniec.identidad.entity.PersonaEntity;

import java.util.List;

public interface PersonaRepository extends CrudRepository<PersonaEntity, Long> {

    public PersonaEntity findByDni(String dni);
    public List<PersonaEntity> findByDniStartsWith(String dni);
    public List<PersonaEntity>
            findByNombreStartsWithOrApellidoPaternoStartsWithOrApellidoMaternoStartsWith
            (String nombre, String apellidoPaterno, String apellidoMaterno);
}
