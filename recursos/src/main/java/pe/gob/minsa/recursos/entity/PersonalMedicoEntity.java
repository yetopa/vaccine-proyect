package pe.gob.minsa.recursos.entity;

import javax.persistence.*;

@Entity
@Table(name = "personal_medico", schema = "dbminsa", catalog = "")
public class PersonalMedicoEntity {
    private int personalMedicoId;
    private Integer personaId;
    private String estado;
    private int centroSaludId;
    private CentroSaludEntity centroSaludByCentroSaludId;

    @Id
    @Column(name = "personal_medico_id")
    public int getPersonalMedicoId() {
        return personalMedicoId;
    }

    public void setPersonalMedicoId(int personalMedicoId) {
        this.personalMedicoId = personalMedicoId;
    }

    @Basic
    @Column(name = "persona_id")
    public Integer getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Integer personaId) {
        this.personaId = personaId;
    }

    @Basic
    @Column(name = "estado")
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Basic
    @Column(name = "centro_salud_id")
    public int getCentroSaludId() {
        return centroSaludId;
    }

    public void setCentroSaludId(int centroSaludId) {
        this.centroSaludId = centroSaludId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonalMedicoEntity that = (PersonalMedicoEntity) o;

        if (personalMedicoId != that.personalMedicoId) return false;
        if (centroSaludId != that.centroSaludId) return false;
        if (personaId != null ? !personaId.equals(that.personaId) : that.personaId != null) return false;
        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = personalMedicoId;
        result = 31 * result + (personaId != null ? personaId.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        result = 31 * result + centroSaludId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "centro_salud_id", referencedColumnName = "centro_salud_id", nullable = false)
    public CentroSaludEntity getCentroSaludByCentroSaludId() {
        return centroSaludByCentroSaludId;
    }

    public void setCentroSaludByCentroSaludId(CentroSaludEntity centroSaludByCentroSaludId) {
        this.centroSaludByCentroSaludId = centroSaludByCentroSaludId;
    }
}
