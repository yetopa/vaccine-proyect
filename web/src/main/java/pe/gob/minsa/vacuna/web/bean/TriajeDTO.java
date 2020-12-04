package pe.gob.minsa.vacuna.web.bean;

import java.util.Date;

public class TriajeDTO {

	private Long triajeId;
	private Date fechaTriaje;
	private Long pacienteId;
	private Double peso;
	private Double talla;
	private Double pc;
	private Long personaId;
	
	public Long getPersonaId() {
		return personaId;
	}
	public void setPersonaId(Long personaId) {
		this.personaId = personaId;
	}
	public Long getTriajeId() {
		return triajeId;
	}
	public void setTriajeId(Long triajeId) {
		this.triajeId = triajeId;
	}
	public Date getFechaTriaje() {
		return fechaTriaje;
	}
	public void setFechaTriaje(Date fechaTriaje) {
		this.fechaTriaje = fechaTriaje;
	}
	public Long getPacienteId() {
		return pacienteId;
	}
	public void setPacienteId(Long pacienteId) {
		this.pacienteId = pacienteId;
	}
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public Double getTalla() {
		return talla;
	}
	public void setTalla(Double talla) {
		this.talla = talla;
	}
	public Double getPc() {
		return pc;
	}
	public void setPc(Double pc) {
		this.pc = pc;
	}
	
	
}
