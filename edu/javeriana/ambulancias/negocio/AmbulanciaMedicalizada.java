package co.edu.javeriana.ambulancias.negocio;

public abstract class AmbulanciaMedicalizada extends Ambulancia {
	public AmbulanciaMedicalizada(int codigo, String placa, String tipoDotacion,String medico) {
		super(codigo, placa, tipoDotacion);
		this.medico=medico;
	}

	protected String medico;
	
	public abstract  long calcularTarifa();
}
