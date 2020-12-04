package pe.gob.minsa.vacuna.vacunacore.dto;

import java.io.Serializable;
import java.util.Date;

public class CitaDTO implements Serializable{

	private Long cita_id;
	private Long persona_id;
	private Date fecha;
	private String estado;
	public Long getCita_id() {
		return cita_id;
	}
	public void setCita_id(Long cita_id) {
		this.cita_id = cita_id;
	}
	public Long getPersona_id() {
		return persona_id;
	}
	public void setPersona_id(Long persona_id) {
		this.persona_id = persona_id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
