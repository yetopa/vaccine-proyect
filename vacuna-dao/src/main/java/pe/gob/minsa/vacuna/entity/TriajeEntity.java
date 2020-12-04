package pe.gob.minsa.vacuna.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "triaje", schema = "dbvacuna", catalog = "")
public class TriajeEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long triajeId;
	private Date fechaTriaje;
	private Long pacienteId;
	private Double peso;
	private Double talla;
	private Double pc;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "triaje_id")
	public Long getTriajeId() {
		return triajeId;
	}
	public void setTriajeId(Long triajeId) {
		this.triajeId = triajeId;
	}
	
	@Column(name = "fecha_triaje")
	public Date getFechaTriaje() {
		return fechaTriaje;
	}
	public void setFechaTriaje(Date fechaTriaje) {
		this.fechaTriaje = fechaTriaje;
	}
	
	@Column(name = "paciente_id")
	public Long getPacienteId() {
		return pacienteId;
	}
	public void setPacienteId(Long pacienteId) {
		this.pacienteId = pacienteId;
	}
	
	@Column(name = "peso")
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	
	@Column(name = "talla")
	public Double getTalla() {
		return talla;
	}
	public void setTalla(Double talla) {
		this.talla = talla;
	}
	
	@Column(name = "pc")
	public Double getPc() {
		return pc;
	}
	public void setPc(Double pc) {
		this.pc = pc;
	}
	
	
	
}
