package pe.gob.minsa.vacuna.vacunacore.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.gob.minsa.vacuna.vacunacore.dto.CitaDTO;
import pe.gob.minsa.vacuna.vacunacore.dto.TriajeDTO;
import pe.gob.minsa.vacuna.vacunacore.service.VacunaService;

@RestController
@RequestMapping(name = "/vacuna")
public class VacunaCoreRestImpl implements VacunaCoreRest {

	@Autowired
	private VacunaService vacunaService;
	
	@Override
	@PostMapping("/triaje")
	public TriajeDTO saveTriaje(@RequestBody TriajeDTO triajeDTO) {
		return vacunaService.saveTriaje(triajeDTO);
	}
	
	@Override
	@PostMapping("/cita")
	public CitaDTO saveCita(@RequestBody CitaDTO cita) {
		return vacunaService.saveCita(cita);
	}

	@Override
	@GetMapping("/cita")
	public List<CitaDTO> listaCitas() {
		return vacunaService.listaCitas();
	}

}
