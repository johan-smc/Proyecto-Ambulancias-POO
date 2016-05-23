package co.edu.javeriana.ambulancias.Vistas;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;


import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import co.edu.javeriana.ambulancias.inteface.IServicioAmbulancias;
import co.edu.javeriana.ambulancias.presentacion.TestGUIAmbulancias;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	

	/**
	 * Create the panel.
	 */
	public VistaReporteIPS(TestGUIAmbulancias testGUIAmbulancias) {
		setLayout(null);
		
		
		
		JLabel lblIps = new JLabel("IPS");
		lblIps.setBounds(110, 79, 46, 14);
		add(lblIps);
		
		
		
		JButton btnMostrar = new JButton("Mostrar Servicios");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				MostrarServices(testGUIAmbulancias.getEmpresaAmbulancia());
			}

			
		});
		btnMostrar.setBounds(171, 107, 144, 50);
		add(btnMostrar);
		
		JLabel lblReporteDeIps = new JLabel("REporte de IPS con servicios asociados");
		lblReporteDeIps.setBounds(22, 11, 362, 14);
		add(lblReporteDeIps);
		
		///////////////////////////////////////////
		
		
		 scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 159, 349, 117);
		add(scrollPane);
		
		////////////////////////////////////////////
		
		tabladeService = new JTable();
		scrollPane.setViewportView(tabladeService);
		
		//System.out.println("------------------------------");
		Object[] contenido3=testGUIAmbulancias.getEmpresaAmbulancia().listadeIps().toArray();
		dspIPS = new JComboBox<Object>(contenido3);
		dspIPS.setBounds(200, 76, 153, 20);
		add(dspIPS);
		
	}
	private void MostrarServices(IServicioAmbulancias empresaambulancia) {
		
		////System.out.println(dspIPS.getItemAt(((dspIPS.getSelectedIndex()))));
		tabladeService=new JTable(empresaambulancia.datosVistaIPS(((String)dspIPS.getItemAt(((dspIPS.getSelectedIndex()))))), nombresServicios);
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
