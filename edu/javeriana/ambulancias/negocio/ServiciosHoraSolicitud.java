package co.edu.javeriana.ambulancias.negocio;

import java.util.Comparator;

public class ServiciosHoraSolicitud implements Comparator<Servicio> {

	@Override
	public int compare(Servicio o1, Servicio o2) {

		return o1.getHoraSolicitud().compareTo(o2.getHoraSolicitud());
	}

}
