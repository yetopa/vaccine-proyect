package pe.gob.minsa.vacuna.service;

import java.util.List;

import pe.gob.minsa.vacuna.entity.PacienteEntity;

public interface PacienteService {

	public PacienteEntity savePacienteEntity(PacienteEntity entity);
	public PacienteEntity findPacienteById(Long pacienteId);
	public PacienteEntity findByPersonaId(Integer personaId);
	public List<PacienteEntity> findAllPacientes();
}
