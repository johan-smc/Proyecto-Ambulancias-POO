package co.edu.javeriana.ambulancias.negocio;

import java.util.Vector;

public abstract class AmbulanciaMedicalizada extends Ambulancia {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public AmbulanciaMedicalizada(int codigo, String placa, String medico) {
		super(codigo, placa);
		this.medico=medico;
	}

	protected String medico;
	public boolean comprovarTipoServicio(Servicio servicio) {
		if(servicio.getTipoSercivio()==Servicio.TipoServicio.URGENCIA)
			return true;
		return false;
	}
	
	
	public String getMedico() {
		return medico;
	}


	public void setMedico(String medico) {
		this.medico = medico;
	}


	public abstract  long calcularTarifa();
	public abstract Vector<Object> reporteAmbulancia();
	public abstract Vector<Object> reporteAmbulanciaTarifa() ;

	
}
