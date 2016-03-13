package co.edu.javeriana.ambulancias.negocio;

public class Direccion {
	private String tipoDireccion;
	private int calle;
	private int carrera;
	private int numero;
	
	public String getTipoDireccion() {
		return tipoDireccion;
	}
	public void setTipoDireccion(String tipoDireccion) {
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
