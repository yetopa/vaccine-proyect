package pe.gob.minsa.recursos.entity;

import javax.persistence.*;

@Entity
@Table(name = "personal_medico_centro_salud", schema = "dbminsa", catalog = "")
@IdClass(PersonalMedicoCentroSaludEntityPK.class)
public class PersonalMedicoCentroSaludEntity {
    private Integer personalMedicoId;
    private Integer centroSaludId;
    private String status;
    private PersonalMedicoEntity personalMedicoByPersonalMedicoId;
    private CentroSaludEntity centroSaludByCentroSaludId;

    @Id
    @Column(name = "personal_medico_id")
    public Integer getPersonalMedicoId() {
        return personalMedicoId;
    }

    public void setPersonalMedicoId(Integer personalMedicoId) {
        this.personalMedicoId = personalMedicoId;
    }

    @Id
    @Column(name = "centro_salud_id")
    public Integer getCentroSaludId() {
        return centroSaludId;
    }

    public void setCentroSaludId(Integer centroSaludId) {
        this.centroSaludId = centroSaludId;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonalMedicoCentroSaludEntity that = (PersonalMedicoCentroSaludEntity) o;

        if (personalMedicoId != null ? !personalMedicoId.equals(that.personalMedicoId) : that.personalMedicoId != null)
            return false;
        if (centroSaludId != null ? !centroSaludId.equals(that.centroSaludId) : that.centroSaludId != null)
            return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = personalMedicoId != null ? personalMedicoId.hashCode() : 0;
        result = 31 * result + (centroSaludId != null ? centroSaludId.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @ManyToOne()
    @JoinColumn(name = "personal_medico_id", referencedColumnName = "personal_medico_id", nullable = false , insertable = false, updatable = false)
    public PersonalMedicoEntity getPersonalMedicoByPersonalMedicoId() {
        return personalMedicoByPersonalMedicoId;
    }

    public void setPersonalMedicoByPersonalMedicoId(PersonalMedicoEntity personalMedicoByPersonalMedicoId) {
        this.personalMedicoByPersonalMedicoId = personalMedicoByPersonalMedicoId;
    }

    @ManyToOne
    @JoinColumn(name = "centro_salud_id", referencedColumnName = "centro_salud_id", nullable = false, insertable = false, updatable = false)
    public CentroSaludEntity getCentroSaludByCentroSaludId() {
        return centroSaludByCentroSaludId;
    }

    public void setCentroSaludByCentroSaludId(CentroSaludEntity centroSaludByCentroSaludId) {
        this.centroSaludByCentroSaludId = centroSaludByCentroSaludId;
    }
}
