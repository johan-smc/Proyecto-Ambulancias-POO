package co.edu.javeriana.ambulancias.presentacion;

import java.util.Scanner;
import co.edu.javeriana.ambulancias.negocio.*;
import co.edu.javeriana.ambulancias.persistencia.ManejadorArchivos;

public class TestAmbulancia {

	private static Scanner opc;

	public static void main(String[] args) {
		
		
		String archivoName;
		
		EmpresaAmbulancias empresaAmbulancia=new EmpresaAmbulancias("BabySoft");
		
		opc = new Scanner(System.in);
		
		Scanner dato1=new Scanner(System.in);
		Scanner dato2=new Scanner(System.in);
		Scanner dato3=new Scanner(System.in);
		
		int opcion;
		do{
			menu();			
			opcion=opc.nextInt();
			
			switch(opcion){
			
			case 1:{
				
				System.out.println("Ingrese el nombre del archivo (example.txt): ");
				
				archivoName=dato1.nextLine();
				ManejadorArchivos.ingresarIPS(archivoName, empresaAmbulancia);
			
				break;
				}
			case 2:{
				System.out.println("Ingrese el nombre del archivo (example.txt): ");
				
				archivoName=dato1.nextLine();
				ManejadorArchivos.ingresarAmbulancia(archivoName, empresaAmbulancia);
				break;
				}
			case 3:{
				
				int codigo=dato1.nextInt();
				int calle=dato2.nextInt();
				int carrera=dato3.nextInt();
				
				boolean exito=empresaAmbulancia.registrarPosAmbulancia( codigo, calle,  carrera);
				if(exito)
				{
					System.out.println("EXITO");
				}else{
					
					System.out.println("ERROR");
				}


				break;
				}
			case 4:{
				
				break;
				}
			case 5:{
				 
				reportedeambulancias(opc, empresaAmbulancia); 
				
				
				break;
				}
			case 6:{
				
				break;
				}
			case 7:{
				
				break;
				}
			case 8:{
				
				break;
				}
			case 9:{
				
				break;
				}
			case 10:{
				
				break;
				}
			default:{
				System.err.println("NOOO!!! OPCION INCORRECTA");
			}
			
			
			}
		
		
		}while(opcion!=10);
		
		
		
	System.out.println("GRACIAS POR PREFERIRNOS");
		
	dato1.close();
	dato2.close();
	dato3.close();
	}
	private static void menu(){
	System.out.println("opcion 1: ingresar las IPS al sistema\nopcion 2: ingresar las ambulancias al sistema\nopcion 3: registrar la posicion actual de una ambulancia\nopcion 4: registrar un servicio\nopcion 5: reporte de ambulancias\nopcion 6: asignar a un servicio una ambulancia y una IPS\nopcion 7: finalizar un servicio\nopcion 8: reporte de servicios con IPS y ambulancias asignados\nopcion 9: reporte de las IPS con servicios asociados\nopcion 10: terminar");
	}
	
	
	private static void reportedeambulancias(Scanner sc, EmpresaAmbulancias empresaambulancia){
		
		System.out.println("codigo placa tipoDotacion horaPosicion posicionCalle posicionCarrera servicio")
		System.out.println(empresaambulancia.reporteambul());
		
		
	}
}

