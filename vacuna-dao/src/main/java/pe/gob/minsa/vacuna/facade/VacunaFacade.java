package pe.gob.minsa.vacuna.facade;

import pe.gob.minsa.vacuna.entity.CitaEntity;
import pe.gob.minsa.vacuna.entity.PlanEntity;
import pe.gob.minsa.vacuna.entity.TriajeEntity;

import java.util.List;

public interface VacunaFacade {

    public List<PlanEntity> findPlanGroupVaccine();
    public List<PlanEntity> findByDescVacuna(String descVacuna);
    public TriajeEntity saveTriaje(TriajeEntity entity);
    public List<CitaEntity> listaCitas();
    public CitaEntity saveCitas(CitaEntity cita);
}
