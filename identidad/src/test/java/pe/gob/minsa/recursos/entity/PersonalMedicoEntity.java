package pe.gob.minsa.recursos.entity;

import javax.persistence.*;

@Entity
@Table(name = "personal_medico", schema = "dbminsa", catalog = "")
public class PersonalMedicoEntity {
    private int personalMedicoId;
    private Integer personaId;
    private String estado;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonalMedicoEntity that = (PersonalMedicoEntity) o;

        if (personalMedicoId != that.personalMedicoId) return false;
        if (personaId != null ? !personaId.equals(that.personaId) : that.personaId != null) return false;
        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = personalMedicoId;
        result = 31 * result + (personaId != null ? personaId.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        return result;
    }
}
