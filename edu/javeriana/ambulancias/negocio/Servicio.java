package co.edu.javeriana.ambulancias.negocio;

import java.util.GregorianCalendar;

public class Servicio {
	private static long CONSECUTIVO;
	private long codigo;
	private GregorianCalendar horaSolicitud;
	private String paciente;
	private String tipoSercivio;
	private String telefono;
	private String estado;
	private Direccion direccion;
	private IPS ips;
	private Ambulancia ambulancia;
	
	public String getPaciente() {
		return paciente;
	}
	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}
	public String getTipoSercivio() {
		return tipoSercivio;
	}
	public void setTipoSercivio(String tipoSercivio) {
		this.tipoSercivio = tipoSercivio;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public static long getCONSECUTIVO() {
		return CONSECUTIVO;
	}
	public long getCodigo() {
		return codigo;
	}
	
}
