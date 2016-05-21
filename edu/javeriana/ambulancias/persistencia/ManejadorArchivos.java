package co.edu.javeriana.ambulancias.persistencia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.StringTokenizer;

import co.edu.javeriana.ambulancias.inteface.IServicioAmbulancias;


public class ManejadorArchivos {



			public static String ingresarIPS(String dir, IServicioAmbulancias empresa)
			{
				try{
					Scanner input=new Scanner(new File(dir));

					String a, nombre, tipoAtencion,tipoDireccion;
					int calle, carrera, numero;
					int cantidad=0;
					a=input.nextLine();

					while(!a.equals("0"))
						{
								/*if(a.charAt(0)=='#' && a.charAt(1)!='n')
								{
									input.close();
									return "ERROR!: El archivo tiene formato incorrecto.";
								}*/
								if(a.charAt(0)!='#'&&a.trim().length()>0)
								{
								   StringTokenizer hola=new StringTokenizer(a, "*");

								   nombre=hola.nextToken().trim();
							       tipoAtencion=hola.nextToken().trim();
							       tipoDireccion=hola.nextToken().trim();
							       calle=Integer.valueOf(hola.nextToken().trim());
							       carrera=Integer.valueOf(hola.nextToken().trim());
							       numero=Integer.valueOf(hola.nextToken().trim());
							       if(empresa.agregarIPS(nombre, tipoAtencion, tipoDireccion, calle, carrera, numero))
							    	   ++cantidad;
						       }
								a=input.nextLine();
						}

					input.close();
					return "EXITOSO!.\nSe guardaron "+cantidad+" IPS.";
				}catch(FileNotFoundException e){

					return "ERROR!.";
				}

			}
			public static String ingresarAmbulancia(String dir, IServicioAmbulancias empresa)
			{
				try{
					Scanner input=new Scanner(new File(dir));

					String placa,tipoAmbulancia,tipoUCI="",a,medico;
					int codigo;
					int cantidad=0;
					a=input.nextLine();
					/*if(a.charAt(0)=='#' && a.charAt(1)!='v')
					{
							input.close();
							return "ERROR!: El archivo tiene formato incorrecto.";
					}*/

					while(!a.equals("0"))
						{


								if(a.charAt(0)!='#'&&a.trim().length()>0)
								{
								   StringTokenizer hola=new StringTokenizer(a, "*");
								   tipoAmbulancia=hola.nextToken().trim();

								   codigo=Integer.valueOf(hola.nextToken().trim());

								   placa=hola.nextToken().trim();
								   medico=hola.nextToken().trim();
								   if(tipoAmbulancia.equals("UCI"))
									   tipoUCI=hola.nextToken().trim();
							       if(empresa.agregarAmbulancia(codigo, placa,tipoAmbulancia,medico,tipoUCI))
							    	   ++cantidad;
						}
								       a=input.nextLine();
						}

					input.close();
					return "LECTURA CORRECTA!.\nSe guardaron "+cantidad+" Ambulancias.";
				}catch(FileNotFoundException e){


					return "ERROR!.";
				}

			}
			public static void salvarDatos(IServicioAmbulancias empresaAmbulancia, String dir, String nombre) throws IOException {
				File outFile=new File(dir+"/"+nombre);
				FileOutputStream outStream = new FileOutputStream(outFile);
				ObjectOutputStream objectOutStream = new ObjectOutputStream(outStream);
				objectOutStream.writeObject(empresaAmbulancia);
				objectOutStream.close();
			}

		}
