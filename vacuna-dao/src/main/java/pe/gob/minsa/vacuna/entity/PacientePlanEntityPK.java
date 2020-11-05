package pe.gob.minsa.vacuna.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class PacientePlanEntityPK implements Serializable {
    private int pacientepacienteId;
    private int planplanId;

    @Column(name = "pacientepaciente_id")
    @Id
    public int getPacientepacienteId() {
        return pacientepacienteId;
    }

    public void setPacientepacienteId(int pacientepacienteId) {
        this.pacientepacienteId = pacientepacienteId;
    }

    @Column(name = "planplan_id")
    @Id
    public int getPlanplanId() {
        return planplanId;
    }

    public void setPlanplanId(int planplanId) {
        this.planplanId = planplanId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PacientePlanEntityPK that = (PacientePlanEntityPK) o;

        if (pacientepacienteId != that.pacientepacienteId) return false;
        if (planplanId != that.planplanId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pacientepacienteId;
        result = 31 * result + planplanId;
        return result;
    }
}
