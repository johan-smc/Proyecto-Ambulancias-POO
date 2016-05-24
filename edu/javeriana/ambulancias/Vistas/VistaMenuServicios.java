package co.edu.javeriana.ambulancias.Vistas;

import javax.swing.JPanel;

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
import java.awt.Font;
import javax.swing.JLabel;

public class VistaMenuServicios extends JPanel {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnSalvarDatosSistema=null;
	private JButton btnCargar =null;
	private TestGUIAmbulancias testGUIAmbulancias=null;
	/**
	 * Create the panel.
	 */
	public VistaMenuServicios(TestGUIAmbulancias testGUIAmbulancias) {
		this.setBounds(0, 0, TestGUIAmbulancias.getW()-20, TestGUIAmbulancias.getH()-55);
		setLayout(null);
		this.testGUIAmbulancias=testGUIAmbulancias;
		 btnSalvarDatosSistema = new JButton("Salvar datos sistema");
		 btnSalvarDatosSistema.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnSalvarDatosSistema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvarDatos();
			}
		});
		btnSalvarDatosSistema.setBounds(80, 469, 232, 108);
		add(btnSalvarDatosSistema);

		JButton btnRegistrarPosicionAmbulancia = new JButton("Registrar posicion ambulancia");
		btnRegistrarPosicionAmbulancia.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnRegistrarPosicionAmbulancia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal.vistaWiew(2);
			}
		});
		btnRegistrarPosicionAmbulancia.setBounds(42, 124, 309, 71);
		add(btnRegistrarPosicionAmbulancia);

		JButton btnAsignarAUn = new JButton("Asignar a un servicio un ambulancia y IPS");
		btnAsignarAUn.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnAsignarAUn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal.vistaWiew(3);
			}
		});
		btnAsignarAUn.setBounds(347, 124, 309, 71);
		add(btnAsignarAUn);

		JButton btnReporteServiciosCon = new JButton("Reporte servicios con IPS y Ambulancia");
		btnReporteServiciosCon.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnReporteServiciosCon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal.vistaWiew(4);
			}
		});
		btnReporteServiciosCon.setBounds(347, 187, 309, 71);
		add(btnReporteServiciosCon);

		JButton btnIngresarIpsO = new JButton("Ingresar IPS o Ambulancia");
		btnIngresarIpsO.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnIngresarIpsO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal.vistaWiew(1);
			}
		});
		btnIngresarIpsO.setBounds(42, 187, 309, 71);
		add(btnIngresarIpsO);

		 btnCargar = new JButton("Cargar Datos");
		 btnCargar.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		/*btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cargarDatos(testGUIAmbulancias);
			}
		});*/
		btnCargar.setBounds(385, 469, 232, 108);
		add(btnCargar);
		
		JButton btnFinalizarServicio = new JButton("Finalizar servicio");
		btnFinalizarServicio.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnFinalizarServicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal.vistaWiew(5);
			}
		});
		btnFinalizarServicio.setBounds(42, 253, 309, 71);
		add(btnFinalizarServicio);
		
		JButton btnRegistrarServicio = new JButton("Registrar servicio");
		btnRegistrarServicio.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnRegistrarServicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal.vistaWiew(6);
			}
		});
		btnRegistrarServicio.setBounds(347, 253, 309, 71);
		add(btnRegistrarServicio);
		
		JButton btnReporteIps = new JButton("Reporte IPS");
		btnReporteIps.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnReporteIps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal.vistaWiew(7);
			}
		});
		btnReporteIps.setBounds(188, 320, 309, 71);
		add(btnReporteIps);
		
		JLabel lblMenu = new JLabel("MENU");
		lblMenu.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		lblMenu.setBounds(42, 32, 354, 56);
		add(lblMenu);

	}

	public void cargarDatos() {
		JFileChooser chooser = new JFileChooser("./");
		int returnVal = chooser.showOpenDialog(this);
		if( returnVal == JFileChooser.APPROVE_OPTION ){
			String dir = chooser.getSelectedFile().getParent();
			String nombre = chooser.getSelectedFile().getName();
			try {
				testGUIAmbulancias.setEmpresaAmbulancia(ManejadorArchivos.cargarDatos(testGUIAmbulancias.getEmpresaAmbulancia(),dir,nombre));
				JOptionPane.showMessageDialog(this,"El archivo se cargo con exito","Exito",JOptionPane.INFORMATION_MESSAGE);
			}
			catch( FileNotFoundException e)
			{
				JOptionPane.showMessageDialog(this, "Revise la ruta","Problema archivo", JOptionPane.ERROR_MESSAGE);
			}
			catch( IOException e)
			{
				//System.out.println(e.getMessage());
				//System.out.println(e.toString());
				//System.out.println(e.getLocalizedMessage());
				JOptionPane.showMessageDialog(this,"No se pudo escribir le archivo","Error escribiendo el archivo", JOptionPane.ERROR_MESSAGE);
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(this, e.getMessage(),"Problema archivo", JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	protected void salvarDatos() {
		JFileChooser chooser = new JFileChooser("./");
		int returnVal = chooser.showSaveDialog(this);
		if( returnVal == JFileChooser.APPROVE_OPTION ){
			String dir = chooser.getSelectedFile().getParent();
			String nombre = chooser.getSelectedFile().getName();
			try {
				ManejadorArchivos.salvarDatos(testGUIAmbulancias.getEmpresaAmbulancia(),dir,nombre);
				JOptionPane.showMessageDialog(this,"El archivo se guardo con exito","Exito",JOptionPane.INFORMATION_MESSAGE);

			}
			catch( FileNotFoundException e)
			{
				JOptionPane.showMessageDialog(this, "Revise la ruta","Problema archivo", JOptionPane.ERROR_MESSAGE);
			}
			catch( IOException e)
			{
				//System.out.println(e.getMessage());
				//System.out.println(e.toString());
				//System.out.println(e.getLocalizedMessage());
				JOptionPane.showMessageDialog(this,"No se pudo escribir le archivo","Error escribiendo el archivo", JOptionPane.ERROR_MESSAGE);
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(this, e.getMessage(),"Problema archivo", JOptionPane.ERROR_MESSAGE);
			}
		}

	}
	public JButton getBtnCargar() {
		return btnCargar;
	}

}
