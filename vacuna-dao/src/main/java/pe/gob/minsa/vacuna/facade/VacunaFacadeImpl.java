package pe.gob.minsa.vacuna.facade;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.gob.minsa.vacuna.entity.CitaEntity;
import pe.gob.minsa.vacuna.entity.PlanEntity;
import pe.gob.minsa.vacuna.entity.TriajeEntity;
import pe.gob.minsa.vacuna.service.VacunaService;

@RestController
@RequestMapping("/vacuna")
public class VacunaFacadeImpl implements VacunaFacade{
	
	private static final Logger LOGGER = LogManager.getLogger(VacunaFacadeImpl.class);
	

    @Autowired
    private VacunaService vacunaService;

    @Override
    @GetMapping("/lista")
    public List<PlanEntity> findPlanGroupVaccine() {
    	LOGGER.info(":: findPlanGroupVaccine :: ");
        return vacunaService.findPlanGroupVaccine();
    }

    @Override
    @GetMapping("/{descVacuna}/dosis")
    public List<PlanEntity> findByDescVacuna(@PathVariable(name = "descVacuna") String descVacuna) {
    	LOGGER.info(":: findByDescVacuna :: {}", descVacuna);
        return vacunaService.findByDescVacuna(descVacuna);
    }

	@Override
	@PostMapping("/triaje")
	public TriajeEntity saveTriaje(@RequestBody TriajeEntity entity) {
		LOGGER.info(":: saveTriaje :: {}", entity);
		return vacunaService.saveTriajeEntity(entity);
	}

	@Override
	@GetMapping("cita")
	public List<CitaEntity> listaCitas() {
		LOGGER.info(":: listaCitas :: ");
		return vacunaService.listaCita();
	}
	
	@Override
	@PostMapping("cita")
	public CitaEntity saveCitas(@RequestBody CitaEntity cita) {
		LOGGER.info(":: saveCitas :: {}", cita);
		return vacunaService.saveCita(cita);
	}
}
