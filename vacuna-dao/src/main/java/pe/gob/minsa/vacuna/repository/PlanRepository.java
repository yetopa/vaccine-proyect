package pe.gob.minsa.vacuna.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pe.gob.minsa.vacuna.entity.PlanEntity;

import java.util.List;

public interface PlanRepository extends CrudRepository<PlanEntity, Long> {

    @Query("Select p from PlanEntity p group by descVacuna")
    public List<PlanEntity> findPlanGroupVaccine();
    
    @Query("Select p from PlanEntity p where p.descVacuna = ?1")
    public List<PlanEntity> findByDescVacuna(String descVacuna);
}
