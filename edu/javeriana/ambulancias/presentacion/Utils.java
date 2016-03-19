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
			return "Ene";
		else if(i==1)
			return "Feb";
		else if(i==2)
			return "Mar";
		else if(i==3)
			return "Abr";
		else if(i==4)
			return "May";
		else if(i==5)
			return "Jun";
		else if(i==6)
			return "Jul";
		else if(i==7)
			return "Ago";
		else if(i==8)
			return "Sep";
		else if(i==9)
			return "Oct";
		else if(i==10)
			return "Nov";
		else if(i==11)
			return "Dic";
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
	
	
	/*recoletado de:
	 * http://lineadecodigo.com/java/validar-si-un-dato-es-numerico-en-java/
	 */

	public static boolean isNumeric(String cadena){
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}
}
