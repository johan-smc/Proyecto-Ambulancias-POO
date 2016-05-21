package co.edu.javeriana.ambulancias.negocio;



import java.util.Arrays;
import java.util.Vector;

import co.edu.javeriana.ambulancias.presentacion.Utils;

public class AmbulanciaNoMedicalizada extends Ambulancia{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AmbulanciaNoMedicalizada(int codigo, String placa,String enfermero) {
		super(codigo, placa);
		this.enfermero=enfermero;
	}

	public String getEnfermero() {
		return enfermero;
	}

	private String enfermero;

	@Override
	public long calcularTarifa() {
		return super.TARIFA_BASE;
	}

	@Override
	public boolean comprovarTipoServicio(Servicio servicio) {
		// TODO Auto-generated method stub
		return false;
	}
	public String toString()
	{
		return "NoEspe\t"+codigo+"\t"+placa+"\t"+enfermero+"\t---\t"+Utils.hora(this.horaPosicion)+"\t"+this.posicionCalle+
				"\t"+this.posicionCarrera+"\t"+this.calcularTarifa()+"\n";
	}
	public String toStringPunto5()
	{
		Long hola=getServicioAsignado();
		return codigo+"\t"+placa+"\tNOMEDICALIZADA\t"+Utils.hora(this.horaPosicion)+"\t\t"+this.posicionCalle+
				"\t\t"+this.posicionCarrera+"\t\t"+((hola==null)?"":hola);
	}

	public Vector<Object> reporteAmbulancia() {
		Object[] temp=new Object[8];
		temp[0]=(String.valueOf(this.codigo));
		temp[1]=("NO MEDICALIZADA");
		temp[2]=(this.placa);
		temp[3]=(this.enfermero);
		temp[4]=("");
		temp[5]=(String.valueOf(Utils.fechaSolicitud(this.horaPosicion)));
		temp[6]=(String.valueOf(this.posicionCalle));
		temp[7]=(String.valueOf(this.posicionCarrera));
		return   new Vector<Object> (Arrays.asList(temp));

	}
	public Vector<Object> reporteAmbulanciaTarifa() {
		Object[] temp=new Object[9];
		temp[0]=(String.valueOf(this.codigo));
		temp[1]=("NO MEDICALIZADA");
		temp[2]=(this.placa);
		temp[3]=(this.enfermero);
		temp[4]=("");
		temp[5]=(String.valueOf(Utils.fechaSolicitud(this.horaPosicion)));
		temp[6]=(String.valueOf(this.posicionCalle));
		temp[7]=(String.valueOf(this.posicionCarrera));
		temp[8]=this.calcularTarifa();
		return   new Vector<Object> (Arrays.asList(temp));
		
	}

}
