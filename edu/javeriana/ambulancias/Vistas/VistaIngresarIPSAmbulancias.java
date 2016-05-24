package co.edu.javeriana.ambulancias.Vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import co.edu.javeriana.ambulancias.persistencia.ManejadorArchivos;
import co.edu.javeriana.ambulancias.presentacion.Principal;
import co.edu.javeriana.ambulancias.presentacion.TestGUIAmbulancias;
import java.awt.Font;
import javax.swing.JLabel;


public class VistaIngresarIPSAmbulancias extends JPanel {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnIngresarIps=null;
	private JButton btnIngresarAmbulancia=null;
	private TestGUIAmbulancias testGUIAmbulancias=null;
	public JButton getBtnIngresarIps() {
		return btnIngresarIps;
	}

	public JButton getBtnIngresarAmbulancia() {
		return btnIngresarAmbulancia;
	}

	/**
	 * Create the panel.
	 */
	public VistaIngresarIPSAmbulancias(TestGUIAmbulancias testGUIAmbulancias) {
		this.testGUIAmbulancias=testGUIAmbulancias;
		this.setBounds(0, 0, TestGUIAmbulancias.getW() - 20, TestGUIAmbulancias.getH() - 55);
		 btnIngresarAmbulancia = new JButton("Ingresar Ambulancia");
		 btnIngresarAmbulancia.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		
		/*btnIngresarAmbulancia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresarAmbulancia(testGUIAmbulancias.getEmpresaAmbulancia());
			}
		});*/
		setLayout(null);
		btnIngresarAmbulancia.setBounds(58, 170, 279, 231);
		this.add(btnIngresarAmbulancia);

		 btnIngresarIps = new JButton("Ingresar IPS");
		 btnIngresarIps.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		/*btnIngresarIps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresarIPS(testGUIAmbulancias.getEmpresaAmbulancia());
			}
		});*/
		btnIngresarIps.setBounds(373, 170, 279, 231);
		this.add(btnIngresarIps);
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal.vistaWiew(0);
			}
		});
		btnRegresar.setBounds(242, 472, 232, 108);
		add(btnRegresar);
		
		JLabel lblIngresoDeDatos = new JLabel("Ingreso de datos");
		lblIngresoDeDatos.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		lblIngresoDeDatos.setBounds(75, 39, 485, 59);
		add(lblIngresoDeDatos);

	}

	public void ingresarIPS() {
		JFileChooser chooser = new JFileChooser("./");
		int returnVal = chooser.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			String dir = chooser.getSelectedFile().getParent();
			String nombre = chooser.getSelectedFile().getName();
			try {
				String message = ManejadorArchivos.ingresarIPS(dir + '/' + nombre, testGUIAmbulancias.getEmpresaAmbulancia());
				JOptionPane.showMessageDialog(this, message, "IPS cargada con exito", JOptionPane.INFORMATION_MESSAGE);

			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "problema archivo", JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	public void ingresarAmbulancia() {
		JFileChooser chooser = new JFileChooser("./");
		int returnVal = chooser.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			String dir = chooser.getSelectedFile().getParent();
			String nombre = chooser.getSelectedFile().getName();
			try {
				String message = ManejadorArchivos.ingresarAmbulancia(dir + '/' + nombre, testGUIAmbulancias.getEmpresaAmbulancia());
				JOptionPane.showMessageDialog(this, message, "Ambulancia cargada con exito",
						JOptionPane.INFORMATION_MESSAGE);
		
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "problema archivo", JOptionPane.ERROR_MESSAGE);
			}
		}

	}
}
