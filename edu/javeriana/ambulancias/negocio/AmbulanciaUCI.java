package co.edu.javeriana.ambulancias.negocio;

import java.util.List;
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
	
	public List<Object> reporteAmbulancia() {
		List<Object> temp=new Vector<Object>();
		temp.add(String.valueOf(this.codigo));
		temp.add("Medicalizada");
		temp.add(this.placa);
		temp.add(this.medico);
		temp.add(String.valueOf(this.tipoUCI));
		temp.add(String.valueOf(this.horaPosicion));
		temp.add(String.valueOf(this.posicionCalle));
		temp.add(String.valueOf(this.posicionCarrera));
		return temp;
	}



}
