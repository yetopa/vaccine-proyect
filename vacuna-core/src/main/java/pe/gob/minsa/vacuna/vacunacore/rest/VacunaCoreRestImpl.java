package pe.gob.minsa.vacuna.vacunacore.rest;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import pe.gob.minsa.vacuna.vacunacore.dto.CitaDTO;
import pe.gob.minsa.vacuna.vacunacore.dto.CitaPersonaDTO;
import pe.gob.minsa.vacuna.vacunacore.dto.TriajeDTO;
import pe.gob.minsa.vacuna.vacunacore.service.VacunaService;

@RestController
@RequestMapping(name = "/vacuna")
public class VacunaCoreRestImpl implements VacunaCoreRest {

	private static final Logger LOGGER = LogManager.getLogger(VacunaCoreRestImpl.class);
	
	@Autowired
	private VacunaService vacunaService;
	
	@Override
	@PostMapping("/triaje")
	public TriajeDTO saveTriaje(@RequestBody TriajeDTO triajeDTO) throws Exception {
		LOGGER.info(":: saveTriaje :: {}", triajeDTO.toString());
		try {
			return vacunaService.saveTriaje(triajeDTO);
		} catch (Exception e) {
			LOGGER.error(e);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("No se pudo guardar triaje") ) ;
		}
	}
	
	@Override
	@PostMapping("/cita")
	public CitaDTO saveCita(@RequestBody CitaDTO cita) throws Exception {
		LOGGER.info(":: saveCita :: {}", cita.toString());
		try {
			return vacunaService.saveCita(cita);
		} catch (Exception e) {
			LOGGER.error(e);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("No se pudo guardar triaje") ) ;
		}
	}

	@Override
	@GetMapping("/cita")
	public List<CitaDTO> listaCitas() throws Exception {
		LOGGER.info(":: listaCitas :: ");
		try {
			return vacunaService.listaCitas();
		} catch (Exception e) {
			LOGGER.error(e);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("No se pudo guardar triaje") ) ;
		}
	}
	
	@Override
	@GetMapping("/cita/personas")
	public List<CitaPersonaDTO> listaCitasPersona(){
		LOGGER.info(":: listaCitasPersona :: ");
		try {
			return vacunaService.listaCitasPersona();
		} catch (Exception e) {
			LOGGER.error(e);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("No se pudo guardar triaje") ) ;
		}
	}

}
