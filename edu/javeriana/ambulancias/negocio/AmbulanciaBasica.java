package co.edu.javeriana.ambulancias.negocio;



import java.util.Arrays;
import java.util.Vector;

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
		return codigo+"\t"+placa+"\tBASICA\t\t"+Utils.hora(this.horaPosicion)+"\t\t"+this.posicionCalle+
				"\t\t"+this.posicionCarrera+"\t\t"+((hola==null)?"":hola);
	}

	public Vector<Object> reporteAmbulancia() {
		Object[] temp=new Object[8];
		temp[0]=(String.valueOf(this.codigo));
		temp[1]=("BASICA");
		temp[2]=(this.placa);
		temp[3]=(this.medico);
		temp[4]=("");
		temp[5]=(String.valueOf(Utils.fechaSolicitud(this.horaPosicion)));
		temp[6]=(String.valueOf(this.posicionCalle));
		temp[7]=(String.valueOf(this.posicionCarrera));
		return   new Vector<Object> (Arrays.asList(temp));
	}


}
