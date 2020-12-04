package pe.gob.minsa.vacuna.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "paciente_plan", schema = "dbvacuna", catalog = "")
@IdClass(PacientePlanEntityPK.class)
public class PacientePlanEntity implements Serializable{
    private Long pacientepacienteId;
    private Long planplanId;
    private Integer fechaAplicacion;
    private PacienteEntity pacienteByPacientepacienteId;

    @Id
    @Column(name = "pacientepaciente_id")
    public Long getPacientepacienteId() {
        return pacientepacienteId;
    }

    public void setPacientepacienteId(Long pacientepacienteId) {
        this.pacientepacienteId = pacientepacienteId;
    }

    @Id
    @Column(name = "planplan_id")
    public Long getPlanplanId() {
        return planplanId;
    }

    public void setPlanplanId(Long planplanId) {
        this.planplanId = planplanId;
    }

    @Basic
    @Column(name = "fecha_aplicacion")
    public Integer getFechaAplicacion() {
        return fechaAplicacion;
    }

    public void setFechaAplicacion(Integer fechaAplicacion) {
        this.fechaAplicacion = fechaAplicacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PacientePlanEntity that = (PacientePlanEntity) o;

        if (pacientepacienteId != that.pacientepacienteId) return false;
        if (planplanId != that.planplanId) return false;
        if (fechaAplicacion != null ? !fechaAplicacion.equals(that.fechaAplicacion) : that.fechaAplicacion != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        Long result = pacientepacienteId;
        result = 31 * result + planplanId;
        result = 31 * result + (fechaAplicacion != null ? fechaAplicacion.hashCode() : 0);
        return result.intValue();
    }

    @ManyToOne
    @JoinColumn(name = "pacientepaciente_id", referencedColumnName = "paciente_id", nullable = false, insertable = false, updatable = false)
    public PacienteEntity getPacienteByPacientepacienteId() {
        return pacienteByPacientepacienteId;
    }

    public void setPacienteByPacientepacienteId(PacienteEntity pacienteByPacientepacienteId) {
        this.pacienteByPacientepacienteId = pacienteByPacientepacienteId;
    }
}
