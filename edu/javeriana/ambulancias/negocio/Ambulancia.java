package co.edu.javeriana.ambulancias.negocio;




import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import co.edu.javeriana.ambulancias.presentacion.Utils;

public class Ambulancia {
	private int codigo;
	private String placa;
	private String tipoDotacion;
	private GregorianCalendar horaPosicion;
	private int posicionCalle;
	private int posicionCarrera;
	private List<Servicio> servicios;
	private boolean asignada;
	
	public Ambulancia(int codigo, String placa, String tipoDotacion) {
		this.codigo=codigo;
		this.placa=placa;
		this.tipoDotacion=tipoDotacion;
		this.servicios=new ArrayList<Servicio>();
		this.horaPosicion=new GregorianCalendar();
		this.asignada=false;
	}
	public boolean isAsignada() {
		return asignada;
	}
	public void setAsignada(boolean asignada) {
		this.asignada = asignada;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public void sethora() {
		 horaPosicion=Utils.horaSistema();
		
		
	}
	public Long getServicioAsignado()
	{
		for(Servicio servicio : servicios)
		{
			if(servicio.getEstado().equals("ASIGNADO"))
			{
				return servicio.getCodigo();
			}
			
		}
		
		return null;
	}
	public GregorianCalendar getHoraPosicion() {
		
	 
		return horaPosicion;
		
	}
	
	public void retirarServicio()
	{
		this.asignada=false;
		
	}
	@Override
	public String toString() {
		return codigo+"\t"+placa+" "+tipoDotacion+"\t\t"+Utils.hora(horaPosicion)+"\t\t"+posicionCalle+"\t\t"+posicionCarrera;
	}
	public void setHoraPosicion(GregorianCalendar horaPosicion) {
		this.horaPosicion = horaPosicion;
	}
	public String getTipoDotacion() {
		return tipoDotacion;
	}
	public void setTipoDotacion(String tipoDotacion) {
		this.tipoDotacion = tipoDotacion;
	}
	public int getPosicionCalle() {
		return posicionCalle;
	}
	public void setPosicionCalle(int posicionCalle) {
		this.posicionCalle = posicionCalle;
	}
	public int getPosicionCarrera() {
		return posicionCarrera;
	}
	public void setPosicionCarrera(int posicionCarrera) {
		this.posicionCarrera = posicionCarrera;
	}
	public void relacionarServicio(Servicio servicio) {
		this.asignada=true;
		this.servicios.add(servicio);
		
	}
	
}
