package co.edu.javeriana.ambulancias.negocio;

import java.util.List;

public class EmpresaAmbulancias {
		private String nombre;
		private List<IPS> losIPS;
		private List<Servicio> servicios;
		private List<Ambulancia> ambulacias;
		public EmpresaAmbulancias(String nombre) {
			this.nombre=nombre;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		
}
