package co.edu.javeriana.ambulancias.negocio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
		
		public boolean registrarPosAmbulancia(int codigo,int calle, int carrera)
		{
			boolean esta=false;
			for(Ambulancia ambulancia: ambulancias){
				
				if(ambulancia.getCodigo()==codigo)
				{
					ambulancia.setPosicionCalle(calle);
					ambulancia.setPosicionCarrera(carrera);
					ambulancia.sethora();
					esta=true;
				}
				
			}
			return esta;
			
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
		public long agregarServicio(String nombre2, String tipoServicio, String telefono, String tipoDireccion, int n1,
				int n2, int n3) {
			Servicio temp=new Servicio(nombre,tipoServicio,telefono,tipoDireccion,n1,n2,n3);
			
			this.servicios.add(temp);
			return temp.getCodigo();
			
		}
		
}
