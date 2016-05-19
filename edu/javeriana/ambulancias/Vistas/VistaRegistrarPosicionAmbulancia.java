package co.edu.javeriana.ambulancias.Vistas;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


import java.util.Arrays;

import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import co.edu.javeriana.ambulancias.inteface.IServicioAmbulancias;
import co.edu.javeriana.ambulancias.presentacion.TestGUIAmbulancias;

public class VistaRegistrarPosicionAmbulancia extends JPanel {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField txtCalle;
	private JTextField txtCarrera;
	private Vector<String> columName=null;
	private Vector<Object> data=null;
	private String[] nombres={
			"Codigo","Tipo","Placa","Medico o Enfermero","Tipo UCI","Hora posicion","Calle","Carrera"
			};
	/**
	 * Create the panel.
	 */
	public VistaRegistrarPosicionAmbulancia(IServicioAmbulancias empresaAmbulancia) {
		setLayout(null);
		this.setBounds(0, 0, TestGUIAmbulancias.getW(), TestGUIAmbulancias.getH());


		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 438, 105);
		add(scrollPane);

		table = infoTabla(empresaAmbulancia);
		scrollPane.setViewportView(table);

		JButton btnRegistrarPosicionAmbulancia = new JButton("Registrar posicion ambulancia");
		btnRegistrarPosicionAmbulancia.setBounds(16, 123, 234, 29);
		add(btnRegistrarPosicionAmbulancia);

		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setBounds(26, 164, 61, 16);
		add(lblCalle);

		txtCalle = new JTextField();
		txtCalle.setBounds(121, 159, 82, 26);
		add(txtCalle);
		txtCalle.setColumns(10);

		JLabel lblCarrera = new JLabel("Carrera");
		lblCarrera.setBounds(26, 209, 61, 16);
		add(lblCarrera);

		txtCarrera = new JTextField();
		txtCarrera.setBounds(121, 204, 82, 26);
		add(txtCarrera);
		txtCarrera.setColumns(10);

		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(16, 249, 117, 29);
		add(btnActualizar);

	}
	private JTable infoTabla(IServicioAmbulancias empresaAmbulancia) {
		if(this.columName==null)
			this.columName=new Vector<String>(Arrays.asList(this.nombres));
		this.data=(Vector<Object>) empresaAmbulancia.reporteAmbulancia();
		return new JTable(this.data,this.columName);
	}
}
