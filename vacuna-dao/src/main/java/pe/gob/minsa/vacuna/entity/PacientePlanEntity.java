package pe.gob.minsa.vacuna.entity;

import javax.persistence.*;

@Entity
@Table(name = "paciente_plan", schema = "dbvacuna", catalog = "")
@IdClass(PacientePlanEntityPK.class)
public class PacientePlanEntity {
    private int pacientepacienteId;
    private int planplanId;
    private Integer fechaAplicacion;
    private PacienteEntity pacienteByPacientepacienteId;

    @Id
    @Column(name = "pacientepaciente_id")
    public int getPacientepacienteId() {
        return pacientepacienteId;
    }

    public void setPacientepacienteId(int pacientepacienteId) {
        this.pacientepacienteId = pacientepacienteId;
    }

    @Id
    @Column(name = "planplan_id")
    public int getPlanplanId() {
        return planplanId;
    }

    public void setPlanplanId(int planplanId) {
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
        int result = pacientepacienteId;
        result = 31 * result + planplanId;
        result = 31 * result + (fechaAplicacion != null ? fechaAplicacion.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "pacientepaciente_id", referencedColumnName = "paciente_id", nullable = false)
    public PacienteEntity getPacienteByPacientepacienteId() {
        return pacienteByPacientepacienteId;
    }

    public void setPacienteByPacientepacienteId(PacienteEntity pacienteByPacientepacienteId) {
        this.pacienteByPacientepacienteId = pacienteByPacientepacienteId;
    }
}
