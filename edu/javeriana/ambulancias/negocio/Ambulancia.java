package co.edu.javeriana.ambulancias.negocio;




import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Vector;

import co.edu.javeriana.ambulancias.presentacion.Utils;

public abstract class Ambulancia implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected final long TARIFA_BASE=80000;
	protected int codigo;
	protected String placa;
	//private String tipoDotacion;
	protected GregorianCalendar horaPosicion;
	protected int posicionCalle;
	protected int posicionCarrera;
	protected  List<Servicio> servicios;
	protected boolean asignada;
	protected boolean dirModificada;

	public Ambulancia(int codigo, String placa) {
		this.codigo=codigo;
		this.placa=placa;
		//this.tipoDotacion=tipoDotacion;
		this.servicios=new ArrayList<Servicio>();
		this.horaPosicion=null;
		this.dirModificada=false;
		this.asignada=false;
		this.posicionCalle=-1;
		this.posicionCarrera=-1;
	}
	public boolean isDirModificada() {
		return dirModificada;
	}
	public void setDirModificada(boolean dirModificada) {
		this.dirModificada = dirModificada;
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
			if(servicio.getEstado().equals(Servicio.Estado.ASIGNADO))
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

//	public String toString() {
//		return codigo+"\t"+placa+" "+tipoDotacion+"\t\t"+Utils.hora(horaPosicion)+"\t\t"+posicionCalle+"\t\t"+posicionCarrera;
//	}
//	public String getTipoDotacion() {
//		return tipoDotacion;
//	}
//	public void setTipoDotacion(String tipoDotacion) {
//		this.tipoDotacion = tipoDotacion;
//	}
	
	public void setHoraPosicion(GregorianCalendar horaPosicion) {
		this.horaPosicion = horaPosicion;
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
	public abstract long calcularTarifa();
	public abstract boolean comprovarTipoServicio(Servicio servicio);
	public abstract String toStringPunto5();
	public abstract Vector<Object>  reporteAmbulancia();
	public abstract Vector<Object> reporteAmbulanciaTarifa() ;

}
