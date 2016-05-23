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

public class VistaReporteIPS extends JPanel {
	private JTable tabladeService;

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
		
		List contenido3=(List) empresaambulancia.listadeIps();
		JScrollPane scrollPane = new JScrollPane(contenido3);
		scrollPane.setBounds(50, 159, 349, 117);
		add(scrollPane);
		
		////////////////////////////////////////////////////////////////
		
		tabladeService = new JTable();
		scrollPane.setRowHeaderView(tabladeService);
		
	}

}
