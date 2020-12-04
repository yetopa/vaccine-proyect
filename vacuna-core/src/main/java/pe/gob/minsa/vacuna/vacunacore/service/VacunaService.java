package pe.gob.minsa.vacuna.vacunacore.service;

import pe.gob.minsa.vacuna.vacunacore.dto.TriajeDTO;

public interface VacunaService {

	public TriajeDTO saveTriaje(TriajeDTO dto) ;
	public TriajeDTO validateTriajeByPersonaId(Long personaId);
}
