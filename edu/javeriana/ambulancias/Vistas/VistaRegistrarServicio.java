package co.edu.javeriana.ambulancias.Vistas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

import co.edu.javeriana.ambulancias.inteface.IServicioAmbulancias;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaRegistrarServicio extends JPanel {
	private JTextField bxtPaciente;
	private JTextField bxttelefono;
	private JTextField bxtCalle;
	private JTextField bxtCarrera;
	private JTextField bxtNumero;
	private JComboBox dspServicio;
	private JComboBox dspDireccion;
	/**
	 * Create the panel.
	 */
	public VistaRegistrarServicio(IServicioAmbulancias empresaAmbulancia) {
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
		
		String contenido[]={"DOMICILIO","EMERGENCIA","URGENCIA"};
		JComboBox dspServicio = new JComboBox(contenido);
		dspServicio.setBounds(111, 125, 86, 20);
		add(dspServicio);
		
		
		String contenido2[]={"CALLE","CARRERA"};
		JComboBox dspDireccion = new JComboBox(contenido2);
		dspDireccion.setBounds(111, 191, 95, 20);
		add(dspDireccion);
		
		JButton bttnRegistrar = new JButton("Registrar");
		bttnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Registremos(empresaAmbulancia);
			}

			
		});
		bttnRegistrar.setBounds(279, 99, 89, 23);
		add(bttnRegistrar);
		
		JButton bttnRegresar = new JButton("Regresar");
		bttnRegresar.setBounds(279, 226, 89, 23);
		add(bttnRegresar);

	}
	private void Registremos(IServicioAmbulancias empresaAmbulancia) {
		
		try
		{
			empresaAmbulancia.agregarServicio(bxtPaciente.getText(),String.valueOf( dspServicio.getSelectedItem()),bxttelefono.getText(), String.valueOf( dspDireccion.getSelectedItem()), Integer.parseInt(bxtCalle.getText()), Integer.parseInt(bxtCarrera.getText()),Integer.parseInt( bxtNumero.getText()));
			
		}
		catch(Exception e)
		{
			try
			{
				Integer.parseInt(bxtCalle.getText()); 
				JOptionPane.showMessageDialog(null, "Se registro existosamente", "EXITO", JOptionPane.INFORMATION_MESSAGE);
				
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
}
