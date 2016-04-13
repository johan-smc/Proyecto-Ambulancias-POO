package co.edu.javeriana.ambulancias.negocio;

public class AmbulanciaBasica extends AmbulanciaMedicalizada{

	public AmbulanciaBasica(int codigo, String placa, String tipoDotacion, String medico) {
		super(codigo, placa, tipoDotacion, medico);
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

}
