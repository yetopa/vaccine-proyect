package pe.gob.minsa.vacuna.vacunacore.rest;

import java.util.List;

import pe.gob.minsa.vacuna.vacunacore.dto.CitaDTO;
import pe.gob.minsa.vacuna.vacunacore.dto.CitaPersonaDTO;
import pe.gob.minsa.vacuna.vacunacore.dto.TriajeDTO;

public interface VacunaCoreRest {

	
	public TriajeDTO saveTriaje(TriajeDTO triajeDTO);

	public CitaDTO saveCita(CitaDTO cita);
	
	public List<CitaDTO> listaCitas();

	public List<CitaPersonaDTO> listaCitasPersona();
}
