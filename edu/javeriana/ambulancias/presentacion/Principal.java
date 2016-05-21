package co.edu.javeriana.ambulancias.presentacion;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import co.edu.javeriana.ambulancias.Vistas.VistaAsignarServicio;
import co.edu.javeriana.ambulancias.Vistas.VistaIngresarIPSAmbulancias;
import co.edu.javeriana.ambulancias.Vistas.VistaMenuServicios;
import co.edu.javeriana.ambulancias.Vistas.VistaRegistrarPosicionAmbulancia;
import co.edu.javeriana.ambulancias.Vistas.VistaReporteSeriviciosIPSAmbulancia;
import co.edu.javeriana.ambulancias.inteface.IServicioAmbulancias;

public class Principal extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JTabbedPane tabbedPane ;
	private static VistaMenuServicios vistaMenuServicios;
	private static VistaIngresarIPSAmbulancias vistaIngresarIPSAmbulancias;
	private static VistaRegistrarPosicionAmbulancia vistaRegistrarPosicionAmbulancia;
	private static VistaAsignarServicio vistaAsignarServicio;
	private static VistaReporteSeriviciosIPSAmbulancia vistaReporteSeriviciosIPSAmbulancia;
	/**
	 * Create the panel.
	 * @param empresaAmbulancia 
	 */
	public Principal(IServicioAmbulancias empresaAmbulancia) {
		this.setBounds(0, 0, TestGUIAmbulancias.getW(), TestGUIAmbulancias.getH());
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, TestGUIAmbulancias.getW(), TestGUIAmbulancias.getH());
		add(tabbedPane);
		///hay que mirar la ruta
		 ImageIcon icon =new ImageIcon( "nose.jpg");
		vistaMenuServicios=new VistaMenuServicios(empresaAmbulancia);
		tabbedPane.addTab("Menu de servicios", icon,vistaMenuServicios , null);
		
		vistaIngresarIPSAmbulancias = new VistaIngresarIPSAmbulancias(empresaAmbulancia);
		tabbedPane.addTab("Ingresar Ips o Ambulancias", null, vistaIngresarIPSAmbulancias, null);
		
		vistaRegistrarPosicionAmbulancia=new  VistaRegistrarPosicionAmbulancia(empresaAmbulancia);
		tabbedPane.addTab("Registrar posicion ambulancias", null,vistaRegistrarPosicionAmbulancia, null);
		
		vistaAsignarServicio=new  VistaAsignarServicio(empresaAmbulancia);
		tabbedPane.addTab("Asignar un Servicio", null,vistaAsignarServicio, null);
		
		vistaReporteSeriviciosIPSAmbulancia=new  VistaReporteSeriviciosIPSAmbulancia(empresaAmbulancia);
		tabbedPane.addTab("Reporte Servicio con Ips y Ambulancia", null,vistaReporteSeriviciosIPSAmbulancia, null);
		
		
	}

	public static void actulizarTablasAmbulancias(IServicioAmbulancias empresaAmbulancia) {
		vistaRegistrarPosicionAmbulancia.actualizar(empresaAmbulancia);
		vistaAsignarServicio.actualizarAmbulancia(empresaAmbulancia);
	}

	public static void actulizarTablasIPS(IServicioAmbulancias empresaAmbulancia) {
		vistaAsignarServicio.actualizarIPS(empresaAmbulancia);
		
	}

	public static void vistaWiew(int i) {
		tabbedPane.setSelectedIndex(i);
		
	}
	//sacado de https://docs.oracle.com/javase/tutorial/uiswing/examples/components/TabbedPaneDemoProject/src/components/TabbedPaneDemo.java
	protected static ImageIcon createImageIcon(String path) {
		
	        java.net.URL imgURL = Principal.class.getResource(path);
	        if (imgURL != null) {
	            return new ImageIcon(imgURL);
	        } else {
	            System.err.println("Couldn't find file: " + path);
	            return null;
	        }
	}
	

}
