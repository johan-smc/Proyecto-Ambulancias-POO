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
		fecha+=mes(hora.get(Calendar.MONTH))+" ";
		fecha+=hora.get(Calendar.DAY_OF_MONTH)+" ";
		fecha+=hora.get(Calendar.HOUR)+":"+hora.get(Calendar.MINUTE);
		
		return fecha;
	}
	public static String mes(int i) {
		if(i==0)
			return "ENE";
		else if(i==1)
			return "FEB";
		else if(i==2)
			return "MAR";
		else if(i==3)
			return "ABR";
		else if(i==4)
			return "MAY";
		else if(i==5)
			return "JUN";
		else if(i==6)
			return "JUL";
		else if(i==7)
			return "AGO";
		else if(i==8)
			return "SEP";
		else if(i==9)
			return "OCT";
		else if(i==10)
			return "NOV";
		else if(i==11)
			return "DIC";
		return "";
	}

	public static int calcularDistancia(Direccion x ,Direccion y) {
		int a=Math.abs(y.getCalle()-x.getCalle());
		int b=Math.abs(y.getCarrera()-x.getCarrera());
		return a+b;
	}

	public static String hora(GregorianCalendar hora) {
		if(hora==null)
			return "";
		return hora.get(Calendar.HOUR)+":"+hora.get(Calendar.MINUTE);
	}

}
