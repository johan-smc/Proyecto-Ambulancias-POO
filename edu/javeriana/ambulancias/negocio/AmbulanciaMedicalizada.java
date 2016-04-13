package co.edu.javeriana.ambulancias.negocio;

public abstract class AmbulanciaMedicalizada extends Ambulancia {
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
	
	public abstract  long calcularTarifa();
}
