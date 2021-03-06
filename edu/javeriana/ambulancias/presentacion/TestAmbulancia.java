package co.edu.javeriana.ambulancias.presentacion;

import java.util.Scanner;

import co.edu.javeriana.ambulancias.inteface.IServicioAmbulancias;
import co.edu.javeriana.ambulancias.negocio.*;
import co.edu.javeriana.ambulancias.persistencia.ManejadorArchivos;

public class TestAmbulancia {

	private static Scanner opc;

	public static void main(String[] args) {


		/*char letra=0;
		   for(int i=0; i<=255 ; i++ )
		        System.out.println("El codigo ASCII de la letra " +
		                            letra++ + " es " + i);      */


//		 System.out.println(Utils.imprimirLinea(215)); //������������������������ peque�as
//		 System.out.println(Utils.imprimirLinea(187)); //������������������������ peque�os
//		 System.out.println(Utils.imprimirLinea(95));  //__________________________
//		 System.out.println(Utils.imprimirLinea(175)); //������������������������������


		System.out.println("\t\t\t  //////////////////////////////////\n"+"\t\t\t ///BIENVENIDO A BABYSOFT SYSTEM///\n"+"\t\t\t//////////////////////////////////\n");

		IServicioAmbulancias empresaAmbulancia=new EmpresaAmbulancias("BabySoft");

		opc = new Scanner(System.in);

		String opcion;
		int primervalor;
		menu();
		opcion=opc.nextLine().trim();

		while(!opcion.trim().equals("12")){
			primervalor='.';
			if(Utils.isNumeric(opcion))
				primervalor=Integer.parseInt(opcion);


			switch(primervalor)
			{
				case 1:{

					ingresarIPS(opc, empresaAmbulancia);
					break;
					}
				case 2:{
					ingresarAmbulacia(opc,empresaAmbulancia);
					break;
					}
				case 3:{
					registrarPosicionAmbulancia(opc,empresaAmbulancia);
					break;
					}
				case 4:{
					registrarServicio(opc,empresaAmbulancia);
					break;
					}
				case 5:{
					reportedeambulancias(empresaAmbulancia);
					break;
					}
				case 6:{
					asignarServicioAmbulanciaIPS(opc,empresaAmbulancia);
					break;
					}
				case 7:{
					finalizarServicio(opc, empresaAmbulancia);
					break;
					}
				case 8:{
					reporteServiciosIPSAmbulancia(empresaAmbulancia);
					break;
					}
				case 9:{
					reporteServiciosIPS(empresaAmbulancia);
					break;
					}
				case 10:
					{
					estadisticasAmbulanciasDisponibles(empresaAmbulancia);
					break;
				}
				case 11:
				{
				    reportedePAcientes(empresaAmbulancia);
				break;
			}

				default:{
					System.err.println("OPCION INCORRECTA, INTENTE DE NUEVO.");
				}

			}
			menu();
			opcion=opc.nextLine().trim();
		}
		System.out.println("\n"+Utils.imprimirLinea(215,100)+"\n\n\t\t\t  //////////////////////////////////\n"+"\t\t\t ///GRACIAS POR PREFERIRNOS!!!!!///\n"+"\t\t\t//////////////////////////////////\n");

	opc.close();
	}



