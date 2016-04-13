package co.edu.javeriana.ambulancias.negocio;

public class AmbulanciaNoMedicalizada extends Ambulancia{

	public AmbulanciaNoMedicalizada(int codigo, String placa, String tipoDotacion,String enfermero) {
		super(codigo, placa, tipoDotacion);
		this.enfermero=enfermero;
	}

	private String enfermero;

	@Override
	public long calcularTarifa() {
		return super.TARIFA_BASE;
	}
	
}
