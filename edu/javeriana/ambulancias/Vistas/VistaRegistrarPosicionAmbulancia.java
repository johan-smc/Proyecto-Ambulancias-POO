package co.edu.javeriana.ambulancias.Vistas;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


import java.util.Arrays;

import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import co.edu.javeriana.ambulancias.inteface.IServicioAmbulancias;
import co.edu.javeriana.ambulancias.presentacion.Principal;
import co.edu.javeriana.ambulancias.presentacion.TestGUIAmbulancias;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private JScrollPane scrollPane=null;
	private String[] nombres={
			"Codigo","Tipo","Placa","Medico o Enfermero","Tipo UCI","Hora posicion","Calle","Carrera"
			};
	/**
	 * Create the panel.
	 */
	public VistaRegistrarPosicionAmbulancia(IServicioAmbulancias empresaAmbulancia) {
		setLayout(null);
		this.setBounds(0, 0, TestGUIAmbulancias.getW()-20, TestGUIAmbulancias.getH()-55);

		 scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 438, 105);
		add(scrollPane);

		table = infoTabla(empresaAmbulancia);
		scrollPane.setViewportView(table);

		JButton btnRegistrarPosicionAmbulancia = new JButton("Registrar posicion ambulancia");
		btnRegistrarPosicionAmbulancia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarPosicion(empresaAmbulancia);
			}
		});
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
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizar(empresaAmbulancia);
			}
		});
		btnActualizar.setBounds(16, 249, 117, 29);
		add(btnActualizar);
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal.vistaWiew(0);
			}
		});
		btnRegresar.setBounds(357, 407, 117, 29);
		add(btnRegresar);

	}
	protected void agregarPosicion(IServicioAmbulancias empresaAmbulancia) {
		try{
			int pos = this.table.getSelectedRow();
			//System.out.println(pos+" + "+table.getValueAt(pos, 0));
			int codigo=Integer.valueOf( table.getValueAt(pos, 0).toString());
			//System.out.println("-- "+codigo);
			int carrera = Integer.valueOf(this.txtCarrera.getText());
			int calle = Integer.valueOf(this.txtCalle.getText());
			empresaAmbulancia.registrarPosAmbulancia(codigo, calle, carrera);
			JOptionPane.showMessageDialog(this,"La posicion se guardo correctamente", "Exitoso",JOptionPane.INFORMATION_MESSAGE);
		}
		catch( NumberFormatException e)
		{
			JOptionPane.showMessageDialog(this, "La entrada no tiene el formato correcto","Error entrada",JOptionPane.ERROR_MESSAGE);
		}
		catch( Exception e)
		{
			JOptionPane.showMessageDialog(this, "No hay ambulancias","Error",JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
	public void actualizar(IServicioAmbulancias empresaAmbulancia) {
		table = infoTabla(empresaAmbulancia);
		scrollPane.setViewportView(table);
	}
	private JTable infoTabla(IServicioAmbulancias empresaAmbulancia) {
		if(this.columName==null)
			this.columName=new Vector<String>(Arrays.asList(this.nombres));
		this.data=  empresaAmbulancia.reporteAmbulancia();
		//imprimir(data);
		return new JTable(this.data,this.columName);
	}
	
	/*private void imprimir(Vector<Object> data2) {
		for( Object o:data2)
			System.out.println(o.toString());
		
	}*/
}
