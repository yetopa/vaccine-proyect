package pe.gob.reniec.identidad.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.gob.reniec.identidad.entity.PersonaEntity;
import pe.gob.reniec.identidad.service.PersonaService;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaFacadeImpl implements PersonaFacade{

    @Autowired
    private PersonaService personaService;

    @Override
    @GetMapping("/{dni}/dni")
    public List<PersonaEntity> findPersonaByDni(@PathVariable(name = "dni") String dni) {
        return personaService.findPersonaByDni(dni);
    }

    @Override
    @GetMapping("")
    public List<PersonaEntity> findAllPersona() {
        return personaService.findAllPersona();
    }

    @Override
    @GetMapping("/{nombre}/nombre")
    public List<PersonaEntity> findByName(@PathVariable(name = "nombre") String nombre) {
        return personaService.findByNombreOrApellido(nombre);
    }


}
