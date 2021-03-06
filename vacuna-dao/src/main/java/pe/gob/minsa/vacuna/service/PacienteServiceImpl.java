package pe.gob.minsa.vacuna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.minsa.vacuna.entity.PacienteEntity;
import pe.gob.minsa.vacuna.repository.PacienteRespository;

@Service
public class PacienteServiceImpl implements PacienteService{

	@Autowired
	private PacienteRespository pacienteRepository;
	
	@Override
	public PacienteEntity savePacienteEntity(PacienteEntity entity) {
		return pacienteRepository.save(entity);
	}

	@Override
	public PacienteEntity findPacienteById(Long pacienteId) {
		return pacienteRepository.findByPacienteId(pacienteId);
	}

	@Override
	public PacienteEntity findByPersonaId(Integer personaId) {
		return pacienteRepository.findByPersonaId(personaId);
	}

	@Override
	public List<PacienteEntity> findAllPacientes() {
		return (List<PacienteEntity>) pacienteRepository.findAll();
	}

}
