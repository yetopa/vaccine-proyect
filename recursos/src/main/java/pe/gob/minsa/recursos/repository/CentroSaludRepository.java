package pe.gob.minsa.recursos.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pe.gob.minsa.recursos.entity.CentroSaludEntity;
import pe.gob.minsa.recursos.entity.PersonalMedicoEntity;

import java.util.List;
import java.util.Set;

public interface CentroSaludRepository extends CrudRepository<CentroSaludEntity, Integer> {


    public List<CentroSaludEntity> findByNombreCentroSaludStartsWith(String nombreCentroSalud);


}
