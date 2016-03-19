package co.edu.javeriana.ambulancias.presentacion;

import java.util.Scanner;
import co.edu.javeriana.ambulancias.negocio.*;
import co.edu.javeriana.ambulancias.persistencia.ManejadorArchivos;

public class TestAmbulancia {

	private static Scanner opc;

	public static void main(String[] args) {
		
		

		
		EmpresaAmbulancias empresaAmbulancia=new EmpresaAmbulancias("BabySoft");
		
		opc = new Scanner(System.in);
		
		
		
		
		String opcion;
		char primervalor;
		do{
			menu();			
			opcion=opc.next();
			primervalor=opcion.charAt(0);
			switch(primervalor){
			
			case '1':{
				
				ingresarIPS(opc, empresaAmbulancia);
				break;
				}
			case '2':{
				ingresarAmbulacia(opc,empresaAmbulancia);
				break;
				}
			case '3':{

				registrarPocicionAmbulancia(opc,empresaAmbulancia);


				break;
				}
			case '4':{
				registrarAmbulancia(opc,empresaAmbulancia);
				break;
				}
			case '5':{
				 
				reportedeambulancias(empresaAmbulancia); 
				break;
				}
			case '6':{
				asignarServicioAmbulanciaIPS(opc,empresaAmbulancia);
				break;
				}
			case '7':{
				finalizarServicio(opc, empresaAmbulancia);
				break;
				}
			case '8':{
				reporteServiciosIPSAmbulancia(empresaAmbulancia);
				break;
				}
			case '9':{
				reporteServiciosIPS(empresaAmbulancia);
				break;
				}

			default:{
				System.err.println("NOOO!!! OPCION INCORRECTA");
			}
			
			
			}
		
		
		}while(!opcion.trim().equals("10"));
		
		
		
	System.out.println("GRACIAS POR PREFERIRNOS");
		

	opc.close();
	}
	private static void reporteServiciosIPSAmbulancia(EmpresaAmbulancias empresaAmbulancia) {
		System.out.println(empresaAmbulancia.reporteServiciosIPSAmbulacia());
		
	}
	private static void asignarServicioAmbulanciaIPS(Scanner sc, EmpresaAmbulancias empresaAmbulancia) {
		System.out.println(empresaAmbulancia.reporteServiciosNoAsignadas());
		System.out.println("--Cual es el codigo del servicio que desea asignar ?:");
		Long codigo=sc.nextLong();
		if( empresaAmbulancia.verificarCodigoServicio(codigo) )
		{
			
			System.out.println(empresaAmbulancia.relacionarServicio(codigo));
		}
		else System.err.println("El codigo que ingreso no existe");
		
	}
	private static void registrarAmbulancia(Scanner sc, EmpresaAmbulancias empresaAmbulancias) {
		String nombre,tipoServicio,telefono,tipoDireccion;
		int n1,n2,n3;
		System.out.println("Ingrese el nombre del paciente");
		nombre=sc.nextLine();
		nombre=sc.nextLine();
		System.out.println("Ingrese el tipo de servicio");
		tipoServicio=sc.next();
		System.out.println("Ingrese el telefono");
		telefono=sc.next();
		System.out.println("Ingrese el tipo de direccion");
		tipoDireccion=sc.next();
		System.out.println("ingrese la calle, carrera y el numero");
		n1=sc.nextInt();
		n2=sc.nextInt();
		n3=sc.nextInt();
		long codigo=empresaAmbulancias.agregarServicio(nombre,tipoServicio,telefono,tipoDireccion,n1,n2,n3);
		System.out.println("El nuevo Servicio tiene codigo "+codigo);
	}
	private static void registrarPocicionAmbulancia(Scanner opc2, EmpresaAmbulancias empresaAmbulancia) {
		System.out.println("Ingrese el codigo de la ambulancia");
		int codigo=opc.nextInt();
		System.out.println("Ingrese la calle y la carrera");
		int calle=opc.nextInt();
		int carrera=opc.nextInt();
		
		boolean exito=empresaAmbulancia.registrarPosAmbulancia( codigo, calle,  carrera);
		if(exito)
		{
			System.out.println("EXITO");
		}else{
			
			System.out.println("ERROR");
		}
		
	}
	private static void ingresarAmbulacia(Scanner opc2, EmpresaAmbulancias empresaAmbulancia) {
		System.out.println("Ingrese el nombre del archivo (example.txt): ");
		
		String archivoName=opc2.nextLine();
		archivoName=opc2.nextLine();
		ManejadorArchivos.ingresarAmbulancia(archivoName, empresaAmbulancia);
		
	}
	private static void ingresarIPS(Scanner sc,EmpresaAmbulancias empresaAmbulancia) {
		System.out.println("Ingrese el nombre del archivo (example.txt): ");
		String archivoName=sc.nextLine();
		archivoName=sc.nextLine();
		ManejadorArchivos.ingresarIPS(archivoName, empresaAmbulancia);
	
		

	}
	private static void menu(){
	System.out.println("opcion 1: ingresar las IPS al sistema\nopcion 2: ingresar las ambulancias al sistema\nopcion 3: registrar la posicion actual de una ambulancia\nopcion 4: registrar un servicio\nopcion 5: reporte de ambulancias\nopcion 6: asignar a un servicio una ambulancia y una IPS\nopcion 7: finalizar un servicio\nopcion 8: reporte de servicios con IPS y ambulancias asignados\nopcion 9: reporte de las IPS con servicios asociados\nopcion 10: terminar");
	}
	
	
	private static void reportedeambulancias(EmpresaAmbulancias empresaambulancia){
		
		System.out.println("codigo\tplaca\ttipoDotacion\thoraPosicion\tposicionCalle\tposicionCarrera\tservicio");
		System.out.println(empresaambulancia.reporteambul());
		
		
	}
	private static void finalizarServicio(Scanner opc, EmpresaAmbulancias empresaAmbulancias)
	{
		empresaAmbulancias.reporteServiciosSiAsignadas();
		System.out.println("Ingrese el codigo del servicio a finalizar: ");
		if(empresaAmbulancias.finAServicio(opc.nextLong()))
		{
			System.out.println("EXITO!!!");
		}
		else
		{
			System.err.println("ERROR U_U");
		}
		
		
	}
	private static void reporteServiciosIPS(EmpresaAmbulancias empresaAmbulancia)
	{
		System.out.println(empresaAmbulancia.reportarIPS());
		
	}
	
	}


