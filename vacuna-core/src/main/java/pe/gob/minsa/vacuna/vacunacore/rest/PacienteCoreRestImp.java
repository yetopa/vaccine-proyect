package pe.gob.minsa.vacuna.vacunacore.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.minsa.vacuna.vacunacore.dto.PersonaDTO;
import pe.gob.minsa.vacuna.vacunacore.service.PacienteService;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteCoreRestImp implements PacienteCoreRest{

    @Autowired
    private PacienteService pacienteService;

    @Override
    @GetMapping("/{dni}/dni")
    public List<PersonaDTO> findPacienteByDni(@PathVariable(name = "dni") String dni) {
        return pacienteService.findPacienteByDni(dni);
    }

    @Override
    @GetMapping("/{nombre}/nombre")
    public List<PersonaDTO> findPacienteByNombre(@PathVariable(name = "nombre") String nombre) {
        return pacienteService.findPacienteByNames(nombre);
    }
}
