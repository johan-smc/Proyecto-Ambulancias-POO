package co.edu.javeriana.ambulancias.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import co.edu.javeriana.ambulancias.inteface.IServicioAmbulancias;
import co.edu.javeriana.ambulancias.negocio.EmpresaAmbulancias;
import co.edu.javeriana.ambulancias.persistencia.ManejadorArchivos;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;

public class TestGUIAmbulancias extends JFrame {

	/**
	 * 
	 */
	private IServicioAmbulancias empresaAmbulancia=new EmpresaAmbulancias("BabySoft");;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestGUIAmbulancias frame = new TestGUIAmbulancias();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestGUIAmbulancias() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 450, 278);
		contentPane.add(tabbedPane);
		
		JPanel MenuServicios = new JPanel();
		tabbedPane.addTab("Menu de servicios", null, MenuServicios, null);
		
		JPanel IngresarIpsAmbulancias = new JPanel();
		tabbedPane.addTab("Ingresar Ips o Ambulancias", null, IngresarIpsAmbulancias, null);
		IngresarIpsAmbulancias.setLayout(null);
		
		JButton btnIngresarAmbulancia = new JButton("Ingresar Ambulancia");
		btnIngresarAmbulancia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresarAmbulancia();
			}
		});
		btnIngresarAmbulancia.setBounds(42, 88, 160, 29);
		IngresarIpsAmbulancias.add(btnIngresarAmbulancia);
		
		JButton btnIngresarIps = new JButton("Ingresar IPS");
		btnIngresarIps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresarIPS();
			}
		});
		btnIngresarIps.setBounds(236, 88, 145, 29);
		IngresarIpsAmbulancias.add(btnIngresarIps);
	}

	protected void ingresarIPS() {
		JFileChooser chooser = new JFileChooser();
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

	protected void ingresarAmbulancia() {
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
	    
		
	}
}
