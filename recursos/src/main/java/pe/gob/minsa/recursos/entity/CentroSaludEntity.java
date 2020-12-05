package pe.gob.minsa.recursos.entity;

import javax.persistence.*;

@Entity
@Table(name = "centro_salud", schema = "dbminsa", catalog = "")
public class CentroSaludEntity {
    private Integer centroSaludId;
    private String nombreCentroSalud;
    private String ubicacion;

    @Id
    @Column(name = "centro_salud_id")
    public Integer getCentroSaludId() {
        return centroSaludId;
    }

    public void setCentroSaludId(Integer centroSaludId) {
        this.centroSaludId = centroSaludId;
    }

    @Basic
    @Column(name = "nombre_centro_salud")
    public String getNombreCentroSalud() {
        return nombreCentroSalud;
    }

    public void setNombreCentroSalud(String nombreCentroSalud) {
        this.nombreCentroSalud = nombreCentroSalud;
    }

    @Basic
    @Column(name = "ubicacion")
    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CentroSaludEntity that = (CentroSaludEntity) o;

        if (centroSaludId != null ? !centroSaludId.equals(that.centroSaludId) : that.centroSaludId != null)
            return false;
        if (nombreCentroSalud != null ? !nombreCentroSalud.equals(that.nombreCentroSalud) : that.nombreCentroSalud != null)
            return false;
        if (ubicacion != null ? !ubicacion.equals(that.ubicacion) : that.ubicacion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = centroSaludId != null ? centroSaludId.hashCode() : 0;
        result = 31 * result + (nombreCentroSalud != null ? nombreCentroSalud.hashCode() : 0);
        result = 31 * result + (ubicacion != null ? ubicacion.hashCode() : 0);
        return result;
    }
}
