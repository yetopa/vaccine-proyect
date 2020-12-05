package pe.gob.minsa.recursos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.gob.minsa.recursos.entity.CentroSaludEntity;
import pe.gob.minsa.recursos.entity.PersonalMedicoEntity;

public interface PersonallMedicoRepository extends JpaRepository<PersonalMedicoEntity, Integer> {

    @Query("select pms from PersonalMedicoCentroSaludEntity pms inner  join " +
            " PersonalMedicoEntity  p where pms.centroSaludByCentroSaludId = :centrosSalud")
    public List<PersonalMedicoEntity> findByCentroSaludByCentroSaludId(CentroSaludEntity centrosSalud);
    @Query("select pme.centroSaludByCentroSaludId from PersonalMedicoCentroSaludEntity  pme inner join  PersonalMedicoEntity  p  " +
            " on pme.personalMedicoId = p.personalMedicoId where p.personaId =:personaId")
    public List<CentroSaludEntity> findCentroSaludByPersonaId(int personaId);

}
