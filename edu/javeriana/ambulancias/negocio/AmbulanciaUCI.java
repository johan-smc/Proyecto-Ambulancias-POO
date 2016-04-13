package co.edu.javeriana.ambulancias.negocio;

public class AmbulanciaUCI extends AmbulanciaMedicalizada{

	private String tipoUCI;
	public AmbulanciaUCI(int codigo, String placa, String tipoDotacion, String medico,String tipoUCI) {
		super(codigo, placa, tipoDotacion, medico);
		this.tipoUCI=tipoUCI;
	}

	@Override
	public long calcularTarifa() {
		// TODO Auto-generated method stub
		return 0;
	}

}
