package co.edu.javeriana.ambulancias.negocio;

import java.util.Comparator;

public class comparatorCodigoServicio implements Comparator<Servicio> {
	
	public int compare(Servicio servi1,Servicio servi2){
		return (int) (servi1.getCodigo()-servi2.getCodigo());
	}

}
