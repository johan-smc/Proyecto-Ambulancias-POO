package co.edu.javeriana.ambulancias.Vistas;

import javax.swing.JPanel;

import co.edu.javeriana.ambulancias.inteface.IServicioAmbulancias;
import co.edu.javeriana.ambulancias.persistencia.ManejadorArchivos;
import co.edu.javeriana.ambulancias.presentacion.Principal;
import co.edu.javeriana.ambulancias.presentacion.TestGUIAmbulancias;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class VistaMenuServicios extends JPanel {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public VistaMenuServicios(IServicioAmbulancias empresaAmbulancia) {
		this.setBounds(0, 0, TestGUIAmbulancias.getW()-20, TestGUIAmbulancias.getH()-55);
		setLayout(null);
		
		JButton btnSalvarDatosSistema = new JButton("Salvar datos sistema");
		btnSalvarDatosSistema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvarDatos(empresaAmbulancia);
			}
		});
		btnSalvarDatosSistema.setBounds(75, 378, 167, 29);
		add(btnSalvarDatosSistema);

	}

	protected void salvarDatos(IServicioAmbulancias empresaAmbulancia) {
		JFileChooser chooser = new JFileChooser("./");
		int returnVal = chooser.showSaveDialog(this);
		if( returnVal == JFileChooser.APPROVE_OPTION ){
			String dir = chooser.getSelectedFile().getParent();
			String nombre = chooser.getSelectedFile().getName();
			try {
				ManejadorArchivos.salvarDatos(empresaAmbulancia,dir,nombre);
				JOptionPane.showMessageDialog(this,"El archivo se guardo con exito","Exito",JOptionPane.INFORMATION_MESSAGE);
				Principal.actulizarTablasAmbulancias(empresaAmbulancia);
			}
			catch( FileNotFoundException e)
			{
				JOptionPane.showMessageDialog(this, "Revise la ruta","Problema archivo", JOptionPane.ERROR_MESSAGE);
			}
			catch( IOException e)
			{
				System.out.println(e.getMessage());
				System.out.println(e.toString());
				System.out.println(e.getLocalizedMessage());
				JOptionPane.showMessageDialog(this,"No se pudo escribir le archivo","Error escribiendo el archivo", JOptionPane.ERROR_MESSAGE);
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(this, e.getMessage(),"Problema archivo", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}

}
