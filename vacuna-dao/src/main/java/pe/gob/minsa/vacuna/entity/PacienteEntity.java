package pe.gob.minsa.vacuna.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "paciente", schema = "dbvacuna", catalog = "")
public class PacienteEntity implements Serializable{
    private Long pacienteId;
    private Integer personaId;
    private String grupoSanguineo;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "paciente_id")
    public Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Long pacienteId) {
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
    

    public String getGrupoSanguineo() {
		return grupoSanguineo;
	}

	public void setGrupoSanguineo(String grupoSanguineo) {
		this.grupoSanguineo = grupoSanguineo;
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
        Long result = pacienteId;
        result = 31 * result + (personaId != null ? personaId.hashCode() : 0);
        return result.intValue();
    }
}
