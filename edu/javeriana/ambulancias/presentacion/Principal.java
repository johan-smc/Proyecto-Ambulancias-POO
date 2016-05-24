package co.edu.javeriana.ambulancias.presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import co.edu.javeriana.ambulancias.Vistas.VistaAsignarServicio;
import co.edu.javeriana.ambulancias.Vistas.VistaFinalizarServicio;
import co.edu.javeriana.ambulancias.Vistas.VistaIngresarIPSAmbulancias;
import co.edu.javeriana.ambulancias.Vistas.VistaMenuServicios;
import co.edu.javeriana.ambulancias.Vistas.VistaRegistrarPosicionAmbulancia;
import co.edu.javeriana.ambulancias.Vistas.VistaRegistrarServicio;
import co.edu.javeriana.ambulancias.Vistas.VistaReporteIPS;
import co.edu.javeriana.ambulancias.Vistas.VistaReporteSeriviciosIPSAmbulancia;


public class Principal extends JPanel {

	/**
	 *
	 */
	private  static final long serialVersionUID = 1L;
	private static  JTabbedPane tabbedPane ;
	private  VistaMenuServicios vistaMenuServicios;
	private  VistaIngresarIPSAmbulancias vistaIngresarIPSAmbulancias;
	private  VistaRegistrarPosicionAmbulancia vistaRegistrarPosicionAmbulancia;
	private VistaAsignarServicio vistaAsignarServicio;
	private  VistaReporteSeriviciosIPSAmbulancia vistaReporteSeriviciosIPSAmbulancia;
	private  VistaFinalizarServicio vistaFinalizarServicio;
	private VistaRegistrarServicio vistaRegistrarServicio;
	private  VistaReporteIPS vistaReporteIPS;
	private TestGUIAmbulancias testGUIAmbulancias=null;
	/**
	 * Create the panel.
	 * @param testGUIAmbulancias
	 */
	public Principal(TestGUIAmbulancias testGUIAmbulancias) {
		this.setBounds(0, 0, TestGUIAmbulancias.getW(), TestGUIAmbulancias.getH()-10);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		this.testGUIAmbulancias=testGUIAmbulancias;
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, TestGUIAmbulancias.getW(), TestGUIAmbulancias.getH());
		add(tabbedPane);
		///hay que mirar la ruta
		 //ImageIcon icon =new ImageIcon( "nose.jpg");
		///////////////////////////////////////////////////////////////////////////////////////////

		vistaMenuServicios=new VistaMenuServicios( testGUIAmbulancias);
		tabbedPane.addTab("Menu de servicios", null,vistaMenuServicios , null);
		this.vistaMenuServicios.getBtnCargar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vistaMenuServicios.cargarDatos();
				actulizarTablasAmbulancias();
				actulizarTablasIPS();
				actulizarTablasServicio();
			}
		});
		///////////////////////////////////////////////////////////////////////////////////////////

		vistaIngresarIPSAmbulancias = new VistaIngresarIPSAmbulancias(testGUIAmbulancias);
		tabbedPane.addTab("Ingresar Ips o Ambulancias", null, vistaIngresarIPSAmbulancias, null);
		
		this.vistaIngresarIPSAmbulancias.getBtnIngresarAmbulancia().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vistaIngresarIPSAmbulancias.ingresarAmbulancia();
				actulizarTablasAmbulancias();
			}
		});
		this.vistaIngresarIPSAmbulancias.getBtnIngresarIps().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vistaIngresarIPSAmbulancias.ingresarIPS();
				actulizarTablasIPS();
			}
		});
		///////////////////////////////////////////////////////////////////////////////////////////

		vistaRegistrarPosicionAmbulancia=new  VistaRegistrarPosicionAmbulancia(testGUIAmbulancias);
		tabbedPane.addTab("Registrar posicion ambulancias", null,vistaRegistrarPosicionAmbulancia, null);
		this.vistaRegistrarPosicionAmbulancia.getBtnActualizar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actulizarTablasAmbulancias();
			}
		});
		///////////////////////////////////////////////////////////////////////////////////////////

		vistaAsignarServicio=new  VistaAsignarServicio(testGUIAmbulancias);
		tabbedPane.addTab("Asignar un Servicio", null,vistaAsignarServicio, null);
		this.vistaAsignarServicio.getBtnAgregarServicio().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vistaAsignarServicio.asignarServicio();
				actulizarTablasServicio();
			}
		});
		///////////////////////////////////////////////////////////////////////////////////////////
		vistaReporteSeriviciosIPSAmbulancia=new  VistaReporteSeriviciosIPSAmbulancia(testGUIAmbulancias);
		tabbedPane.addTab("Reporte Servicio con Ips y Ambulancia", null,vistaReporteSeriviciosIPSAmbulancia, null);
		///////////////////////////////////////////////////////////////////////////////////////////

		vistaFinalizarServicio=new VistaFinalizarServicio(testGUIAmbulancias);
		tabbedPane.addTab("Finalizar Servicio",null,vistaFinalizarServicio , null);
		vistaFinalizarServicio.getBtnFinalizar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vistaFinalizarServicio.Finalicemos();
				actulizarTablasServicio();
			}

			
		});
		///////////////////////////////////////////////////////////////////////////////////////////

		vistaRegistrarServicio=new VistaRegistrarServicio(testGUIAmbulancias);
		tabbedPane.addTab("Registrar Servicio", null,vistaRegistrarServicio , null);
		this.vistaRegistrarServicio.getBttnRegistrar().addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						vistaRegistrarServicio.Registremos();
						actulizarTablasServicio();
					}
				});
		
		///////////////////////////////////////////////////////////////////////////////////////////

		vistaReporteIPS=new VistaReporteIPS(testGUIAmbulancias);
		tabbedPane.addTab("Reporte IPS", null,vistaReporteIPS , null);

		
	}

	public  void actulizarTablasAmbulancias() {
		vistaRegistrarPosicionAmbulancia.actualizarTabla(testGUIAmbulancias.getEmpresaAmbulancia());
		vistaAsignarServicio.actualizarAmbulancia(testGUIAmbulancias.getEmpresaAmbulancia());
	}

	public  void actulizarTablasIPS() {
		vistaAsignarServicio.actualizarIPS(testGUIAmbulancias.getEmpresaAmbulancia());
		vistaReporteIPS.actualizarIPS(testGUIAmbulancias.getEmpresaAmbulancia());

	}
	public  void actulizarTablasServicio() {
		vistaAsignarServicio.actualizarServicios(testGUIAmbulancias.getEmpresaAmbulancia());
		vistaReporteSeriviciosIPSAmbulancia.actualizarServicios(testGUIAmbulancias.getEmpresaAmbulancia());
		vistaFinalizarServicio.actualizarServicios(testGUIAmbulancias.getEmpresaAmbulancia());

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
