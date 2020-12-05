package pe.gob.minsa.vacuna.vacunacore.rest;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import pe.gob.minsa.vacuna.vacunacore.dto.PacienteDTO;
import pe.gob.minsa.vacuna.vacunacore.dto.PersonaDTO;
import pe.gob.minsa.vacuna.vacunacore.service.PacienteService;

@RestController
@RequestMapping("/paciente")
public class PacienteCoreRestImp implements PacienteCoreRest{

	private static final Logger LOGGER = LogManager.getLogger(PacienteCoreRestImp.class);
	
    @Autowired
    private PacienteService pacienteService;

    @Override
    @GetMapping("/{dni}/dni")
    public List<PersonaDTO> findPacienteByDni(@PathVariable(name = "dni") String dni) throws Exception {
    	LOGGER.info(":: findPacienteByDni :: {}", dni);
		try {
			return pacienteService.findPersonaByDni(dni);
		} catch (Exception e) {
			LOGGER.error(e);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"No se puede guardar al paciente");
		}
    }

    @Override
    @GetMapping("/{nombre}/nombre")
    public List<PersonaDTO> findPacienteByNombre(@PathVariable(name = "nombre") String nombre)throws Exception {
    	LOGGER.info(":: findPacienteByNombre :: {}", nombre);
    	try {
    		return pacienteService.findPacienteByNames(nombre);    		
    	} catch (Exception e) {
			LOGGER.error(e);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"No se puede encontrar la paciente por nombre");
		}
    }

    @Override
    @GetMapping("/{dni}/uniqueDni")
    public PersonaDTO findPacienteByUniqueDni(@PathVariable(name = "dni")  String dni)throws Exception {
    	LOGGER.info(":: findPacienteByUniqueDni :: {}", dni);
        try {
        	return pacienteService.findPacienteByUniqueDNI(dni);
        } catch (Exception e) {
			LOGGER.error(e);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"No se puede encontra al paciente por DNI");
		}
    }

	@Override
	@GetMapping("{personaId}/personaId")
	public PacienteDTO findPacienteByPersonaId(@PathVariable(name = "personaId") Long personaId) throws Exception {
		LOGGER.info(":: findPacienteByPersonaId :: {}", personaId);
		try {
			return pacienteService.findPacienteByPesonaId( personaId);
			
		} catch (Exception e) {
			LOGGER.error(e);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"No se puede encontrar al paciente por person Id ");
		}
	}
}
