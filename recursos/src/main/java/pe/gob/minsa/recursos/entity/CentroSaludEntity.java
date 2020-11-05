package pe.gob.minsa.recursos.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "centro_salud", schema = "dbminsa", catalog = "")
public class CentroSaludEntity {
    private int centroSaludId;
    private String nombreCentroSalud;
    private String ubicacion;
    private Collection<PersonalMedicoEntity> personalMedicosByCentroSaludId;

    @Id
    @Column(name = "centro_salud_id")
    public int getCentroSaludId() {
        return centroSaludId;
    }

    public void setCentroSaludId(int centroSaludId) {
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

        if (centroSaludId != that.centroSaludId) return false;
        if (nombreCentroSalud != null ? !nombreCentroSalud.equals(that.nombreCentroSalud) : that.nombreCentroSalud != null)
            return false;
        if (ubicacion != null ? !ubicacion.equals(that.ubicacion) : that.ubicacion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = centroSaludId;
        result = 31 * result + (nombreCentroSalud != null ? nombreCentroSalud.hashCode() : 0);
        result = 31 * result + (ubicacion != null ? ubicacion.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "centroSaludByCentroSaludId")
    public Collection<PersonalMedicoEntity> getPersonalMedicosByCentroSaludId() {
        return personalMedicosByCentroSaludId;
    }

    public void setPersonalMedicosByCentroSaludId(Collection<PersonalMedicoEntity> personalMedicosByCentroSaludId) {
        this.personalMedicosByCentroSaludId = personalMedicosByCentroSaludId;
    }
}
