package co.edu.javeriana.ambulancias.presentacion;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import co.edu.javeriana.ambulancias.Vistas.VistaAsignarServicio;
import co.edu.javeriana.ambulancias.Vistas.VistaIngresarIPSAmbulancias;
import co.edu.javeriana.ambulancias.Vistas.VistaMenuServicios;
import co.edu.javeriana.ambulancias.Vistas.VistaRegistrarPosicionAmbulancia;
import co.edu.javeriana.ambulancias.inteface.IServicioAmbulancias;

public class Principal extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTabbedPane tabbedPane ;
	private static VistaMenuServicios vistaMenuServicios;
	private static VistaIngresarIPSAmbulancias vistaIngresarIPSAmbulancias;
	private static VistaRegistrarPosicionAmbulancia vistaRegistrarPosicionAmbulancia;
	private static VistaAsignarServicio vistaAsignarServicio;
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
		vistaMenuServicios=new VistaMenuServicios();
		tabbedPane.addTab("Menu de servicios", null,vistaMenuServicios , null);
		
		vistaIngresarIPSAmbulancias = new VistaIngresarIPSAmbulancias(empresaAmbulancia);
		tabbedPane.addTab("Ingresar Ips o Ambulancias", null, vistaIngresarIPSAmbulancias, null);
		
		vistaRegistrarPosicionAmbulancia=new  VistaRegistrarPosicionAmbulancia(empresaAmbulancia);
		tabbedPane.addTab("Registrar posicion ambulancias", null,vistaRegistrarPosicionAmbulancia, null);
		
		vistaAsignarServicio=new  VistaAsignarServicio(empresaAmbulancia);
		tabbedPane.addTab("Asignar un Servicio", null,vistaAsignarServicio, null);
	}

	public static void actulizarTablasAmbulancias(IServicioAmbulancias empresaAmbulancia) {
		vistaRegistrarPosicionAmbulancia.actualizar(empresaAmbulancia);
		vistaAsignarServicio.actualizarAmbulancia(empresaAmbulancia);
	}

	public static void actulizarTablasIPS(IServicioAmbulancias empresaAmbulancia) {
		vistaAsignarServicio.actualizarIPS(empresaAmbulancia);
		
	}

	

}
