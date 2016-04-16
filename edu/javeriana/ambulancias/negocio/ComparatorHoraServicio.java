package co.edu.javeriana.ambulancias.negocio;

import java.util.Comparator;

public class ComparatorHoraServicio implements Comparator<Servicio> {
	
	public int compare(Servicio servi1,Servicio servi2){
		
		if (servi1.getHoraSolicitud().before(servi2.getHoraSolicitud())==true) {
			return -1;
		}
		else
			return 1;
		

	}

}
