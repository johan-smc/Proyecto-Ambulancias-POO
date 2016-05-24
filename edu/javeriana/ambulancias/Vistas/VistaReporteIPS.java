package co.edu.javeriana.ambulancias.Vistas;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;


import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import co.edu.javeriana.ambulancias.inteface.IServicioAmbulancias;
import co.edu.javeriana.ambulancias.presentacion.Principal;
import co.edu.javeriana.ambulancias.presentacion.TestGUIAmbulancias;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class VistaReporteIPS extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tabladeService;
	private JComboBox<Object> dspIPS;
	private String[] nombresServicios={
			"Codigo","Hora solicitud","Paciente","Tipo Servicio","Telefono","Direccion","Estado","IPS","Ambulancia"
			};
	private JScrollPane scrollPane=null;
	TestGUIAmbulancias testGUIAmbulancias=null;

	/**
	 * Create the panel.
	 */
	public VistaReporteIPS(TestGUIAmbulancias testGUIAmbulancias) {
		setLayout(null);
		
		this.testGUIAmbulancias=testGUIAmbulancias;
		this.setBounds(0, 0, TestGUIAmbulancias.getW()-20, TestGUIAmbulancias.getH()-55);
		
		JLabel lblIps = new JLabel("IPS");
		lblIps.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		lblIps.setBounds(176, 86, 112, 68);
		add(lblIps);
		
		
		
		JButton btnMostrar = new JButton("Mostrar Servicios");
		btnMostrar.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				MostrarServices();
			}

			
		});
		btnMostrar.setBounds(70, 221, 232, 108);
		add(btnMostrar);
		
		JLabel lblReporteDeIps = new JLabel("Reporte de IPS con servicios asociados");
		lblReporteDeIps.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		lblReporteDeIps.setBounds(22, 11, 654, 68);
		add(lblReporteDeIps);
		
		///////////////////////////////////////////
		
		
		 scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 414, 626, 181);
		add(scrollPane);
		
		////////////////////////////////////////////
		
		tabladeService = new JTable();
		scrollPane.setViewportView(tabladeService);
		
		//System.out.println("------------------------------");
		Object[] contenido3=testGUIAmbulancias.getEmpresaAmbulancia().listadeIps().toArray();
		dspIPS = new JComboBox<Object>(contenido3);
		dspIPS.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		dspIPS.setBounds(396, 95, 262, 68);
		add(dspIPS);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal.vistaWiew(0);
			}
		});
		btnRegresar.setBounds(426, 221, 232, 108);
		add(btnRegresar);
		
	}
	private void MostrarServices() {
		
		////System.out.println(dspIPS.getItemAt(((dspIPS.getSelectedIndex()))));
		tabladeService=new JTable(testGUIAmbulancias.getEmpresaAmbulancia().datosVistaIPS(((String)dspIPS.getItemAt(((dspIPS.getSelectedIndex()))))), nombresServicios);
		scrollPane.setViewportView(tabladeService);
	}
	
	public void actualizarIPS(IServicioAmbulancias empresaAmbulancias)
	{	
		String contenido3[] = new String [empresaAmbulancias.listadeIps().size()]; 
		empresaAmbulancias.listadeIps().toArray(contenido3);
		dspIPS.removeAllItems();
		for(String temp: contenido3)
		{
			dspIPS.addItem(temp);
			//System.out.println(temp);
		}
	}
}
