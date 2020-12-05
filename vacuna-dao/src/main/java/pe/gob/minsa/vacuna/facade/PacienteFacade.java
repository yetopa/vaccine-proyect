package pe.gob.minsa.vacuna.facade;

import java.util.List;

import pe.gob.minsa.vacuna.entity.PacienteEntity;

public interface PacienteFacade {
	
	public PacienteEntity findById(Long pacienteId);
	public PacienteEntity savePaciente(PacienteEntity entity);
	public PacienteEntity findByPersonaId(Integer personaId);
	public List<PacienteEntity> findAllPacientes();

}
