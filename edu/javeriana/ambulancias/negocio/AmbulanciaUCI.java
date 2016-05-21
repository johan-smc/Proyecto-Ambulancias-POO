package co.edu.javeriana.ambulancias.negocio;


import java.util.Arrays;
import java.util.Vector;

import co.edu.javeriana.ambulancias.presentacion.Utils;

public class AmbulanciaUCI extends AmbulanciaMedicalizada{

	private TipoUCI tipoUCI;
	public AmbulanciaUCI(int codigo, String placa, String medico,String tipoUCI) {
		super(codigo, placa, medico);
		this.tipoUCI=tipoUCI.equals("CARDIOVASCULAR")?TipoUCI.CARDIOVASCULAR:TipoUCI.PEDIATRICA;
	}

	public static enum TipoUCI{
		CARDIOVASCULAR,PEDIATRICA;
	}
	public long calcularTarifa() {
		long total=super.TARIFA_BASE;
		if(this.tipoUCI==TipoUCI.CARDIOVASCULAR)
			total+=(super.TARIFA_BASE*0.5);
		else if(this.tipoUCI==TipoUCI.PEDIATRICA)
			total+=(super.TARIFA_BASE*0.6);
		return total;
	}
	public boolean comprovarTipoServicio(Servicio servicio) {
		if(servicio.getTipoSercivio()==Servicio.TipoServicio.EMERGENCIA)
			return true;
		return super.comprovarTipoServicio(servicio);
	}
	public String toString()
	{
		return "UCI\t"+codigo+"\t"+placa+"\t"+medico+"\t"+this.tipoUCI+"\t"+Utils.hora(this.horaPosicion)+"\t"+this.posicionCalle+
				"\t"+this.posicionCarrera+"\t"+this.calcularTarifa()+"\n";
	}
	public String toStringPunto5()
	{
		Long hola=getServicioAsignado();
		return codigo+"\t"+placa+"\tUCI\t\t"+Utils.hora(this.horaPosicion)+"\t\t"+this.posicionCalle+
				"\t\t"+this.posicionCarrera+"\t\t"+((hola==null)?"":hola);
	}
	
	public Vector<Object> reporteAmbulancia() {
		Object[] temp=new Object[8];
		temp[0]=(String.valueOf(this.codigo));
		temp[1]=("UCI");
		temp[2]=(this.placa);
		temp[3]=(this.medico);
		temp[4]=(String.valueOf(this.tipoUCI));
		temp[5]=(String.valueOf(Utils.fechaSolicitud(this.horaPosicion)));
		temp[6]=(String.valueOf(this.posicionCalle));
		temp[7]=(String.valueOf(this.posicionCarrera));
		return   new Vector<Object> (Arrays.asList(temp));

	}



}
