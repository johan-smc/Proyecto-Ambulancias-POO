package co.edu.javeriana.ambulancias.negocio;

import java.util.Comparator;

public class OrdenadoSustentacion implements  Comparator<Servicio> {

	@Override
	public int compare(Servicio o1, Servicio o2) {
		if(o1.getEstado().equals(o2.getEstado()))
			return o1.getPaciente().compareTo(o2.getPaciente());
		return o1.getEstado().compareTo(o2.getEstado());
	}

}
