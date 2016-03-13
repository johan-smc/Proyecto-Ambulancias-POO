package co.edu.javeriana.ambulancias.negocio;

import java.util.GregorianCalendar;

import co.edu.javeriana.ambulancias.presentacion.Utils;

public class Servicio {
	private static long CONSECUTIVO;
	private long codigo;
	private GregorianCalendar horaSolicitud;
	private String paciente;
	private String tipoServicio;
	private String telefono;
	private String estado;
	private Direccion direccion;
	private IPS ips;
	private Ambulancia ambulancia;
	
	public Servicio(String nombre, String tipoServicio, String telefono, String tipoDireccion, int n1, int n2,
			int n3) {
		this.codigo=Servicio.getCONSECUTIVO();
		this.paciente=nombre;
		this.tipoServicio=tipoServicio;
		this.telefono=telefono;
		this.direccion=new Direccion(tipoDireccion,n1,n2,n3);
		this.estado="NO_ASIGNADO";
		this.horaSolicitud=Utils.horaSistema();
		
	}
	@Override
	public String toString() {
		return codigo+"\t"+Utils.fechaSolicitud(horaSolicitud)+" "+paciente+" "+
				tipoServicio+" "+telefono+" "+direccion.toString();
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public String getPaciente() {
		return paciente;
	}
	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}
	public String getTipoSercivio() {
		return tipoServicio;
	}
	public void setTipoSercivio(String tipoSercivio) {
		this.tipoServicio = tipoSercivio;
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
	private static long getCONSECUTIVO() {
		return CONSECUTIVO++;
	}
	public long getCodigo() {
		return codigo;
	}
	public void relacionar(Ambulancia ambulancia, IPS ips) {
		this.ips=ips;
		this.ambulancia=ambulancia;
		ips.relacionarServicio(this);
		ambulancia.relacionarServicio(this);
		
	}
	
}
