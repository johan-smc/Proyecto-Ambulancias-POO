package co.edu.javeriana.ambulancias.negocio;

public class AmbulanciaUCI extends AmbulanciaMedicalizada{

	private String tipoUCI;
	public AmbulanciaUCI(int codigo, String placa, String tipoDotacion, String medico,String tipoUCI) {
		super(codigo, placa, tipoDotacion, medico);
		this.tipoUCI=tipoUCI;
	}

	@Override
	public long calcularTarifa() {
		long total=super.TARIFA_BASE;
		if(this.tipoUCI.equals("CARDIOVASCULAR"))
			total+=(super.TARIFA_BASE*0.5);
		else if(this.tipoUCI.equals("PEDIATRICA"))
			total+=(super.TARIFA_BASE*0.6);
		return total;
	}
	public boolean comprovarTipoServicio(Servicio servicio) {
		if(servicio.getTipoSercivio()==Servicio.TipoServicio.URGENCIA)
			return true;
		return super.comprovarTipoServicio(servicio);
	}

}
