package co.edu.javeriana.ambulancias.Vistas;

import java.util.Arrays;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import co.edu.javeriana.ambulancias.inteface.IServicioAmbulancias;
import co.edu.javeriana.ambulancias.negocio.Servicio;
import co.edu.javeriana.ambulancias.presentacion.TestGUIAmbulancias;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaAsignarServicio extends JPanel {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	//
	private JTable tableIPS=null;
	private Vector<String> columNameIPS=null;
	private Vector<Object> dataIPS=null;
	private JScrollPane scrollPaneIPS=null;
	private String[] nombresIPS={
			"Nombre","Tipo de atencion","Direccion"
			};
	//
	private JTable tableAmbulancia=null;
	private Vector<String> columNameAmbulancia=null;
	private Vector<Object> dataAmbulancia=null;
	private JScrollPane scrollPaneAmbulancia=null;
	private String[] nombresAmbulancia={
			"Codigo","Tipo","Placa","Medico o Enfermero","Tipo UCI","Hora posicion","Calle","Carrera"
			};
	//
	private JTable tableServicios=null;
	private Vector<String> columNameServicios=null;
	private Vector<Object> dataServicios=null;
	private JScrollPane scrollPaneServicios=null;
	private String[] nombresServicios={
			"Codigo","Hora solicitud","Paciente","Tipo Servicio","Telefono","Direccion","Estado","IPS","Ambulancia"
			};
	//
	/**
	 * Create the panel.
	 */
	public VistaAsignarServicio(IServicioAmbulancias empresaAmbulancia) {
		this.setBounds(0, 0, TestGUIAmbulancias.getW()-20, TestGUIAmbulancias.getH()-55);


		setLayout(null);

		scrollPaneIPS = new JScrollPane();
		scrollPaneIPS.setBounds(6, 34, 452, 107);
		add(scrollPaneIPS);

		tableIPS = infoTablaIPS(empresaAmbulancia);
		scrollPaneIPS.setViewportView(tableIPS);

		 scrollPaneAmbulancia = new JScrollPane();
		scrollPaneAmbulancia.setBounds(6, 169, 452, 99);
		add(scrollPaneAmbulancia);

		tableAmbulancia = infoTablaAmbulancia(empresaAmbulancia);
		scrollPaneAmbulancia.setViewportView(tableAmbulancia);

		 scrollPaneServicios = new JScrollPane();
		scrollPaneServicios.setBounds(6, 296, 452, 99);
		add(scrollPaneServicios);

		tableServicios = infoTablaServicios(empresaAmbulancia);
		scrollPaneServicios.setViewportView(tableServicios);

		JLabel lblIps = new JLabel("IPS");
		lblIps.setBounds(22, 6, 61, 16);
		add(lblIps);

		JLabel lblAmbulancias = new JLabel("Ambulancias");
		lblAmbulancias.setBounds(16, 153, 89, 16);
		add(lblAmbulancias);

		JLabel lblServicios = new JLabel("Servicios");
		lblServicios.setBounds(22, 280, 61, 16);
		add(lblServicios);

		JButton btnAgregarServicio = new JButton("Agregar Servicio");
		btnAgregarServicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asignarServicio(empresaAmbulancia);
			}
		});
		btnAgregarServicio.setBounds(6, 407, 146, 29);
		add(btnAgregarServicio);

		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.setBounds(357, 407, 117, 29);
		add(btnRegresar);

	}

	protected void asignarServicio(IServicioAmbulancias empresaAmbulancia) {
		try{
			int posIPS=this.tableIPS.getSelectedRow();
			int posAmbulancia=this.tableAmbulancia.getSelectedRow();
			int posServicios=this.tableServicios.getSelectedRow();
			String nombreIPS="";
			if(posAmbulancia==-1)
				JOptionPane.showMessageDialog(this, "No ha seleccionado la Ambulancia","No ha selecionado",JOptionPane.WARNING_MESSAGE);
			else if( posServicios==-1)
				JOptionPane.showMessageDialog(this, "No ha seleccionado el servicio","No ha selecionado",JOptionPane.WARNING_MESSAGE);
			else
			{
				long codigoServicio=Long.valueOf(this.tableServicios.getValueAt(posServicios, 0).toString());
				long codigoAmbulancia = Long.valueOf(this.tableAmbulancia.getValueAt(posAmbulancia, 0).toString());
				if( this.tableServicios.getValueAt(posServicios, 3)!=Servicio.TipoServicio.DOMICILIO){
					if( posIPS==-1){
						throw new Exception("No ha seleccionado la IPS");
					}
					nombreIPS = this.tableAmbulancia.getValueAt(posIPS, 0).toString();
				}
				String resultado = empresaAmbulancia.relacionarServicio(codigoServicio, codigoAmbulancia, nombreIPS);
				JOptionPane.showMessageDialog(this,resultado,"Asignado correctamente",JOptionPane.INFORMATION_MESSAGE);
				this.actualizarServicios(empresaAmbulancia);
			}
		}
		catch( Exception e)
		{
			JOptionPane.showMessageDialog(this, "No ha podido agregar el servicio","Error",JOptionPane.ERROR_MESSAGE);
		}

	}

	private JTable infoTablaIPS(IServicioAmbulancias empresaAmbulancia) {
		if(this.columNameIPS==null)
			this.columNameIPS=new Vector<String>(Arrays.asList(this.nombresIPS));
		this.dataIPS=  empresaAmbulancia.reporteIPS();
		return new JTable(this.dataIPS,this.columNameIPS);
	}
	public void actualizarIPS(IServicioAmbulancias empresaAmbulancia) {
		tableIPS = infoTablaIPS(empresaAmbulancia);
		scrollPaneIPS.setViewportView(tableIPS);
	}
	private JTable infoTablaAmbulancia(IServicioAmbulancias empresaAmbulancia) {
		if(this.columNameAmbulancia==null)
			this.columNameAmbulancia=new Vector<String>(Arrays.asList(this.nombresAmbulancia));
		this.dataAmbulancia=  empresaAmbulancia.reporteAmbulancia();
		return new JTable(this.dataAmbulancia,this.columNameAmbulancia);
	}
	public void actualizarAmbulancia(IServicioAmbulancias empresaAmbulancia) {
		tableAmbulancia = infoTablaAmbulancia(empresaAmbulancia);
		scrollPaneAmbulancia.setViewportView(tableAmbulancia);
	}
	private JTable infoTablaServicios(IServicioAmbulancias empresaAmbulancia) {
		if(this.columNameServicios==null)
			this.columNameServicios=new Vector<String>(Arrays.asList(this.nombresServicios));
		this.dataServicios=  empresaAmbulancia.reporteServicios();
		return new JTable(this.dataServicios,this.columNameServicios);
	}
	public void actualizarServicios(IServicioAmbulancias empresaAmbulancia) {
		tableServicios = infoTablaServicios(empresaAmbulancia);
		scrollPaneServicios.setViewportView(tableServicios);
	}
}
