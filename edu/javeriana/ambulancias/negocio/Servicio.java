package co.edu.javeriana.ambulancias.negocio;

import java.util.Calendar;
import java.util.GregorianCalendar;

import co.edu.javeriana.ambulancias.presentacion.Utils;

public class Servicio {
	private static long CONSECUTIVO=0;
	private long codigo;
	private GregorianCalendar horaSolicitud;
	private String paciente;
	private TipoServicio tipoServicio;
	private String telefono;
	private Estado estado;
	private Direccion direccion;
	private IPS ips;
	private Ambulancia ambulancia;
	private long valor;
	
	public static enum TipoServicio
	{
		DOMICILIO,EMERGENCIA,URGENCIA;
	}
	public static enum Estado
	{
		NO_ASIGNADO,ASIGNADO,FINALIZDO;
	}
	
	public Servicio(String nombre, String tipoServicio, String telefono, String tipoDireccion, int n1, int n2,
			int n3) {
		this.codigo=Servicio.getCONSECUTIVO();
		this.paciente=nombre;
		this.tipoServicio=tipo(tipoServicio);
		this.telefono=telefono;
		this.direccion=new Direccion(tipoDireccion,n1,n2,n3);
		this.estado=Estado.NO_ASIGNADO;
		this.horaSolicitud=Utils.horaSistema();
		this.ambulancia=null;
		this.ips=null;
		
	}
	private TipoServicio tipo(String tipoServicio2) {
		if(tipoServicio.equals("EMERGENCIA"))
			return TipoServicio.EMERGENCIA;
		else if( tipoServicio.equals("URGENCIA"))
			return TipoServicio.URGENCIA;
		else if( tipoServicio.equals("DOMICILIO"))
			return TipoServicio.DOMICILIO;
		return null;
	}
	@Override
	public String toString() {
		return codigo+"\t"+Utils.fechaSolicitud(horaSolicitud)+"	"+paciente+" 	"+
				tipoServicio+" 	"+telefono+" 	"+direccion.toString();
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public String getPaciente() {
		return paciente;
	}
	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}
	public TipoServicio getTipoSercivio() {
		return tipoServicio;
	}
	public void setTipoSercivio(TipoServicio tipoSercivio) {
		this.tipoServicio = tipoSercivio;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public GregorianCalendar getHoraSolicitud() {
		return horaSolicitud;
	}
	private static long getCONSECUTIVO() {
		return CONSECUTIVO++;
	}
	public long getCodigo() {
		return codigo;
	}
	public void relacionar(Ambulancia ambulancia, IPS ips) {
		this.ips=ips;
		this.ambulancia=ambulancia;
		if(tipoServicio!=TipoServicio.DOMICILIO)
			ips.relacionarServicio(this);
		ambulancia.relacionarServicio(this);
		this.estado=Estado.ASIGNADO;
		
	}
	public String toString(boolean b) {
		String ret="SERVICIO\n";
		ret+="Codigo\tHoraSolicitud\tPaciente\tTipoServicio\tTelefono\tDireccion\tEstado\tValor\n";
		ret+="----------------------------------------------------------------------------------------\n";
		ret+=codigo+"\t"+Utils.fechaSolicitud(horaSolicitud)+"\t"+paciente+" 	"+
				tipoServicio+"\t"+telefono+"\t"+direccion.toString()+"\t"+estado+"\t"+valor+"\n";
		if(this.ips!=null)
		{
			ret+="\tIPS asignada:\n";
			ret+="\tNombre                TipoAtencion            Direccion\n";
			ret+="\t-----------------------------------------------------------------------------------\n";
			ret+="\t"+ips.toString()+"\n";
		}
		if( this.ambulancia!=null)
		{
			ret+="\tAmbulancia asignada:\n";
			ret+="\tTipoAmb\tCodigo\tPlaca\tMedico/enfermero\tTipoUCI\tHoraPosicion\tCalle\tCarrera\tTarifa\n";
			ret+="\t-----------------------------------------------------------------------------------\n";
			ret+="\t";
			ret+=ambulancia.toString();
		}
		return ret;
	}
	public String toStringEspecial() {
		return codigo+"\t"+paciente+"\t"+ambulancia.getCodigo()+"\t"+ips.getNombre();
	}
	public void finalizarServicio(){
		this.estado=Estado.FINALIZDO;
		this.ambulancia.retirarServicio();
		
	}
	
	public String toStringEspecialSupremo()
	{
		return codigo+"\t"+Utils.fechaSolicitud(horaSolicitud)+"\t"+paciente+"\t"+tipoServicio+"\t"+telefono+"\t"
				+direccion.toString()+"\t"+estado+"\t"+ambulancia.getCodigo();
	}
	public long calcularValor(){
		valor=ambulancia.calcularTarifa();
		if(this.horaSolicitud.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY||this.horaSolicitud.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY)
			valor+=(valor*0.2);
		return valor;
		
	}
	
}
