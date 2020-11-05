package pe.gob.minsa.vacuna.entity;

import javax.persistence.*;

@Entity
@Table(name = "paciente", schema = "dbvacuna", catalog = "")
public class PacienteEntity {
    private int pacienteId;
    private Integer personaId;

    @Id
    @Column(name = "paciente_id")
    public int getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(int pacienteId) {
        this.pacienteId = pacienteId;
    }

    @Basic
    @Column(name = "persona_id")
    public Integer getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Integer personaId) {
        this.personaId = personaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PacienteEntity that = (PacienteEntity) o;

        if (pacienteId != that.pacienteId) return false;
        if (personaId != null ? !personaId.equals(that.personaId) : that.personaId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pacienteId;
        result = 31 * result + (personaId != null ? personaId.hashCode() : 0);
        return result;
    }
}
