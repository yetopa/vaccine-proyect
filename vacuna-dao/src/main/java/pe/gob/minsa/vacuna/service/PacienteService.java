package pe.gob.minsa.vacuna.service;

import pe.gob.minsa.vacuna.entity.PacienteEntity;

public interface PacienteService {

	public PacienteEntity savePacienteEntity(PacienteEntity entity);
	public PacienteEntity findPacienteById(Long pacienteId);
}
