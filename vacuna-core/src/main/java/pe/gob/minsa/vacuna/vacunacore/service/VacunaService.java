package pe.gob.minsa.vacuna.vacunacore.service;

import java.util.List;

import pe.gob.minsa.vacuna.vacunacore.dto.CitaDTO;
import pe.gob.minsa.vacuna.vacunacore.dto.TriajeDTO;

public interface VacunaService {

	public TriajeDTO saveTriaje(TriajeDTO dto) ;
	public TriajeDTO validateTriajeByPersonaId(Long personaId);
	public CitaDTO saveCita(CitaDTO cita);
	public List<CitaDTO> listaCitas();
}
