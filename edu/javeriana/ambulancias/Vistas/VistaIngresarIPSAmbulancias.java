package co.edu.javeriana.ambulancias.Vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import co.edu.javeriana.ambulancias.inteface.IServicioAmbulancias;
import co.edu.javeriana.ambulancias.persistencia.ManejadorArchivos;
import co.edu.javeriana.ambulancias.presentacion.TestGUIAmbulancias;

public class VistaIngresarIPSAmbulancias extends JPanel {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public VistaIngresarIPSAmbulancias(IServicioAmbulancias empresaAmbulancia) {

		this.setBounds(0, 0, TestGUIAmbulancias.getW(), TestGUIAmbulancias.getH());
		JButton btnIngresarAmbulancia = new JButton("Ingresar Ambulancia");
		btnIngresarAmbulancia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresarAmbulancia(empresaAmbulancia);
			}
		});
		btnIngresarAmbulancia.setBounds(42, 88, 160, 29);
		this.add(btnIngresarAmbulancia);

		JButton btnIngresarIps = new JButton("Ingresar IPS");
		btnIngresarIps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresarIPS(empresaAmbulancia);
			}
		});
		btnIngresarIps.setBounds(299, 88, 145, 29);
		this.add(btnIngresarIps);

	}

	protected void ingresarIPS(IServicioAmbulancias empresaAmbulancia) {
		JFileChooser chooser = new JFileChooser("./");
		int returnVal = chooser.showOpenDialog(this);
		if( returnVal == JFileChooser.APPROVE_OPTION ){
			String dir = chooser.getSelectedFile().getParent();
			String nombre = chooser.getSelectedFile().getName();
			try {
				String message = ManejadorArchivos.ingresarIPS(dir+'/'+nombre,empresaAmbulancia );
				JOptionPane.showMessageDialog(this,"IPS cargada con exito",
						message,JOptionPane.WARNING_MESSAGE);
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(this, e.getMessage(),"problema archivo", JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	protected void ingresarAmbulancia(IServicioAmbulancias empresaAmbulancia) {
		JFileChooser chooser = new JFileChooser("./");
		int returnVal = chooser.showOpenDialog(this);
		if( returnVal == JFileChooser.APPROVE_OPTION ){
			String dir = chooser.getSelectedFile().getParent();
			String nombre = chooser.getSelectedFile().getName();
			try {
				String message = ManejadorArchivos.ingresarAmbulancia(dir+'/'+nombre,empresaAmbulancia );
				JOptionPane.showMessageDialog(this,"Ambulancia cargada con exito",
						message,JOptionPane.WARNING_MESSAGE);
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(this, e.getMessage(),"problema archivo", JOptionPane.ERROR_MESSAGE);
			}
		}
		System.out.println("hola");


	}

}
