package co.edu.javeriana.ambulancias.negocio;

import co.edu.javeriana.ambulancias.presentacion.Utils;

public class AmbulanciaNoMedicalizada extends Ambulancia{

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


}
