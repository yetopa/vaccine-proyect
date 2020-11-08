package pe.gob.minsa.recursos.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.gob.minsa.recursos.entity.CentroSaludEntity;
import pe.gob.minsa.recursos.entity.PersonalMedicoEntity;
import pe.gob.minsa.recursos.service.CentroSaludService;

import java.util.List;

@RestController
@RequestMapping("/centroSalud")
public class CentroSaludFacadeImpl implements CentroSaludFacade {

    @Autowired
    private CentroSaludService centroSaludService;

    @Override
    @PostMapping("/medico")
    public PersonalMedicoEntity savePersonalMedico(@RequestBody PersonalMedicoEntity personalMedicoEntity) {
        return centroSaludService.savePersonalMedico(personalMedicoEntity);
    }

    @Override
        @GetMapping("/{personalMedicoId}/byPersonId")
    public List<CentroSaludEntity> findCentroSaludByPersonalMedicoId(@PathVariable(name = "personalMedicoId") Integer personalMedicoId) {
        return centroSaludService.findCentroSaludByPersonalMedico(personalMedicoId);
    }
}
