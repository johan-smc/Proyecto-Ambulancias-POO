package co.edu.javeriana.ambulancias.persistencia;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;
import co.edu.javeriana.ambulancias.negocio.*;


public class ManejadorArchivos {
			

			
			public static void ingresarIPS(String dir, EmpresaAmbulancias empresa)
				{			
				try{
					Scanner input=new Scanner(new File("."+dir));
					
					String a, nombre, tipoAtencion,tipoDireccion; 
					int calle, carrera, numero;
					
					a=input.nextLine();
					
					while(!a.equals("0"))
						{
								
								if(a.charAt(0)!='#')
								{
								   StringTokenizer hola=new StringTokenizer(a, "*");  
								   
								   nombre=hola.nextToken().trim();
							       tipoAtencion=hola.nextToken().trim();
							       tipoDireccion=hola.nextToken().trim();
							       calle=Integer.valueOf(hola.nextToken().trim()); 
							       carrera=Integer.valueOf(hola.nextToken().trim());
							       numero=Integer.valueOf(hola.nextToken().trim());
							       
							       empresa.agregarIPS(nombre, tipoAtencion, tipoDireccion, calle, carrera, numero);
						       }
								a=input.nextLine();						
						}
					
					input.close();
					System.out.println("exitoso");
				}catch(FileNotFoundException e){
					
					System.err.println("ERRRRROOOORRRR");
				}
				
				
				
				
				
			}
			public static void ingresarAmbulancia(String dir, EmpresaAmbulancias empresa)
			{
				try{
					Scanner input=new Scanner(new File("."+dir));
					
					String placa,tipoDotacion,a; 
					int codigo;
					
					a=input.nextLine();
					
					while(!a.equals("0"))
						{
								
								if(a.charAt(0)!='#')
								{
								   StringTokenizer hola=new StringTokenizer(a, "*");  
								   
								   codigo=Integer.valueOf(hola.nextToken().trim());
							       
								   placa=hola.nextToken().trim();
							       tipoDotacion=hola.nextToken().trim();
							       empresa.agregarAmbulancia(codigo,placa,tipoDotacion);
						       }
								a=input.nextLine();						
						}
					
					input.close();
					System.out.println("Lectura completa");
				}catch(FileNotFoundException e){
					
					System.err.println("ERRRRROOOORRRR");
				}
				
			}

		}