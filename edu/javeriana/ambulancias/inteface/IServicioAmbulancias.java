package co.edu.javeriana.ambulancias.inteface;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import co.edu.javeriana.ambulancias.negocio.Ambulancia;
import co.edu.javeriana.ambulancias.negocio.Servicio;

public interface IServicioAmbulancias extends Serializable {
	public boolean agregarIPS(String nombre, String tipoAtencion,  String tipoDireccion, int calle, int carrera, int numero);
	public boolean agregarAmbulancia(int codigo,String placa, String tipoAmbulancia, String medico, String tipoUCI);
	public boolean registrarPosAmbulancia(int codigo,int calle, int carrera);
	public long agregarServicio(String nombre, String tipoServicio, String telefono, String tipoDireccion, int n1,int n2, int n3);
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
	public String reportePacientes();
	public Vector< Object > reporteAmbulancia();
	public Vector< Object > reporteIPS();
	public Vector< Object > reporteServicios();
	public String relacionarServicio(Long servicioB,int ambulanciaB,String IPSB) throws  Exception ;
	public Vector<Object> reporteServicioAmbulancia(long codigoServicio);
	public Vector<Object> reporteServicioIPS(long codigoServicio);
	public List<String> listadeIps();
	
	public String[][] datosVistaIPS(String nombre);
	public String getNombre();
	public Vector<Object> reporteServiciosFinalizados();
	public void setConsecutivoServicio();
	

	
	
}
