package pe.gob.minsa.vacuna.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.gob.minsa.vacuna.entity.PacienteEntity;
import pe.gob.minsa.vacuna.service.PacienteService;

@RestController
@RequestMapping(value = "/paciente")
public class PacienteFacadeImpl implements PacienteFacade{

	@Autowired
	private PacienteService pacienteService;
	
	@Override
	@GetMapping(value = "/byId/{pacienteId}")
	public PacienteEntity findById(@PathVariable(name = "pacienteId") Long pacienteId) {
		return pacienteService.findPacienteById(pacienteId);
	}

	@Override
	@PostMapping
	public PacienteEntity savePaciente(@RequestBody PacienteEntity entity) {
		return pacienteService.savePacienteEntity(entity);
	}

	@Override
	@GetMapping(value = "/byPersonaId/{personaId}")
	public PacienteEntity findByPersonaId(@PathVariable(name = "personaId") Integer personaId) {
		return pacienteService.findByPersonaId(personaId);
	}
	
	@Override
	@GetMapping
	public List<PacienteEntity> findAllPacientes(){
		return pacienteService.findAllPacientes();
	}

}
