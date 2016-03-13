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
					Scanner input=new Scanner(new File("./"+dir));
					
					String a, nombre, tipoAtencion,tipoDireccion; 
					int calle, carrera, numero;
					
					a=input.nextLine();
					
					while(a.indexOf("0")==-1)
						{
								if(a.charAt(0)!='#')
								{
								   StringTokenizer hola=new StringTokenizer(a, "*");  
								   
								   nombre=hola.nextToken();
							       tipoAtencion=hola.nextToken();
							       tipoDireccion=hola.nextToken();
							       calle=Integer.valueOf(hola.nextToken()); 
							       carrera=Integer.valueOf(hola.nextToken());
							       numero=Integer.valueOf(hola.nextToken());
							       
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
					Scanner input=new Scanner(new File("./"+dir));
					
					String placa,tipoDotacion,a; 
					int codigo;
					
					a=input.nextLine();
					
					while(a.indexOf("0")==-1)
						{
								if(a.charAt(0)!='#')
								{
								   StringTokenizer hola=new StringTokenizer(a, "*");  
								   
								   codigo=Integer.valueOf(hola.nextToken());
							       placa=hola.nextToken();
							       tipoDotacion=hola.nextToken();
							       empresa.agregarAmbulancia(codigo,placa,tipoDotacion);
						       }
								a=input.nextLine();						
						}
					
					input.close();
				}catch(FileNotFoundException e){
					
					System.err.println("ERRRRROOOORRRR");
				}
				
			}

		}