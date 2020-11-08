package pe.gob.minsa.vacuna.vacunacore.service;

import pe.gob.minsa.vacuna.vacunacore.dto.PersonaDTO;

import java.util.List;

public interface PacienteService {

    public List<PersonaDTO> findPacienteByDni(String dni);
    public List<PersonaDTO> findPacienteByNames(String nombre);
    public PersonaDTO findPacienteByUniqueDNI(String dni);
}
