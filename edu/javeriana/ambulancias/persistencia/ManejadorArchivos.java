package co.edu.javeriana.ambulancias.persistencia;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

import co.edu.javeriana.ambulancias.inteface.IServicioAmbulancias;


public class ManejadorArchivos {



			public static String ingresarIPS(String dir, IServicioAmbulancias empresa)
				{
				try{
					Scanner input=new Scanner(new File("./"+dir));

					String a, nombre, tipoAtencion,tipoDireccion;
					int calle, carrera, numero;

					a=input.nextLine();

					while(!a.equals("0"))
						{
								if(a.charAt(0)=='#' && a.charAt(1)!='n')
								{
									input.close();
									return "ERROR!: El archivo tiene formato incorrecto.";
								}
								if(a.charAt(0)!='#'&&a.trim().length()>0)
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
					return "EXITOSO!.";
				}catch(FileNotFoundException e){

					return "ERROR!.";
				}

			}
			public static String ingresarAmbulancia(String dir, IServicioAmbulancias empresa)
			{
				try{
					Scanner input=new Scanner(new File("./"+dir));

					String placa,tipoAmbulancia,tipoUCI="",a,medico;
					int codigo;

					a=input.nextLine();

					while(!a.equals("0"))
						{
								/*if(a.charAt(0)=='#' && a.charAt(1)!='c')
								{
									input.close();
									return "ERROR!: El archivo tiene formato incorrecto.";
								}*/
								if(a.charAt(0)!='#'&&a.trim().length()>0)
								{
								   StringTokenizer hola=new StringTokenizer(a, "*");
								   tipoAmbulancia=hola.nextToken().trim();

								   codigo=Integer.valueOf(hola.nextToken().trim());

								   placa=hola.nextToken().trim();
								   medico=hola.nextToken().trim();
								   if(tipoAmbulancia.equals("UCI"))
									   tipoUCI=hola.nextToken().trim();
							       empresa.agregarAmbulancia(codigo, placa,tipoAmbulancia,medico,tipoUCI);
						       }
								a=input.nextLine();
						}

					input.close();
					return "LECTURA CORRECTA!.";
				}catch(FileNotFoundException e){


					return "ERROR!.";
				}

			}

		}
