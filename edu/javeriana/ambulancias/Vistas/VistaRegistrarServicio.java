package co.edu.javeriana.ambulancias.Vistas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import co.edu.javeriana.ambulancias.inteface.IServicioAmbulancias;
import co.edu.javeriana.ambulancias.presentacion.TestGUIAmbulancias;

import javax.swing.JComboBox;
import javax.swing.JButton;

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
	private JComboBox<String> dspServicio;
	private JComboBox<String> dspDireccion;
	private String contenido[]={"DOMICILIO","EMERGENCIA","URGENCIA"};
	private String contenido2[]={"CALLE","CARRERA"};
	private JButton bttnRegistrar=null;
	/**
	 * Create the panel.
	 */
	public VistaRegistrarServicio(TestGUIAmbulancias testGUIAmbulancias) {
		setLayout(null);
		
		JLabel txtPaciente = new JLabel("Paciente");
		txtPaciente.setBounds(26, 88, 46, 14);
		add(txtPaciente);
		
		JLabel txtDatos = new JLabel("Datos del nuevo servicio");
		txtDatos.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtDatos.setBounds(10, 11, 263, 35);
		add(txtDatos);
		
		JLabel lblTipoServicio = new JLabel("Tipo servicio");
		lblTipoServicio.setBounds(26, 128, 46, 14);
		add(lblTipoServicio);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(26, 169, 46, 14);
		add(lblTelefono);
		
		JLabel lblTipoDireccion = new JLabel("Tipo direccion");
		lblTipoDireccion.setBounds(26, 194, 46, 14);
		add(lblTipoDireccion);
		
		JLabel lblCalle = new JLabel("calle");
		lblCalle.setBounds(26, 230, 46, 14);
		add(lblCalle);
		
		JLabel lblCarrera = new JLabel("carrera");
		lblCarrera.setBounds(26, 255, 46, 14);
		add(lblCarrera);
		
		JLabel lblNumero = new JLabel("numero");
		lblNumero.setBounds(26, 296, 46, 14);
		add(lblNumero);
		
		bxtPaciente = new JTextField();
		bxtPaciente.setBounds(111, 85, 86, 20);
		add(bxtPaciente);
		bxtPaciente.setColumns(10);
		
		bxttelefono = new JTextField();
		bxttelefono.setColumns(10);
		bxttelefono.setBounds(111, 166, 86, 20);
		add(bxttelefono);
		
		bxtCalle = new JTextField();
		bxtCalle.setColumns(10);
		bxtCalle.setBounds(111, 224, 86, 20);
		add(bxtCalle);
		
		bxtCarrera = new JTextField();
		bxtCarrera.setColumns(10);
		bxtCarrera.setBounds(111, 252, 86, 20);
		add(bxtCarrera);
		
		bxtNumero = new JTextField();
		bxtNumero.setColumns(10);
		bxtNumero.setBounds(111, 293, 86, 20);
		add(bxtNumero);
		
		
		dspServicio = new JComboBox<String>(contenido);
		dspServicio.setBounds(111, 125, 86, 20);
		add(dspServicio);
		
		
		
		dspDireccion = new JComboBox<String>(contenido2);
		dspDireccion.setBounds(111, 191, 95, 20);
		add(dspDireccion);
		
		 bttnRegistrar = new JButton("Registrar");
		/*bttnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Registremos(testGUIAmbulancias.getEmpresaAmbulancia());
			}

			
		});*/
		bttnRegistrar.setBounds(279, 99, 89, 23);
		add(bttnRegistrar);
		
		JButton bttnRegresar = new JButton("Regresar");
		bttnRegresar.setBounds(279, 226, 89, 23);
		add(bttnRegresar);

	}
	public void Registremos(IServicioAmbulancias empresaAmbulancia) {
		
		try
		{

			
			//System.out.println(( (String) (dspServicio.getItemAt(dspServicio.getSelectedIndex()))));
			empresaAmbulancia.agregarServicio(bxtPaciente.getText(),( dspServicio.getItemAt(dspServicio.getSelectedIndex()).toString()),bxttelefono.getText(), ( dspDireccion.getItemAt(dspDireccion.getSelectedIndex()).toString()), Integer.parseInt(bxtCalle.getText()), Integer.parseInt(bxtCarrera.getText()),Integer.parseInt( bxtNumero.getText()));
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
