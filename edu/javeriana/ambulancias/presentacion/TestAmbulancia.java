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
		menu();			
		opcion=opc.nextLine().trim();
		while(!opcion.trim().equals("10")){
			primervalor='.';
			if(opcion.trim().length()>0&&opcion.length()<2)
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

				registrarPosicionAmbulancia(opc,empresaAmbulancia);


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
			menu();			
			opcion=opc.nextLine().trim();
		
		
		}
		
		
		
	System.out.println("GRACIAS POR PREFERIRNOS!!!! ");
		

	opc.close();
	}
	private static void reporteServiciosIPSAmbulancia(EmpresaAmbulancias empresaAmbulancia) {
		System.out.println(empresaAmbulancia.reporteServiciosIPSAmbulacia());
		
	}
	private static void asignarServicioAmbulanciaIPS(Scanner sc, EmpresaAmbulancias empresaAmbulancia) {
		System.out.println(empresaAmbulancia.reporteServiciosNoAsignadas());
		System.out.println("--Cual es el codigo del servicio que desea asignar ?:");
		String test=sc.nextLine().trim();
		if( Utils.isNumeric(test) ){
		Long codigo=Long.valueOf(test);
		if( empresaAmbulancia.verificarCodigoServicio(codigo) )
		{
			
			System.out.println(empresaAmbulancia.relacionarServicio(codigo));
		}
		else System.err.println("El codigo que ingreso no existe");
		}
		else 
			System.err.println("Error");
	}
	private static void registrarAmbulancia(Scanner sc, EmpresaAmbulancias empresaAmbulancias) {
		String nombre,tipoServicio,telefono,tipoDireccion;
		int n1,n2,n3;
		System.out.println("Ingrese el nombre del paciente");
		nombre=sc.nextLine().trim();
		System.out.println("Ingrese el tipo de servicio");
		tipoServicio=sc.nextLine().trim();
		System.out.println("Ingrese el telefono");
		telefono=sc.nextLine().trim();
		System.out.println("Ingrese el tipo de direccion");
		tipoDireccion=sc.nextLine().trim();
		System.out.println("ingrese la calle, carrera y el numero");
		String test=sc.nextLine().trim(),test2=sc.nextLine().trim(),test3=sc.nextLine().trim();
		if(Utils.isNumeric(test)&&Utils.isNumeric(test2)&&Utils.isNumeric(test3)){
			n1=Integer.valueOf(test);
			n2=Integer.valueOf(test2);
			n3=Integer.valueOf(test3);
			long codigo=empresaAmbulancias.agregarServicio(nombre,tipoServicio,telefono,tipoDireccion,n1,n2,n3);
			System.out.println("El nuevo Servicio tiene codigo "+codigo);
		}
		else 
			System.err.println("Error");
	}
	private static void registrarPosicionAmbulancia(Scanner opc2, EmpresaAmbulancias empresaAmbulancia) {
		System.out.println("Ingrese el codigo de la ambulancia");
		String test=opc2.nextLine().trim();
		if(Utils.isNumeric(test)){
			int codigo=Integer.valueOf(test);
			System.out.println("Ingrese la calle y la carrera");
			test=opc2.nextLine().trim();
			String test2=opc2.nextLine().trim();
			if(Utils.isNumeric(test)&&Utils.isNumeric(test2)){
				int calle=Integer.valueOf(test);
				int carrera=Integer.valueOf(test2);
				
				boolean exito=empresaAmbulancia.registrarPosAmbulancia( codigo, calle,  carrera);
				if(exito)
				{
					System.out.println("EXITO");
				}else{
					
					System.err.println("ERROR");
				}
			}
			else 
				System.err.println("ERR");
		}
		else 
			System.err.println("ERR");
		
	}
	private static void ingresarAmbulacia(Scanner opc2, EmpresaAmbulancias empresaAmbulancia) {
		System.out.println("Ingrese el nombre del archivo (example.txt): ");
		
		String archivoName=opc2.nextLine();
		ManejadorArchivos.ingresarAmbulancia(archivoName, empresaAmbulancia);
		
	}
	private static void ingresarIPS(Scanner sc,EmpresaAmbulancias empresaAmbulancia) {
		System.out.println("Ingrese el nombre del archivo (example.txt): ");
		String archivoName=sc.nextLine();
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
		System.out.println(empresaAmbulancias.reporteServiciosSiAsignadas());
		System.out.println("Ingrese el codigo del servicio a finalizar: ");
		String test=opc.nextLine().trim();
		if(Utils.isNumeric(test)&&empresaAmbulancias.finAServicio(Long.valueOf(test)))
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


