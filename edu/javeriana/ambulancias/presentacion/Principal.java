package co.edu.javeriana.ambulancias.presentacion;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

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
	private VistaMenuServicios vistaMenuServicios;
	private VistaIngresarIPSAmbulancias vistaIngresarIPSAmbulancias;
	private VistaRegistrarPosicionAmbulancia vistaRegistrarPosicionAmbulancia;
	
	/**
	 * Create the panel.
	 * @param empresaAmbulancia 
	 */
	public Principal(IServicioAmbulancias empresaAmbulancia) {
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 450, 278);
		add(tabbedPane);
		vistaMenuServicios=new VistaMenuServicios();
		tabbedPane.addTab("Menu de servicios", null,vistaMenuServicios , null);
		
		vistaIngresarIPSAmbulancias = new VistaIngresarIPSAmbulancias(empresaAmbulancia);
		tabbedPane.addTab("Ingresar Ips o Ambulancias", null, vistaIngresarIPSAmbulancias, null);
		
		vistaRegistrarPosicionAmbulancia=new  VistaRegistrarPosicionAmbulancia(empresaAmbulancia);
		tabbedPane.addTab("Registrar posicion ambulancias", null,vistaRegistrarPosicionAmbulancia, null);
	}

}
