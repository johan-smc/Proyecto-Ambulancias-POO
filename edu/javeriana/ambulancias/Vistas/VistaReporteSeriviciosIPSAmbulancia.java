package co.edu.javeriana.ambulancias.Vistas;

import java.util.Arrays;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import co.edu.javeriana.ambulancias.inteface.IServicioAmbulancias;
import co.edu.javeriana.ambulancias.presentacion.Principal;
import co.edu.javeriana.ambulancias.presentacion.TestGUIAmbulancias;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

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
	private TestGUIAmbulancias testGUIAmbulancias=null;
	/**
	 * Create the panel.
	 */
	public VistaReporteSeriviciosIPSAmbulancia(TestGUIAmbulancias testGUIAmbulancias) {
		setLayout(null);
		this.testGUIAmbulancias=testGUIAmbulancias;
		this.setBounds(0, 0, TestGUIAmbulancias.getW()-20, TestGUIAmbulancias.getH()-55);

		scrollPaneServicios = new JScrollPane();
		scrollPaneServicios.setBounds(6, 107, 694, 92);
		add(scrollPaneServicios);

		tableServicios =  infoTablaServicios(testGUIAmbulancias.getEmpresaAmbulancia());
		scrollPaneServicios.setViewportView(tableServicios);

		JLabel lblServicios = new JLabel("Servicios");
		lblServicios.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblServicios.setBounds(6, 70, 132, 26);
		add(lblServicios);

		JButton btnMostrarIpsY = new JButton("Mostrar IPS y Ambulancia asignada");
		btnMostrarIpsY.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnMostrarIpsY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarIPSAmbulancia();
			}
		});
		btnMostrarIpsY.setBounds(203, 210, 340, 70);
		add(btnMostrarIpsY);

		JLabel lblIps = new JLabel("IPS");
		lblIps.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIps.setBounds(6, 273, 61, 16);
		add(lblIps);

		JLabel lblAmbulancia = new JLabel("Ambulancia");
		lblAmbulancia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAmbulancia.setBounds(6, 383, 117, 26);
		add(lblAmbulancia);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre.setBounds(6, 306, 61, 16);
		add(lblNombre);

		lblTipoAtencion = new JLabel("Tipo atencion");
		lblTipoAtencion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTipoAtencion.setBounds(231, 306, 94, 16);
		add(lblTipoAtencion);

		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDireccion.setBounds(446, 306, 61, 16);
		add(lblDireccion);

		JSeparator separator = new JSeparator();
		separator.setBounds(6, 300, 694, 12);
		add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(6, 327, 694, 12);
		add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(16, 449, 694, 12);
		add(separator_2);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(6, 420, 694, 12);
		add(separator_3);

		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCodigo.setBounds(6, 429, 61, 16);
		add(lblCodigo);

		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTipo.setBounds(63, 429, 61, 16);
		add(lblTipo);

		JLabel lblPlaca = new JLabel("Placa");
		lblPlaca.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPlaca.setBounds(117, 429, 61, 16);
		add(lblPlaca);

		JLabel lblMedicoOEnfermero = new JLabel("Medico o enfermero");
		lblMedicoOEnfermero.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMedicoOEnfermero.setBounds(163, 429, 132, 16);
		add(lblMedicoOEnfermero);

		JLabel lblTipoUci = new JLabel("Tipo UCI");
		lblTipoUci.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTipoUci.setBounds(304, 429, 61, 16);
		add(lblTipoUci);

		JLabel lblHoraPosicion = new JLabel("Hora Posicion");
		lblHoraPosicion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHoraPosicion.setBounds(375, 429, 94, 16);
		add(lblHoraPosicion);

		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCalle.setBounds(482, 429, 61, 16);
		add(lblCalle);

		JLabel lblCarrera = new JLabel("Carrera");
		lblCarrera.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCarrera.setBounds(545, 429, 61, 16);
		add(lblCarrera);

		JLabel lblTarifa = new JLabel("Tarifa");
		lblTarifa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTarifa.setBounds(627, 429, 61, 16);
		add(lblTarifa);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(6, 456, 47, 26);
		add(txtCodigo);
		txtCodigo.setColumns(10);

		txtTipo = new JTextField();
		txtTipo.setBounds(52, 456, 61, 26);
		add(txtTipo);
		txtTipo.setColumns(10);

		txtPlaca = new JTextField();
		txtPlaca.setBounds(109, 456, 54, 26);
		add(txtPlaca);
		txtPlaca.setColumns(10);

		txtMedicoOEnfermero = new JTextField();
		txtMedicoOEnfermero.setBounds(163, 456, 132, 26);
		add(txtMedicoOEnfermero);
		txtMedicoOEnfermero.setColumns(10);

		txtTipouci = new JTextField();
		txtTipouci.setBounds(294, 456, 69, 26);
		add(txtTipouci);
		txtTipouci.setColumns(10);

		txtHoraposicion = new JTextField();
		txtHoraposicion.setBounds(363, 456, 106, 26);
		add(txtHoraposicion);
		txtHoraposicion.setColumns(10);

		txtCalle = new JTextField();
		txtCalle.setBounds(469, 456, 61, 26);
		add(txtCalle);
		txtCalle.setColumns(10);

		txtCarrera = new JTextField();
		txtCarrera.setBounds(528, 456, 87, 26);
		add(txtCarrera);
		txtCarrera.setColumns(10);

		txtTarifa = new JTextField();
		txtTarifa.setBounds(614, 456, 74, 26);
		add(txtTarifa);
		txtTarifa.setColumns(10);

		txtNombreips = new JTextField();
		txtNombreips.setBounds(6, 333, 223, 39);
		add(txtNombreips);
		txtNombreips.setColumns(10);

		txtTipoAtencionIPS = new JTextField();
		txtTipoAtencionIPS.setBounds(231, 333, 213, 39);
		add(txtTipoAtencionIPS);
		txtTipoAtencionIPS.setColumns(10);

		txtDireccionips = new JTextField();
		txtDireccionips.setBounds(446, 333, 241, 39);
		add(txtDireccionips);
		txtDireccionips.setColumns(10);

		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal.vistaWiew(0);
			}
		});
		btnRegresar.setBounds(456, 493, 232, 108);
		add(btnRegresar);
		
		JLabel lblReporteServicios = new JLabel("Reporte servicios con IPS y Ambulancia");
		lblReporteServicios.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblReporteServicios.setBounds(6, 11, 682, 50);
		add(lblReporteServicios);

	}


	protected void mostrarIPSAmbulancia() {
		try{
			int posServicio=this.tableServicios.getSelectedRow();
			if(posServicio==-1)
				throw new Exception("No selecciono servicio");
			long codigoServicio=Long.valueOf(this.tableServicios.getValueAt(posServicio, 0).toString());
			Vector<Object> info=testGUIAmbulancias.getEmpresaAmbulancia().reporteServicioAmbulancia(codigoServicio);
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
			info=testGUIAmbulancias.getEmpresaAmbulancia().reporteServicioIPS(codigoServicio);
			if(info!=null)
			{
				this.txtNombreips.setText(info.get(0).toString());
				this.txtTipoAtencionIPS.setText(info.get(1).toString());
				this.txtDireccionips.setText(info.get(2).toString());
			}
			else
			{
				this.txtNombreips.setText("");
				this.txtTipoAtencionIPS.setText("");
				this.txtDireccionips.setText("");
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
		this.dataServicios=  empresaAmbulancia.reporteServiciosFinalizados();
		return new JTable(this.dataServicios,this.columNameServicios);
	}
	public void actualizarServicios(IServicioAmbulancias empresaAmbulancia) {
		tableServicios = infoTablaServicios(empresaAmbulancia);
		scrollPaneServicios.setViewportView(tableServicios);
	}
}
