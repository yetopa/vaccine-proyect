package pe.gob.minsa.vacuna.service;

import pe.gob.minsa.vacuna.entity.CitaEntity;
import pe.gob.minsa.vacuna.entity.PlanEntity;
import pe.gob.minsa.vacuna.entity.TriajeEntity;

import java.util.List;

public interface VacunaService {

    public List<PlanEntity> findPlanGroupVaccine();

    public List<PlanEntity> findByDescVacuna(String descVacuna);
    
    public TriajeEntity saveTriajeEntity(TriajeEntity entity);
    
    public List<CitaEntity> listaCita();

	public CitaEntity saveCita(CitaEntity cita);
}
