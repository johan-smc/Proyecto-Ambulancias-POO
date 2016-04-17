package co.edu.javeriana.ambulancias.inteface;

import java.util.List;
import java.util.Map;

import co.edu.javeriana.ambulancias.negocio.Ambulancia;
import co.edu.javeriana.ambulancias.negocio.Servicio;

public interface IServicioAmbulancias {
	public void agregarIPS(String nombre, String tipoAtencion,  String tipoDireccion, int calle, int carrera, int numero);
	public void agregarAmbulancia(int codigo,String placa, String tipoAmbulancia, String medico, String tipoUCI);
	public boolean registrarPosAmbulancia(int codigo,int calle, int carrera);
	public long agregarServicio(String nombre, String tipoServicio, String telefono, String tipoDireccion, int n1,
			int n2, int n3);
	public String relacionarServicio(Long codigo);
	public boolean finAServicio(long codigo);
	public List<Servicio> getServicios(); 
	public Map<Integer, Ambulancia> getAmbulancias();
	public boolean verificarCodigoServicio(Long codigo);
	public String reporteServiciosIPSAmbulacia();
	public String reporteServiciosNoAsignadas();
	public String reportarIPS();
	public String reporteambul();
	public String estadisticaAmbulanciasDisponibles();
	public String reporteServiciosSiAsignadas();
}
