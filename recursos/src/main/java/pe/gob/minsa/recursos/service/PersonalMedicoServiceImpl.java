package pe.gob.minsa.recursos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.minsa.recursos.entity.PersonalMedicoEntity;
import pe.gob.minsa.recursos.repository.PersonallMedicoRepository;

@Service
public class PersonalMedicoServiceImpl implements PersonalMedicoService {

	@Autowired
	private PersonallMedicoRepository personalMedicoRepository;
	
	@Override
	public List<PersonalMedicoEntity> listaPersonalMedico() throws Exception {
		return personalMedicoRepository.findAll();
	}

}
