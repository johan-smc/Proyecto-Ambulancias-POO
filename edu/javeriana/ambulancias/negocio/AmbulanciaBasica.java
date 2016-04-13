package co.edu.javeriana.ambulancias.negocio;

public class AmbulanciaBasica extends AmbulanciaMedicalizada{

	public AmbulanciaBasica(int codigo, String placa, String tipoDotacion, String medico) {
		super(codigo, placa, tipoDotacion, medico);
		// TODO Auto-generated constructor stub
	}

	@Override
	public long calcularTarifa() {
		// TODO Auto-generated method stub
		return 0;
	}

}
