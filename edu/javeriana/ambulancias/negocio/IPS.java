package co.edu.javeriana.ambulancias.negocio;

import java.util.List;

public class IPS {
	private String nombre;
	private String tipoAtencion;
	private Direccion direccion;
	private List<Servicio> servicios;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipoAtencion() {
		return tipoAtencion;
	}
	public void setTipoAtencion(String tipoAtencion) {
		this.tipoAtencion = tipoAtencion;
	}
	
}
