package pe.gob.minsa.vacuna.vacunacore.rest;

import pe.gob.minsa.vacuna.vacunacore.dto.PacienteDTO;
import pe.gob.minsa.vacuna.vacunacore.dto.PersonaDTO;

import java.util.List;

public interface PacienteCoreRest {

    List<PersonaDTO> findPacienteByDni(String dni) throws Exception;
    List<PersonaDTO> findPacienteByNombre(String dni)throws Exception;
    PersonaDTO findPacienteByUniqueDni(String dni)throws Exception;
    PacienteDTO findPacienteByPersonaId(Long personaId)throws Exception;

}
