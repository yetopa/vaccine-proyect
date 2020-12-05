package pe.gob.minsa.vacuna.repository;

import org.springframework.data.repository.CrudRepository;

import pe.gob.minsa.vacuna.entity.PacienteEntity;

public interface PacienteRespository extends CrudRepository<PacienteEntity, Long>{

	public PacienteEntity findByPacienteId(Long pacienteId);
	public PacienteEntity findByPersonaId(Integer personaId);
	
	
	
	
}
