package pe.gob.minsa.vacuna.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cita", schema = "dbvacuna", catalog = "")
public class CitaEntity {
	
	private Long cita_id;
	private Long persona_id;
	private Date fecha;
	private String estado;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cita_id")
	public Long getCita_id() {
		return cita_id;
	}
	public void setCita_id(Long cita_id) {
		this.cita_id = cita_id;
	}
	
	@Column(name = "persona_id")
	public Long getPersona_id() {
		return persona_id;
	}
	public void setPersona_id(Long persona_id) {
		this.persona_id = persona_id;
	}
	
	@Column(name = "fecha")
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	@Column(name = "estado")
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	

}
