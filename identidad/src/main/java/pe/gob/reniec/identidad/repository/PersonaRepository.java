package pe.gob.reniec.identidad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pe.gob.reniec.identidad.entity.PersonaEntity;

public interface PersonaRepository extends CrudRepository<PersonaEntity, Long> {

    public PersonaEntity findByDni(String dni)throws Exception;
    public List<PersonaEntity> findByDniStartsWith(String dni) throws Exception;
    public List<PersonaEntity>
            findByNombreStartsWithOrApellidoPaternoStartsWithOrApellidoMaternoStartsWith
            (String nombre, String apellidoPaterno, String apellidoMaterno)throws Exception;
    
    @Query("select p from PersonaEntity p where personaId =:personaId")
    public PersonaEntity findByPersonaId( Long personaId)throws Exception;
}
