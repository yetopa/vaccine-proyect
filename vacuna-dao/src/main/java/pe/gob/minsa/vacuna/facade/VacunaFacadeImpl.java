package pe.gob.minsa.vacuna.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.gob.minsa.vacuna.entity.PlanEntity;
import pe.gob.minsa.vacuna.entity.TriajeEntity;
import pe.gob.minsa.vacuna.service.VacunaService;

import java.util.List;

@RestController
@RequestMapping("/vacuna")
public class VacunaFacadeImpl implements VacunaFacade{

    @Autowired
    private VacunaService vacunaService;

    @Override
    @GetMapping("/lista")
    public List<PlanEntity> findPlanGroupVaccine() {
        return vacunaService.findPlanGroupVaccine();
    }

    @Override
    @GetMapping("/{descVacuna}/dosis")
    public List<PlanEntity> findByDescVacuna(@PathVariable(name = "descVacuna") String descVacuna) {
        return vacunaService.findByDescVacuna(descVacuna);
    }

	@Override
	@PostMapping("/triaje")
	public TriajeEntity saveTriaje(@RequestBody TriajeEntity entity) {
		return vacunaService.saveTriajeEntity(entity);
	}
}