	private static void estadisticasAmbulanciasDisponibles(IServicioAmbulancias empresaAmbulancia) {
		System.out.println(empresaAmbulancia.estadisticaAmbulanciasDisponibles());
	}
	private static void reporteServiciosIPSAmbulancia(IServicioAmbulancias empresaAmbulancia) {
		
		if(!empresaAmbulancia.reporteServiciosIPSAmbulacia().equals("No hay Servicios"))
		{
			System.out.println(empresaAmbulancia.reporteServiciosIPSAmbulacia());
		}
		else
		{
			System.err.println(empresaAmbulancia.reporteServiciosIPSAmbulacia()+".");
		}

		

	}
	private static void asignarServicioAmbulanciaIPS(Scanner sc, IServicioAmbulancias empresaAmbulancia) {

		String Loqueretorno=empresaAmbulancia.reporteServiciosNoAsignadas();
		if(!Loqueretorno.equals("No se han encontrado Servicios."))
		{
			System.out.println(Loqueretorno);
		}
		else
		{
			System.err.println(Loqueretorno);
		}
		if(!Loqueretorno.equals("No se han encontrado Servicios."))
		{
			System.out.println("--Codigo del servicio que desea asignar: ");
			String test=sc.nextLine().trim();
			if( Utils.isNumeric(test) ){
			Long codigo=Long.valueOf(test);
			if( empresaAmbulancia.verificarCodigoServicio(codigo) )
			{
				String verif=empresaAmbulancia.relacionarServicio(codigo);
				if(verif.charAt(0)=='A')
				{
					System.out.println(verif);
				}
				else
				{
					System.err.println(verif);
				}

			}
			else System.err.println("El codigo que ingreso no existe");
			}
			else
				System.err.println("ERROR!.");
		}

	}
	private static void registrarServicio(Scanner sc, IServicioAmbulancias empresaAmbulancias) {
		String nombre,tipoServicio,telefono,tipoDireccion;
		int n1,n2,n3;
		System.out.println("Ingrese el nombre del paciente");
		nombre=sc.nextLine().trim();
		System.out.println("Ingrese el tipo de servicio (URGENCIA, EMERGENCIA o DOMICILIO)");
		tipoServicio=sc.nextLine().trim();
		if(!tipoServicio.equals("URGENCIA")&&!tipoServicio.equals("EMERGENCIA")&&!tipoServicio.equals("DOMICILIO"))
			{
				System.err.println("ERROR!.");
				return;
			}
		System.out.println("Ingrese el telefono");
		telefono=sc.nextLine().trim();
		System.out.println("Ingrese el tipo de direccion (CALLE o CARRERA): ");
		tipoDireccion=sc.nextLine().trim();
		if(! tipoDireccion.equals("CALLE")&&!tipoDireccion.equals("CARRERA"))
		{
			System.err.println("ERROR!.");
			return;
		}
		System.out.println("Ingrese la calle: ");
		String test=sc.nextLine().trim();
		System.out.println("Ingrese la carrera: ");
		String test2=sc.nextLine().trim();
		System.out.println("Ingrese el numero: ");
		String test3=sc.nextLine().trim();
		if(Utils.isNumeric(test)&&Utils.isNumeric(test2)&&Utils.isNumeric(test3)){
			n1=Integer.valueOf(test);
			n2=Integer.valueOf(test2);
			n3=Integer.valueOf(test3);
			long codigo=empresaAmbulancias.agregarServicio(nombre,tipoServicio,telefono,tipoDireccion,n1,n2,n3);
			System.out.println("El nuevo Servicio tiene codigo: "+codigo);
		}
		else
			System.err.println("ERROR!.");
	}
	private static void registrarPosicionAmbulancia(Scanner opc2, IServicioAmbulancias empresaAmbulancia) {
		System.out.println("Ingrese el codigo de la ambulancia: ");
		String test=opc2.nextLine().trim();
		if(Utils.isNumeric(test)){
			int codigo=Integer.valueOf(test);
			System.out.println("Ingrese la calle: ");
			test=opc2.nextLine().trim();
			System.out.println("Ingrese la carrera: ");
			String test2=opc2.nextLine().trim();
			if(Utils.isNumeric(test)&&Utils.isNumeric(test2)){
				int calle=Integer.valueOf(test);
				int carrera=Integer.valueOf(test2);

				boolean exito=empresaAmbulancia.registrarPosAmbulancia( codigo, calle,  carrera);
				if(exito)
				{
					System.out.println("EXITO!.");
				}else{

					System.err.println("ERROR!.");
				}
			}
			else
				System.err.println("ERROR!.");
		}
		else
			System.err.println("ERROR!.");

	}
	private static void ingresarAmbulacia(Scanner opc2, IServicioAmbulancias empresaAmbulancia) {
		System.out.println("Ingrese el nombre del archivo (example.txt): ");

		String archivoName=opc2.nextLine();
		String a=ManejadorArchivos.ingresarAmbulancia(archivoName, empresaAmbulancia);
		if(a.equals("LECTURA CORRECTA!."))
		{
			System.out.println(a);
		}
		else
		{
			System.err.println(a);
		}

	}
	private static void ingresarIPS(Scanner sc,IServicioAmbulancias empresaAmbulancia) {
		System.out.println("Ingrese el nombre del archivo (example.txt): ");
		String archivoName=sc.nextLine();
		String b= ManejadorArchivos.ingresarIPS(archivoName, empresaAmbulancia);
		if(b.equals("EXITOSO!."))
		{
			System.out.println(b);
		}
		else
		{
			System.err.println(b);
		}



	}
	private static void menu(){
	System.out.print("\n"+Utils.imprimirLinea(95,100)+"\n"
			+ "Opcion 1:   Ingresar las IPS al sistema.\nOpcion 2:   Ingresar las ambulancias al sistema.\nOpcion 3:   Registrar la posicion actual de una ambulancia.\nOpcion 4:   Registrar un servicio.\nOpcion 5:   Reporte de ambulancias.\nOpcion 6:   Asignar a un servicio una ambulancia y una IPS.\nOpcion 7:   Finalizar un servicio.\nOpcion 8:   Reporte de servicios con IPS y ambulancias asignados.\nOpcion 9:   Reporte de las IPS con servicios asociados.\nOpcion 10:  Estadisticas de las ambulancias disponibles.\nOpcion 11:  Pacientes atendidos.\nOpcion 12:  Terminar.\n"
			+Utils.imprimirLinea(95,100)+"\n"+"Ingrese la opcion: ");
	}


