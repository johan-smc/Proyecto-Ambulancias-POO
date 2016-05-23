package co.edu.javeriana.ambulancias.Vistas;

import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.List;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import co.edu.javeriana.ambulancias.inteface.IServicioAmbulancias;
import co.edu.javeriana.ambulancias.negocio.EmpresaAmbulancias;

public class VistaReporteIPS extends JPanel {
	private JTable tabladeService;
	private JComboBox<Object> dspIPS;
	
	

	/**
	 * Create the panel.
	 */
	public VistaReporteIPS(IServicioAmbulancias empresaambulancia) {
		setLayout(null);
		
		
		
		JLabel lblIps = new JLabel("IPS");
		lblIps.setBounds(110, 79, 46, 14);
		add(lblIps);
		
		
		
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.setBounds(171, 134, 89, 23);
		add(btnMostrar);
		
		JLabel lblReporteDeIps = new JLabel("REporte de IPS con servicios asociados");
		lblReporteDeIps.setBounds(22, 11, 362, 14);
		add(lblReporteDeIps);
		
		///////////////////////////////////////////
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 159, 349, 117);
		add(scrollPane);
		
		////////////////////////////////////////////////////////////////
		
		tabladeService = new JTable();
		scrollPane.setRowHeaderView(tabladeService);
		
		System.out.println("------------------------------");
		Object[] contenido3=empresaambulancia.listadeIps().toArray();
		dspIPS = new JComboBox<Object>(contenido3);
		dspIPS.setBounds(200, 76, 153, 20);
		add(dspIPS);
		
	}
	public void actualizarIPS(IServicioAmbulancias empresaAmbulancias)
	{	
		String contenido3[] = new String [empresaAmbulancias.listadeIps().size()]; 
		empresaAmbulancias.listadeIps().toArray(contenido3);
		dspIPS.removeAllItems();
		for(String temp: contenido3)
		{
			dspIPS.addItem(temp);
			System.out.println(temp);
		}
	}
}
