package pe.gob.minsa.recursos.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class PersonalMedicoCentroSaludEntityPK implements Serializable {
    private Integer personalMedicoId;
    private Integer centroSaludId;

    @Column(name = "personal_medico_id")
    @Id
    public Integer getPersonalMedicoId() {
        return personalMedicoId;
    }

    public void setPersonalMedicoId(Integer personalMedicoId) {
        this.personalMedicoId = personalMedicoId;
    }

    @Column(name = "centro_salud_id")
    @Id
    public Integer getCentroSaludId() {
        return centroSaludId;
    }

    public void setCentroSaludId(Integer centroSaludId) {
        this.centroSaludId = centroSaludId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonalMedicoCentroSaludEntityPK that = (PersonalMedicoCentroSaludEntityPK) o;

        if (personalMedicoId != null ? !personalMedicoId.equals(that.personalMedicoId) : that.personalMedicoId != null)
            return false;
        if (centroSaludId != null ? !centroSaludId.equals(that.centroSaludId) : that.centroSaludId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = personalMedicoId != null ? personalMedicoId.hashCode() : 0;
        result = 31 * result + (centroSaludId != null ? centroSaludId.hashCode() : 0);
        return result;
    }
}
