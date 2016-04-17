package co.edu.javeriana.ambulancias.negocio;

import co.edu.javeriana.ambulancias.presentacion.Utils;

public class AmbulanciaUCI extends AmbulanciaMedicalizada{

	private String tipoUCI;
	public AmbulanciaUCI(int codigo, String placa, String medico,String tipoUCI) {
		super(codigo, placa, medico);
		this.tipoUCI=tipoUCI;
	}


	public long calcularTarifa() {
		long total=super.TARIFA_BASE;
		if(this.tipoUCI.equals("CARDIOVASCULAR"))
			total+=(super.TARIFA_BASE*0.5);
		else if(this.tipoUCI.equals("PEDIATRICA"))
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
		return codigo+"\t"+placa+"\tUCI\t"+Utils.hora(this.horaPosicion)+"\t"+this.posicionCalle+
				"\t"+this.posicionCarrera+"\t"+((hola==null)?"":hola);
	}




}
