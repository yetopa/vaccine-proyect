package pe.gob.minsa.vacuna.vacunacore.dto;

import java.io.Serializable;
import java.util.Date;

public class CitaPersonaDTO implements Serializable{

	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
    private String dni;
	private Date fechaNacimiento;
    private int edadMeses;
	private String sexo;
    private Date fecha;
    private Long citaId;
    
    
    
	public Long getCitaId() {
		return citaId;
	}
	public void setCitaId(Long citaId) {
		this.citaId = citaId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public int getEdadMeses() {
		return edadMeses;
	}
	public void setEdadMeses(int edadMeses) {
		this.edadMeses = edadMeses;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
    
    
}
