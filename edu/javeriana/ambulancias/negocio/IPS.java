package co.edu.javeriana.ambulancias.negocio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import co.edu.javeriana.ambulancias.presentacion.Utils;

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
		Collections.sort(servicios, new ComparatorHoraServicio());

		String reporte="\tSERVICIOS:\n\tCodigo\tHoraSolicitud\tPaciente\tTipoServicio\tTelefono\tDireccion\tEstado ambul\n"
						+"\t" +Utils.imprimirLinea(187,95)+"\n";
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
	public Vector<Object> reporteTable() {
		Object[] temp=new Object[3];
		temp[0]=this.getNombre();
		temp[1]=this.getTipoAtencion();
		temp[2]=this.getDireccion();
		return   new Vector<Object> (Arrays.asList(temp));
	}
	

}
