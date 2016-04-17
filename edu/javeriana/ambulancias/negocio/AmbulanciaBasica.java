package co.edu.javeriana.ambulancias.negocio;

import co.edu.javeriana.ambulancias.presentacion.Utils;

public class AmbulanciaBasica extends AmbulanciaMedicalizada{

	public AmbulanciaBasica(int codigo, String placa ,String medico) {
		super(codigo, placa,medico);
		// TODO Auto-generated constructor stub
	}

	@Override
	public long calcularTarifa() {
		return (long) (super.TARIFA_BASE+(super.TARIFA_BASE*0.2));
	}

	@Override
	public boolean comprovarTipoServicio(Servicio servicio) {
		if(servicio.getTipoSercivio()==Servicio.TipoServicio.DOMICILIO)
			return true;
		return super.comprovarTipoServicio(servicio);
	}
	public String toString()
	{
		return "BASICA\t"+codigo+"\t"+placa+"\t"+medico+"\t---\t"+Utils.hora(this.horaPosicion)+"\t"+this.posicionCalle+
				"\t"+this.posicionCarrera+"\t"+this.calcularTarifa()+"\n";
	}
	public String toStringPunto5()
	{
		Long hola=getServicioAsignado(); 
		return codigo+"\t"+placa+"\tBASICA\t"+Utils.hora(this.horaPosicion)+"\t"+this.posicionCalle+
				"\t"+this.posicionCarrera+"\t"+((hola==null)?"":hola);
	}


}