	private static void reportedeambulancias(IServicioAmbulancias empresaambulancia){

		if(!empresaambulancia.reporteambul().equals("No se encuentran ambulancias."))
		{
			System.out.println(empresaambulancia.reporteambul());
		}
		else
		{
			System.err.println(empresaambulancia.reporteambul());
		}

	}
	private static void finalizarServicio(Scanner opc, IServicioAmbulancias empresaAmbulancias)
	{
		String Loqueretorno=empresaAmbulancias.reporteServiciosSiAsignadas();
		if(!Loqueretorno.equals("No se han encontrado Servicios para finalizar."))
		{
			System.out.println(Loqueretorno);
		}
		else
		{
			System.err.println(Loqueretorno);
		}
		if(!Loqueretorno.equals("No se han encontrado Servicios para finalizar."))
		{
			System.out.println("Ingrese el codigo del servicio a finalizar: ");
			String test=opc.nextLine().trim();
			if(Utils.isNumeric(test)&&empresaAmbulancias.finAServicio(Long.valueOf(test)))
			{
				System.out.println("EXITO!.");
			}
			else
			{
				System.err.println("ERROR!.");
			}
		}


	}
	private static void reporteServiciosIPS(IServicioAmbulancias empresaAmbulancia)
	{
		
		if (!empresaAmbulancia.reportarIPS().equals("No hay IPS.")) {
			
			System.out.println(empresaAmbulancia.reportarIPS());
		}
		else
		{
			System.err.println(empresaAmbulancia.reportarIPS());
		}

	}
	private static void reportedePAcientes(IServicioAmbulancias empresaAmbulancia) {
		if(!empresaAmbulancia.reportePacientes().equals("No hay Pacientes."))
		{
			
			System.out.println(empresaAmbulancia.reportePacientes());
		}
		else
		{
			System.err.println(empresaAmbulancia.reportePacientes());
			
		}
		


	}

	}
