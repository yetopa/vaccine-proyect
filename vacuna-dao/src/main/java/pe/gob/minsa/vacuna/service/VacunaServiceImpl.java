package pe.gob.minsa.vacuna.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.minsa.vacuna.entity.CitaEntity;
import pe.gob.minsa.vacuna.entity.PlanEntity;
import pe.gob.minsa.vacuna.entity.TriajeEntity;
import pe.gob.minsa.vacuna.repository.CitaRepository;
import pe.gob.minsa.vacuna.repository.PlanRepository;
import pe.gob.minsa.vacuna.repository.TriajeRepository;

import java.util.List;

@Service
public class VacunaServiceImpl implements VacunaService{

    @Autowired
    private PlanRepository planRepository;
    
    @Autowired
    private TriajeRepository triajeRepository;
    
    @Autowired
    private CitaRepository citaRepository;

    @Override
    public List<PlanEntity> findPlanGroupVaccine() {
        return planRepository.findPlanGroupVaccine();
    }

    @Override
    public List<PlanEntity> findByDescVacuna(String descVacuna) {
        return planRepository.findByDescVacuna(descVacuna);
    }

	@Override
	public TriajeEntity saveTriajeEntity(TriajeEntity entity) {
		return triajeRepository.save(entity);
	}

	@Override
	public List<CitaEntity> listaCita() {
		return (List<CitaEntity>) citaRepository.findAll();
	}

	@Override
	public CitaEntity saveCita(CitaEntity cita) {
		return citaRepository.save(cita);
	}


}
