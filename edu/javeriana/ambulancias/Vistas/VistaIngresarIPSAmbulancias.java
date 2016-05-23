package co.edu.javeriana.ambulancias.Vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import co.edu.javeriana.ambulancias.inteface.IServicioAmbulancias;
import co.edu.javeriana.ambulancias.persistencia.ManejadorArchivos;
import co.edu.javeriana.ambulancias.presentacion.Principal;
import co.edu.javeriana.ambulancias.presentacion.TestGUIAmbulancias;


public class VistaIngresarIPSAmbulancias extends JPanel {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnIngresarIps=null;
	private JButton btnIngresarAmbulancia=null;
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

		this.setBounds(0, 0, TestGUIAmbulancias.getW() - 20, TestGUIAmbulancias.getH() - 55);
		 btnIngresarAmbulancia = new JButton("Ingresar Ambulancia");
		
		/*btnIngresarAmbulancia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresarAmbulancia(testGUIAmbulancias.getEmpresaAmbulancia());
			}
		});*/
		setLayout(null);
		btnIngresarAmbulancia.setBounds(51, 67, 173, 29);
		this.add(btnIngresarAmbulancia);

		 btnIngresarIps = new JButton("Ingresar IPS");
		/*btnIngresarIps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresarIPS(testGUIAmbulancias.getEmpresaAmbulancia());
			}
		});*/
		btnIngresarIps.setBounds(265, 67, 117, 29);
		this.add(btnIngresarIps);
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal.vistaWiew(0);
			}
		});
		btnRegresar.setBounds(177, 264, 98, 29);
		add(btnRegresar);

	}

	public void ingresarIPS(IServicioAmbulancias empresaAmbulancia) {
		JFileChooser chooser = new JFileChooser("./");
		int returnVal = chooser.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			String dir = chooser.getSelectedFile().getParent();
			String nombre = chooser.getSelectedFile().getName();
			try {
				String message = ManejadorArchivos.ingresarIPS(dir + '/' + nombre, empresaAmbulancia);
				JOptionPane.showMessageDialog(this, message, "IPS cargada con exito", JOptionPane.INFORMATION_MESSAGE);

			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "problema archivo", JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	public void ingresarAmbulancia(IServicioAmbulancias empresaAmbulancia) {
		JFileChooser chooser = new JFileChooser("./");
		int returnVal = chooser.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			String dir = chooser.getSelectedFile().getParent();
			String nombre = chooser.getSelectedFile().getName();
			try {
				String message = ManejadorArchivos.ingresarAmbulancia(dir + '/' + nombre, empresaAmbulancia);
				JOptionPane.showMessageDialog(this, message, "Ambulancia cargada con exito",
						JOptionPane.INFORMATION_MESSAGE);
		
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "problema archivo", JOptionPane.ERROR_MESSAGE);
			}
		}

	}

}
