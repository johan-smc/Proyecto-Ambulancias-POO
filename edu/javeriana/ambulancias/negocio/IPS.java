package co.edu.javeriana.ambulancias.negocio;

import java.util.ArrayList;
import java.util.List;

public class IPS {
	private String nombre;
	private String tipoAtencion;
	private Direccion direccion;
	private List<Servicio> servicios;
	
	
	
	public IPS(String nombre, String tipoAtencion,  String tipoDireccion, int calle, int carrera, int numero) {
		super();
		this.nombre = nombre;
		this.tipoAtencion = tipoAtencion;
		this.direccion = new Direccion(tipoDireccion, calle, carrera, numero) ;
		this.servicios = new ArrayList<Servicio>();
	}
	public String reporteServicios()
	{
		String reporte="\tSERVICIOS:\n\tCodigo\tHoraSolicitud\tPaciente\tTipoServicio\tTelefono\tDireccion\tEstado ambul\n"
						+"\t" +"-------------------------------------------------------------------------------------------------------\n";
		for(Servicio servicio:servicios)
		{
			reporte+="\t"+servicio.toStringEspecialSupremo()+"\n";
		}
		return reporte;
	}
	
	public Direccion getDireccion() {
		return direccion;
	}

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

	public void relacionarServicio(Servicio servicio) {
		if(servicio!=null)
			this.servicios.add(servicio);
		
	}

	@Override
	public String toString() {
		return nombre+"\t"+tipoAtencion+"\t"+direccion.toString();
	}
	
}
