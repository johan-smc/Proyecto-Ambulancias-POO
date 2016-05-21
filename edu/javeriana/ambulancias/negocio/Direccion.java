package co.edu.javeriana.ambulancias.negocio;

import java.io.Serializable;

public class Direccion implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TipoDireccion tipoDireccion;
	private int calle;
	private int carrera;
	private int numero;
	
	public static enum TipoDireccion
	{
		CALLE,CARRERA;
	}
	public String toString() {
		String direccion=tipoDireccion.toString();
		if(tipoDireccion.equals("CARRERA"))
			direccion+=" "+carrera+" # "+calle;
		else if(tipoDireccion.equals("CALLE"))
			direccion+=" "+calle+" #"+carrera;
		return direccion+ "-"+numero;
	}
	
	public Direccion(int calle,int carrera)
	{
		this.calle=calle;
		this.carrera=carrera;
	}
	public Direccion(String tipoDireccion, int calle, int carrera, int numero) {
		super();
		
		this.tipoDireccion = tipoDireccion.equals("CALLE")?TipoDireccion.CALLE:TipoDireccion.CARRERA;
		this.calle = calle;
		this.carrera = carrera;
		this.numero = numero;
	}
	
	public TipoDireccion getTipoDireccion() {
		return tipoDireccion;
	}
	public void setTipoDireccion(TipoDireccion tipoDireccion) {
		this.tipoDireccion = tipoDireccion;
	}
	public int getCalle() {
		return calle;
	}
	public void setCalle(int calle) {
		this.calle = calle;
	}
	public int getCarrera() {
		return carrera;
	}
	public void setCarrera(int carrera) {
		this.carrera = carrera;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
}
