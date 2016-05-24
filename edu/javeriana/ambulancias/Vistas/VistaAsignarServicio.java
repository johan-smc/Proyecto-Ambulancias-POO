package co.edu.javeriana.ambulancias.Vistas;

import java.util.Arrays;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import co.edu.javeriana.ambulancias.inteface.IServicioAmbulancias;
import co.edu.javeriana.ambulancias.negocio.Servicio;
import co.edu.javeriana.ambulancias.presentacion.Principal;
import co.edu.javeriana.ambulancias.presentacion.TestGUIAmbulancias;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

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
	private JButton btnAgregarServicio=null;
	private TestGUIAmbulancias testGUIAmbulancias=null;
	/**
	 * Create the panel.
	 */
	public VistaAsignarServicio(TestGUIAmbulancias testGUIAmbulancias) {
		this.setBounds(0, 0, TestGUIAmbulancias.getW()-20, TestGUIAmbulancias.getH()-55);

		this.testGUIAmbulancias=testGUIAmbulancias;
		setLayout(null);

		scrollPaneIPS = new JScrollPane();
		scrollPaneIPS.setBounds(48, 126, 634, 81);
		add(scrollPaneIPS);

		tableIPS = infoTablaIPS(testGUIAmbulancias.getEmpresaAmbulancia());
		scrollPaneIPS.setViewportView(tableIPS);

		 scrollPaneAmbulancia = new JScrollPane();
		scrollPaneAmbulancia.setBounds(48, 394, 634, 81);
		add(scrollPaneAmbulancia);

		tableAmbulancia = infoTablaAmbulancia(testGUIAmbulancias.getEmpresaAmbulancia());
		scrollPaneAmbulancia.setViewportView(tableAmbulancia);

		 scrollPaneServicios = new JScrollPane();
		scrollPaneServicios.setBounds(48, 256, 634, 81);
		add(scrollPaneServicios);

		tableServicios = infoTablaServicios(testGUIAmbulancias.getEmpresaAmbulancia());
		scrollPaneServicios.setViewportView(tableServicios);

		JLabel lblIps = new JLabel("IPS");
		lblIps.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblIps.setBounds(22, 89, 61, 25);
		add(lblIps);

		JLabel lblAmbulancias = new JLabel("Ambulancias");
		lblAmbulancias.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblAmbulancias.setBounds(22, 219, 162, 25);
		add(lblAmbulancias);

		JLabel lblServicios = new JLabel("Servicios");
		lblServicios.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblServicios.setBounds(22, 349, 182, 33);
		add(lblServicios);

		 btnAgregarServicio = new JButton("Asignar Servicio");
		 btnAgregarServicio.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		/*btnAgregarServicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asignarServicio(testGUIAmbulancias.getEmpresaAmbulancia());
			}
		});*/
		btnAgregarServicio.setBounds(80, 487, 232, 108);
		add(btnAgregarServicio);

		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal.vistaWiew(0);
			}
		});
		btnRegresar.setBounds(381, 487, 232, 108);
		add(btnRegresar);
		
		JLabel lblNewLabel = new JLabel("Asignar Servicio");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		lblNewLabel.setBounds(22, 24, 440, 53);
		add(lblNewLabel);

	}

	
	public JButton getBtnAgregarServicio() {
		return btnAgregarServicio;
	}


	public void asignarServicio() {
		try{
			int posIPS=this.tableIPS.getSelectedRow();
			int posAmbulancia=this.tableAmbulancia.getSelectedRow();
			int posServicios=this.tableServicios.getSelectedRow();
			String nombreIPS="";
			long codigoServicio = 0;
			int codigoAmbulancia = 0;
			if(posAmbulancia==-1)
				JOptionPane.showMessageDialog(this, "No ha seleccionado la Ambulancia","No ha selecionado",JOptionPane.WARNING_MESSAGE);
			else if( posServicios==-1)
				JOptionPane.showMessageDialog(this, "No ha seleccionado el servicio","No ha selecionado",JOptionPane.WARNING_MESSAGE);
			else
			{
				 codigoServicio=Long.valueOf(this.tableServicios.getValueAt(posServicios, 0).toString());
				 codigoAmbulancia = Integer.valueOf(this.tableAmbulancia.getValueAt(posAmbulancia, 0).toString());

				if( this.tableServicios.getValueAt(posServicios, 3)!=Servicio.TipoServicio.DOMICILIO){
					if( posIPS==-1){
						throw new Exception("No ha seleccionado la IPS");
					}
					nombreIPS = this.tableIPS.getValueAt(posIPS, 0).toString();
				}
			}

			String resultado = testGUIAmbulancias.getEmpresaAmbulancia().relacionarServicio(codigoServicio, codigoAmbulancia, nombreIPS);

			JOptionPane.showMessageDialog(this,resultado,"Asignado correctamente",JOptionPane.INFORMATION_MESSAGE);

		}
		catch( Exception e)
		{

			JOptionPane.showMessageDialog(this, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
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
