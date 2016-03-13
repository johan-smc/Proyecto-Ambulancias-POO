package co.edu.javeriana.ambulancias.presentacion;

import java.util.Calendar;
import java.util.GregorianCalendar;

import co.edu.javeriana.ambulancias.negocio.Direccion;

public class Utils {

	public static GregorianCalendar horaSistema() {
		GregorianCalendar fecha = new GregorianCalendar();
		GregorianCalendar horaPosicion=new GregorianCalendar(); 
		horaPosicion.set(Calendar.HOUR_OF_DAY, fecha.get(Calendar.HOUR_OF_DAY));
		horaPosicion.set(Calendar.MINUTE, fecha.get(Calendar.MINUTE));
		horaPosicion.set(Calendar.SECOND, fecha.get(Calendar.SECOND));
		return horaPosicion;
	}

	public static String fechaSolicitud(GregorianCalendar hora) {
		String fecha="";
		fecha+=hora.get(Calendar.MONTH)+" ";
		fecha+=hora.get(Calendar.DAY_OF_MONTH)+" ";
		fecha+=hora.get(Calendar.HOUR)+":"+hora.get(Calendar.MINUTE);
		
		return fecha;
	}
	public static int calcularDistancia(Direccion x ,Direccion y) {
		int a=Math.abs(y.getCalle()-x.getCalle());
		int b=Math.abs(y.getCarrera()-x.getCarrera());
		return a+b;
	}

}
