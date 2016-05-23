package co.edu.javeriana.ambulancias.presentacion;


import java.awt.EventQueue;

import javax.swing.JFrame;

import co.edu.javeriana.ambulancias.inteface.IServicioAmbulancias;
import co.edu.javeriana.ambulancias.negocio.EmpresaAmbulancias;



public class TestGUIAmbulancias extends JFrame {

	/**
	 * 
	 */
	private static  int width=739;
	private static  int height=667;
	private static final long serialVersionUID = 1L;
	private Principal principal;
	private  IServicioAmbulancias empresaAmbulancia=new EmpresaAmbulancias("BabySoft");

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
		setTitle(this.empresaAmbulancia.getNombre());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,TestGUIAmbulancias.width,TestGUIAmbulancias.height);
		principal = new Principal(this);
		principal.setVisible(true);
		this.setContentPane(principal);
		
		
	}
	
	
	public  IServicioAmbulancias getEmpresaAmbulancia() {
		return empresaAmbulancia;
	}
	
	public  void setEmpresaAmbulancia(IServicioAmbulancias empresaAmbulancia) {
		this.empresaAmbulancia = empresaAmbulancia;
	}
	
	public static int getW()
	{
		return width;
		
	}
	public static int getH()
	{
		return height;
	}
	
	

	
	
}
