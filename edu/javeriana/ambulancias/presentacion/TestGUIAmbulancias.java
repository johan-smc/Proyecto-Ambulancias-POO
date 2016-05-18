package co.edu.javeriana.ambulancias.presentacion;


import java.awt.EventQueue;

import javax.swing.JFrame;

import co.edu.javeriana.ambulancias.inteface.IServicioAmbulancias;
import co.edu.javeriana.ambulancias.negocio.EmpresaAmbulancias;


public class TestGUIAmbulancias extends JFrame {

	/**
	 * 
	 */
	private IServicioAmbulancias empresaAmbulancia=new EmpresaAmbulancias("BabySoft");;
	private static final long serialVersionUID = 1L;
	private Principal principal;

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
		principal = new Principal(empresaAmbulancia);
		principal.setVisible(true);
		this.setContentPane(principal);
		
		
	}

	
	
}
