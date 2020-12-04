package pe.gob.minsa.vacuna.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "plan", schema = "dbvacuna", catalog = "")
public class PlanEntity implements Serializable{
    private Long planId;
    private String descVacuna;
    private Integer edad;
    private String descDosis;

    @Id
    @Column(name = "plan_id")
    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    @Basic
    @Column(name = "desc_vacuna")
    public String getDescVacuna() {
        return descVacuna;
    }

    public void setDescVacuna(String descVacuna) {
        this.descVacuna = descVacuna;
    }

    @Basic
    @Column(name = "edad")
    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    @Basic
    @Column(name = "desc_dosis")
    public String getDescDosis() {
        return descDosis;
    }

    public void setDescDosis(String descDosis) {
        this.descDosis = descDosis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlanEntity that = (PlanEntity) o;

        if (planId != that.planId) return false;
        if (descVacuna != null ? !descVacuna.equals(that.descVacuna) : that.descVacuna != null) return false;
        if (edad != null ? !edad.equals(that.edad) : that.edad != null) return false;
        if (descDosis != null ? !descDosis.equals(that.descDosis) : that.descDosis != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        Long result = planId;
        result = 31 * result + (descVacuna != null ? descVacuna.hashCode() : 0);
        result = 31 * result + (edad != null ? edad.hashCode() : 0);
        result = 31 * result + (descDosis != null ? descDosis.hashCode() : 0);
        return result.intValue();
    }
}
