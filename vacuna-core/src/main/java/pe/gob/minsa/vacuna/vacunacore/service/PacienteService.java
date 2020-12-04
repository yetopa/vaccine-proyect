package pe.gob.minsa.vacuna.vacunacore.service;

import pe.gob.minsa.vacuna.vacunacore.dto.PacienteDTO;
import pe.gob.minsa.vacuna.vacunacore.dto.PersonaDTO;

import java.util.List;

public interface PacienteService {

    public List<PersonaDTO> findPersonaByDni(String dni);
    public List<PersonaDTO> findPacienteByNames(String nombre);
    public PersonaDTO findPacienteByUniqueDNI(String dni);
    public PacienteDTO findPacienteByPesonaId(Long personaId);
}
