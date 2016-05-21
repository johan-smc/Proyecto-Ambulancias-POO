package co.edu.javeriana.ambulancias.Vistas;

import java.util.Arrays;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import co.edu.javeriana.ambulancias.inteface.IServicioAmbulancias;
import co.edu.javeriana.ambulancias.presentacion.TestGUIAmbulancias;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaReporteSeriviciosIPSAmbulancia extends JPanel {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JTable tableServicios=null;
	private Vector<String> columNameServicios=null;
	private Vector<Object> dataServicios=null;
	private JScrollPane scrollPaneServicios=null;
	private String[] nombresServicios={
			"Codigo","Hora solicitud","Paciente","Tipo Servicio","Telefono","Direccion","Estado","Valor"
			};
	private JLabel lblTipoAtencion;
	private JTextField txtCodigo;
	private JTextField txtTipo;
	private JTextField txtPlaca;
	private JTextField txtMedicoOEnfermero;
	private JTextField txtTipouci;
	private JTextField txtHoraposicion;
	private JTextField txtCalle;
	private JTextField txtCarrera;
	private JTextField txtTarifa;
	private JTextField txtNombreips;
	private JTextField txtTipoAtencionIPS;
	private JTextField txtDireccionips;
	/**
	 * Create the panel.
	 */
	public VistaReporteSeriviciosIPSAmbulancia(IServicioAmbulancias empresaAmbulancia) {
		setLayout(null);
		this.setBounds(0, 0, TestGUIAmbulancias.getW()-20, TestGUIAmbulancias.getH()-55);

		scrollPaneServicios = new JScrollPane();
		scrollPaneServicios.setBounds(6, 53, 468, 92);
		add(scrollPaneServicios);

		tableServicios =  infoTablaServicios(empresaAmbulancia);
		scrollPaneServicios.setViewportView(tableServicios);

		JLabel lblServicios = new JLabel("Servicios");
		lblServicios.setBounds(6, 25, 61, 16);
		add(lblServicios);

		JButton btnMostrarIpsY = new JButton("Mostrar IPS y Ambulancia asignada");
		btnMostrarIpsY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarIPSAmbulancia(empresaAmbulancia);
			}
		});
		btnMostrarIpsY.setBounds(99, 157, 263, 29);
		add(btnMostrarIpsY);

		JLabel lblIps = new JLabel("IPS");
		lblIps.setBounds(6, 224, 61, 16);
		add(lblIps);

		JLabel lblAmbulancia = new JLabel("Ambulancia");
		lblAmbulancia.setBounds(6, 317, 74, 16);
		add(lblAmbulancia);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(6, 252, 61, 16);
		add(lblNombre);

		lblTipoAtencion = new JLabel("Tipo atencion");
		lblTipoAtencion.setBounds(133, 252, 94, 16);
		add(lblTipoAtencion);

		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(301, 252, 61, 16);
		add(lblDireccion);

		JSeparator separator = new JSeparator();
		separator.setBounds(6, 241, 468, 12);
		add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(6, 264, 468, 12);
		add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(6, 339, 468, 12);
		add(separator_2);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(6, 363, 468, 12);
		add(separator_3);

		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(6, 345, 61, 16);
		add(lblCodigo);

		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(54, 345, 61, 16);
		add(lblTipo);

		JLabel lblPlaca = new JLabel("Placa");
		lblPlaca.setBounds(90, 345, 61, 16);
		add(lblPlaca);

		JLabel lblMedicoOEnfermero = new JLabel("Medico o enfermero");
		lblMedicoOEnfermero.setBounds(133, 345, 61, 16);
		add(lblMedicoOEnfermero);

		JLabel lblTipoUci = new JLabel("Tipo UCI");
		lblTipoUci.setBounds(205, 345, 61, 16);
		add(lblTipoUci);

		JLabel lblHoraPosicion = new JLabel("Hora Posicion");
		lblHoraPosicion.setBounds(263, 345, 61, 16);
		add(lblHoraPosicion);

		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setBounds(327, 345, 61, 16);
		add(lblCalle);

		JLabel lblCarrera = new JLabel("Carrera");
		lblCarrera.setBounds(362, 345, 61, 16);
		add(lblCarrera);

		JLabel lblTarifa = new JLabel("Tarifa");
		lblTarifa.setBounds(413, 345, 61, 16);
		add(lblTarifa);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(6, 373, 47, 26);
		add(txtCodigo);
		txtCodigo.setColumns(10);

		txtTipo = new JTextField();
		txtTipo.setBounds(47, 373, 61, 26);
		add(txtTipo);
		txtTipo.setColumns(10);

		txtPlaca = new JTextField();
		txtPlaca.setBounds(99, 373, 54, 26);
		add(txtPlaca);
		txtPlaca.setColumns(10);

		txtMedicoOEnfermero = new JTextField();
		txtMedicoOEnfermero.setBounds(143, 373, 94, 26);
		add(txtMedicoOEnfermero);
		txtMedicoOEnfermero.setColumns(10);

		txtTipouci = new JTextField();
		txtTipouci.setBounds(231, 373, 61, 26);
		add(txtTipouci);
		txtTipouci.setColumns(10);

		txtHoraposicion = new JTextField();
		txtHoraposicion.setBounds(285, 373, 47, 26);
		add(txtHoraposicion);
		txtHoraposicion.setColumns(10);

		txtCalle = new JTextField();
		txtCalle.setBounds(324, 373, 47, 26);
		add(txtCalle);
		txtCalle.setColumns(10);

		txtCarrera = new JTextField();
		txtCarrera.setBounds(362, 373, 47, 26);
		add(txtCarrera);
		txtCarrera.setColumns(10);

		txtTarifa = new JTextField();
		txtTarifa.setBounds(400, 373, 74, 26);
		add(txtTarifa);
		txtTarifa.setColumns(10);

		txtNombreips = new JTextField();
		txtNombreips.setBounds(6, 280, 135, 26);
		add(txtNombreips);
		txtNombreips.setColumns(10);

		txtTipoAtencionIPS = new JTextField();
		txtTipoAtencionIPS.setBounds(133, 280, 159, 26);
		add(txtTipoAtencionIPS);
		txtTipoAtencionIPS.setColumns(10);

		txtDireccionips = new JTextField();
		txtDireccionips.setBounds(285, 280, 159, 26);
		add(txtDireccionips);
		txtDireccionips.setColumns(10);

		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.setBounds(362, 411, 117, 29);
		add(btnRegresar);

	}


	protected void mostrarIPSAmbulancia(IServicioAmbulancias empresaAmbulancia) {
		try{
			int posServicio=this.tableServicios.getSelectedRow();
			if(posServicio==-1)
				throw new Exception("No selecciono servicio");
			long codigoServicio=Long.valueOf(this.tableServicios.getValueAt(posServicio, 0).toString());
			Vector<Object> info=empresaAmbulancia.reporteServicioAmbulancia(codigoServicio);
			if(info==null)
				throw new Exception("No tiene ambulancia relacionada");
			this.txtCodigo.setText(info.get(0).toString());
			this.txtTipo.setText(info.get(1).toString());
			this.txtPlaca.setText(info.get(2).toString());
			this.txtMedicoOEnfermero.setText(info.get(3).toString());
			this.txtTipouci.setText(info.get(4).toString());
			this.txtHoraposicion.setText(info.get(5).toString());
			this.txtCalle.setText(info.get(6).toString());
			this.txtCarrera.setText(info.get(7).toString());
			this.txtTarifa.setText(info.get(8).toString());
			info=empresaAmbulancia.reporteServicioIPS(codigoServicio);
			if(info!=null)
			{
				this.txtNombreips.setText(info.get(0).toString());
				this.txtTipoAtencionIPS.setText(info.get(1).toString());
				this.txtDireccionips.setText(info.get(2).toString());
			}

		}
		catch( Exception e)
		{
			JOptionPane.showMessageDialog(this, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}
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
