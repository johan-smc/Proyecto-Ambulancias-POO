package co.edu.javeriana.ambulancias.Vistas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import co.edu.javeriana.ambulancias.presentacion.Principal;
import co.edu.javeriana.ambulancias.presentacion.TestGUIAmbulancias;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaRegistrarServicio extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField bxtPaciente;
	private JTextField bxttelefono;
	private JTextField bxtCalle;
	private JTextField bxtCarrera;
	private JTextField bxtNumero;
	private JComboBox<Object> dspServicio;
	private JComboBox<Object> dspDireccion;
	private String contenido[]={"DOMICILIO","EMERGENCIA","URGENCIA"};
	private String contenido2[]={"CALLE","CARRERA"};
	private JButton bttnRegistrar=null;
	private TestGUIAmbulancias testGUIAmbulancias=null;
	/**
	 * Create the panel.
	 */
	public VistaRegistrarServicio(TestGUIAmbulancias testGUIAmbulancias) {
		setLayout(null);
		this.testGUIAmbulancias=testGUIAmbulancias;
		this.setBounds(0, 0, TestGUIAmbulancias.getW()-20, TestGUIAmbulancias.getH()-55);
		JLabel txtPaciente = new JLabel("Paciente");
		txtPaciente.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		txtPaciente.setBounds(33, 88, 114, 20);
		add(txtPaciente);
		
		JLabel txtDatos = new JLabel("Datos del nuevo servicio");
		txtDatos.setFont(new Font("Tahoma", Font.PLAIN, 35));
		txtDatos.setBounds(10, 11, 567, 35);
		add(txtDatos);
		
		JLabel lblTipoServicio = new JLabel("Tipo servicio");
		lblTipoServicio.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblTipoServicio.setBounds(33, 166, 150, 21);
		add(lblTipoServicio);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblTelefono.setBounds(33, 244, 114, 23);
		add(lblTelefono);
		
		JLabel lblTipoDireccion = new JLabel("Tipo direccion");
		lblTipoDireccion.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblTipoDireccion.setBounds(33, 322, 146, 23);
		add(lblTipoDireccion);
		
		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblCalle.setBounds(33, 400, 114, 24);
		add(lblCalle);
		
		JLabel lblCarrera = new JLabel("Carrera");
		lblCarrera.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblCarrera.setBounds(33, 478, 114, 25);
		add(lblCarrera);
		
		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNumero.setBounds(33, 556, 114, 26);
		add(lblNumero);
		
		bxtPaciente = new JTextField();
		bxtPaciente.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		bxtPaciente.setBounds(195, 78, 177, 42);
		add(bxtPaciente);
		bxtPaciente.setColumns(10);
		
		bxttelefono = new JTextField();
		bxttelefono.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		bxttelefono.setColumns(10);
		bxttelefono.setBounds(195, 235, 177, 42);
		add(bxttelefono);
		
		bxtCalle = new JTextField();
		bxtCalle.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		bxtCalle.setColumns(10);
		bxtCalle.setBounds(195, 392, 177, 42);
		add(bxtCalle);
		
		bxtCarrera = new JTextField();
		bxtCarrera.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		bxtCarrera.setColumns(10);
		bxtCarrera.setBounds(195, 470, 177, 42);
		add(bxtCarrera);
		
		bxtNumero = new JTextField();
		bxtNumero.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		bxtNumero.setColumns(10);
		bxtNumero.setBounds(195, 549, 177, 42);
		add(bxtNumero);
		
		
		dspServicio = new JComboBox<Object>(contenido);
		dspServicio.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		dspServicio.setBounds(195, 156, 177, 42);
		add(dspServicio);
		
		
		
		dspDireccion = new JComboBox<Object>(contenido2);
		dspDireccion.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		dspDireccion.setBounds(191, 313, 181, 42);
		add(dspDireccion);
		
		 bttnRegistrar = new JButton("Registrar");
		 bttnRegistrar.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		/*bttnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Registremos(testGUIAmbulancias.getEmpresaAmbulancia());
			}

			
		});*/
		bttnRegistrar.setBounds(420, 128, 232, 108);
		add(bttnRegistrar);
		
		JButton bttnRegresar = new JButton("Regresar");
		bttnRegresar.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		bttnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal.vistaWiew(0);
			}
		});
		bttnRegresar.setBounds(420, 366, 232, 108);
		add(bttnRegresar);

	}
	public void Registremos() {
		
		try
		{

			
			//System.out.println(( (String) (dspServicio.getItemAt(dspServicio.getSelectedIndex()))));
			testGUIAmbulancias.getEmpresaAmbulancia().agregarServicio(bxtPaciente.getText(),( dspServicio.getItemAt(dspServicio.getSelectedIndex()).toString()),bxttelefono.getText(), ( dspDireccion.getItemAt(dspDireccion.getSelectedIndex()).toString()), Integer.parseInt(bxtCalle.getText()), Integer.parseInt(bxtCarrera.getText()),Integer.parseInt( bxtNumero.getText()));
			JOptionPane.showMessageDialog(null, "Se registro existosamente", "EXITO", JOptionPane.INFORMATION_MESSAGE);
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error al registrar", JOptionPane.ERROR_MESSAGE);
			try
			{
				Integer.parseInt(bxtCalle.getText()); 
				
				
			}
			catch(Exception a)
			{
				JOptionPane.showMessageDialog(null, "Error: Esa Calle es de verdad?", "Error al registrar", JOptionPane.ERROR_MESSAGE);
			}
			
			try
			{
				 Integer.parseInt(bxtCarrera.getText());
					
			}
			catch(Exception a)
			{
				JOptionPane.showMessageDialog(null, "Error: Esa Carrera es de verdad?", "Error al registrar", JOptionPane.ERROR_MESSAGE);
			}
			
			try
			{
				Integer.parseInt( bxtNumero.getText());
			}
			catch(Exception a)
			{
				JOptionPane.showMessageDialog(null, "Error: Ese Numero es de verdad?", "Error al registrar", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	public JButton getBttnRegistrar() {
		return bttnRegistrar;
	}
	
}
