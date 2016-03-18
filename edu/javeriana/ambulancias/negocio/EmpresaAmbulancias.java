package co.edu.javeriana.ambulancias.negocio;

import java.util.ArrayList;


import java.util.HashMap;

import java.util.List;
import java.util.Map;

import java.util.Set;

import co.edu.javeriana.ambulancias.presentacion.Utils;

public class EmpresaAmbulancias {
		private String nombre;
		private List<IPS> losIPS;
		private Map<Long,Servicio> servicios;
		private List<Ambulancia> ambulancias;
		
		
		public void agregarIPS(String nombre, String tipoAtencion,  String tipoDireccion, int calle, int carrera, int numero){
				
				losIPS.add(new IPS(nombre, tipoAtencion, tipoDireccion, calle, carrera, numero));
		}
		public void agregarAmbulancia(int codigo,String placa, String tipoDotacion)
		{
			ambulancias.add(new Ambulancia(codigo,placa,tipoDotacion));
		}
		
		public boolean registrarPosAmbulancia(int codigo,int calle, int carrera)
		{
			boolean esta=false;
			for(Ambulancia ambulancia: ambulancias){
				
				
				if(ambulancia.getCodigo()==codigo)
				{
					ambulancia.setPosicionCalle(calle);
					ambulancia.setPosicionCarrera(carrera);
					ambulancia.sethora();
					esta=true;
					break;
				}
				
			}
			return esta;
			
		}
		public String reporteambul(){
			
			String todas="";
			for(Ambulancia ambulancia : ambulancias)
			{
				todas=todas+ambulancia.getCodigo()+"\t";
				todas=todas+ambulancia.getPlaca()+"\t";
				todas=todas+ambulancia.getTipoDotacion()+"\t";
				todas=todas+ambulancia.getHoraPosicion()+"\t";
				todas=todas+ambulancia.getPosicionCalle()+"\t";
				todas=todas+ambulancia.getPosicionCarrera()+"\t";
				if(ambulancia.getServicioAsignado()!=null)
				{
					todas=todas+ambulancia.getServicioAsignado();
					
				}
				todas+="\n";
				
			}
			return todas;
			
		}
		
		
		public EmpresaAmbulancias(String nombre) {
			this.nombre=nombre;
			this.losIPS=new ArrayList<IPS>();
			this.servicios=new HashMap<Long,Servicio>();
			this.ambulancias=new ArrayList<Ambulancia>();
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public long agregarServicio(String nombre, String tipoServicio, String telefono, String tipoDireccion, int n1,
				int n2, int n3) {
			
			Servicio temp=new Servicio(nombre,tipoServicio,telefono,tipoDireccion,n1,n2,n3);
			this.servicios.put(temp.getCodigo(), temp);
			return temp.getCodigo();
			
		}
		public String reporteServiciosNoAsignadas() {
			String reporte="--ASIGNAR UN SERVICIO A UNA AMBULANCIA Y A UN IPS\n";
			reporte+="--se muestran los servicios del sistema sin asignar:\n";
			reporte+="codigo horaSolicitud paciente tipoServicio telefono direccion \n";
			reporte+="--------------------------------------------------------------------------\n";
			Set<Long> setKey= servicios.keySet();
			for(Long key:setKey)
			{
				Servicio temp=servicios.get(key);
				if(temp.getEstado().equals("NO_ASIGNADO"))
					reporte+=temp.toString()+"\n";
			}
			return reporte;
		}
		public boolean verificarCodigoServicio(Long codigo) {
			return servicios.containsKey(codigo);
		}
		public String relacionarServicio(Long codigo) {
			
			Servicio servicio=servicios.get(codigo);
			Ambulancia ambulancia=ambulanciaMasCercana(servicio);
			if(ambulancia==null)
				return "No se encontro ambulancia disponible";
			IPS ips=ipsMasCercana(servicio);
			if(ips==null)
				return "No se encomtro IPS disponible";
			servicio.relacionar(ambulancia,ips);
			return "Al servicio "+codigo+" le fue asignada la ambulancia "+ambulancia.getCodigo()+" y la IPS "+ips.getNombre();
		}
		private IPS ipsMasCercana(Servicio servicio) {
			int men=999999,valorT;
			IPS menI = null;
			for(IPS o : losIPS)
			{
				valorT=Utils.calcularDistancia(o.getDireccion(),servicio.getDireccion());
				if(valorT<men )
				{
					menI=o;
					men=valorT;
				}
					
			}
			return menI;
		}
		private boolean comprovarTipoServicio(Servicio servicio,  Ambulancia ambulancia) {
			if(servicio.getTipoSercivio().equals("EMERGENCIA")&&!ambulancia.getTipoDotacion().equals("ALTA_UCI"))
				return false;
			return true;
		}
		private Ambulancia ambulanciaMasCercana(Servicio servicio) {
			int men=999999,valorT;
			Ambulancia menA = null;
			for(Ambulancia o : ambulancias)
			{
				valorT=Utils.calcularDistancia(new Direccion(o.getPosicionCalle(),o.getPosicionCarrera()),servicio.getDireccion());
				if(valorT<men&&comprovarTipoServicio(servicio,o)&&!o.isAsignada())
				{
					menA=o;
					men=valorT;
				}
					
			}
			return menA;
		}
		public String reporteServiciosIPSAmbulacia() {
			String reporte="--REPORTE DE SERVICIOS CON IPS Y AMBULANCIAS ASOCIADAS\n\n";
			Set<Long> setKey= servicios.keySet();
			for(Long key:setKey)
			{
				reporte+=servicios.get(key).toString(true)+"\n";
			}
			return reporte;
		}

		
}
