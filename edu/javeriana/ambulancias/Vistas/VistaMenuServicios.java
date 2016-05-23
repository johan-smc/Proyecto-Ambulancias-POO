package co.edu.javeriana.ambulancias.Vistas;

import javax.swing.JPanel;

import co.edu.javeriana.ambulancias.inteface.IServicioAmbulancias;
import co.edu.javeriana.ambulancias.persistencia.ManejadorArchivos;
import co.edu.javeriana.ambulancias.presentacion.Principal;
import co.edu.javeriana.ambulancias.presentacion.TestGUIAmbulancias;

import javax.print.attribute.standard.PrinterInfo;
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
		
		JButton btnRegistrarPosicionAmbulancia = new JButton("Registrar posicion ambulancia");
		btnRegistrarPosicionAmbulancia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal.vistaWiew(2);
			}
		});
		btnRegistrarPosicionAmbulancia.setBounds(52, 60, 340, 29);
		add(btnRegistrarPosicionAmbulancia);
		
		JButton btnAsignarAUn = new JButton("Asignar a un servicio un ambulancia y IPS");
		btnAsignarAUn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal.vistaWiew(3);
			}
		});
		btnAsignarAUn.setBounds(52, 101, 340, 29);
		add(btnAsignarAUn);
		
		JButton btnReporteServiciosCon = new JButton("Reporte servicios con IPS y Ambulancia");
		btnReporteServiciosCon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal.vistaWiew(4);
			}
		});
		btnReporteServiciosCon.setBounds(52, 142, 340, 29);
		add(btnReporteServiciosCon);
		
		JButton btnIngresarIpsO = new JButton("Ingresar IPS o Ambulancia");
		btnIngresarIpsO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal.vistaWiew(1);
			}
		});
		btnIngresarIpsO.setBounds(52, 25, 340, 29);
		add(btnIngresarIpsO);
		
		JButton btnCargar = new JButton("Cargar Datos");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cargarDatos(empresaAmbulancia);
			}
		});
		btnCargar.setBounds(274, 378, 152, 29);
		add(btnCargar);

	}
	
	protected void cargarDatos(IServicioAmbulancias empresaAmbulancia) {
		JFileChooser chooser = new JFileChooser("./");
		int returnVal = chooser.showOpenDialog(this);
		if( returnVal == JFileChooser.APPROVE_OPTION ){
			String dir = chooser.getSelectedFile().getParent();
			String nombre = chooser.getSelectedFile().getName();
			try {
				ManejadorArchivos.cargarDatos(empresaAmbulancia,dir,nombre);
				JOptionPane.showMessageDialog(this,"El archivo se cargo con exito","Exito",JOptionPane.INFORMATION_MESSAGE);
				Principal.actulizarTablasAmbulancias(empresaAmbulancia);
				Principal.actulizarTablasIPS(empresaAmbulancia);
				Principal.actulizarTablasServicio(empresaAmbulancia);
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
