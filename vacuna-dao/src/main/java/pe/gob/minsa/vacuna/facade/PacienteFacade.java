package pe.gob.minsa.vacuna.facade;

import pe.gob.minsa.vacuna.entity.PacienteEntity;

public interface PacienteFacade {
	
	public PacienteEntity findById(Long pacienteId);
	public PacienteEntity savePaciente(PacienteEntity entity);

}
