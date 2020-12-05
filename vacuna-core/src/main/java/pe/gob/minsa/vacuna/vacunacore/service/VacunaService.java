package pe.gob.minsa.vacuna.vacunacore.service;

import java.util.List;

import pe.gob.minsa.vacuna.vacunacore.dto.CitaDTO;
import pe.gob.minsa.vacuna.vacunacore.dto.CitaPersonaDTO;
import pe.gob.minsa.vacuna.vacunacore.dto.TriajeDTO;

public interface VacunaService {

	public TriajeDTO saveTriaje(TriajeDTO dto) throws Exception;
	public TriajeDTO validateTriajeByPersonaId(Long personaId) throws Exception;
	public CitaDTO saveCita(CitaDTO cita) throws Exception;
	public List<CitaDTO> listaCitas() throws Exception;
	public List<CitaPersonaDTO> listaCitasPersona() throws Exception;
}
