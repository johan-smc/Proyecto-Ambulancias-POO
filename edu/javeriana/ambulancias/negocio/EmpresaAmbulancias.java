package co.edu.javeriana.ambulancias.negocio;

import java.util.ArrayList;
import java.util.List;

public class EmpresaAmbulancias {
		private String nombre;
		private List<IPS> losIPS;
		private List<Servicio> servicios;
		private List<Ambulancia> ambulancias;
		
		
			public void agregarIPS(String nombre, String tipoAtencion,  String tipoDireccion, int calle, int carrera, int numero){
				
				losIPS.add(new IPS(nombre, tipoAtencion, tipoDireccion, calle, carrera, numero));
			}
		public void agregarAmbulancia(int codigo,String placa, String tipoDotacion)
		{
			ambulancias.add(new Ambulancia(codigo,placa,tipoDotacion));
		}
		
		public EmpresaAmbulancias(String nombre) {
			this.nombre=nombre;
			this.losIPS=new ArrayList<IPS>();
			this.servicios=new ArrayList<Servicio>();
			this.ambulancias=new ArrayList<Ambulancia>();
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		
}
