package pe.gob.minsa.vacuna.vacunacore.rest;

import pe.gob.minsa.vacuna.vacunacore.dto.PacienteDTO;
import pe.gob.minsa.vacuna.vacunacore.dto.PersonaDTO;

import java.util.List;

public interface PacienteCoreRest {

    List<PersonaDTO> findPacienteByDni(String dni);
    List<PersonaDTO> findPacienteByNombre(String dni);
    PersonaDTO findPacienteByUniqueDni(String dni);
    PacienteDTO findPacienteByPersonaId(Long personaId);

}
