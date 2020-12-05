package pe.gob.minsa.recursos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.gob.minsa.recursos.entity.CentroSaludEntity;

public interface CentroSaludRepository extends JpaRepository<CentroSaludEntity, Integer> {


    public List<CentroSaludEntity> findByNombreCentroSaludStartsWith(String nombreCentroSalud) throws Exception;
    

}
