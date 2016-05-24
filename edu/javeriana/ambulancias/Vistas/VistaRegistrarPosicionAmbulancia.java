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
import java.awt.Font;

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
	private JButton btnActualizar =null;
	private TestGUIAmbulancias testGUIAmbulancias=null;
	
	/**
	 * Create the panel.
	 */
	public VistaRegistrarPosicionAmbulancia(TestGUIAmbulancias testGUIAmbulancias) {
		setLayout(null);
		this.setBounds(0, 0, TestGUIAmbulancias.getW()-20, TestGUIAmbulancias.getH()-55);
		this.testGUIAmbulancias=testGUIAmbulancias;
		 scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 79, 664, 146);
		add(scrollPane);

		table = infoTabla(testGUIAmbulancias.getEmpresaAmbulancia());
		scrollPane.setViewportView(table);

		JButton btnRegistrarPosicionAmbulancia = new JButton("Registrar posicion ambulancia");
		btnRegistrarPosicionAmbulancia.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnRegistrarPosicionAmbulancia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarPosicion();
			}
		});
		btnRegistrarPosicionAmbulancia.setBounds(193, 237, 305, 108);
		add(btnRegistrarPosicionAmbulancia);

		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblCalle.setBounds(75, 367, 109, 29);
		add(lblCalle);

		txtCalle = new JTextField();
		txtCalle.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		txtCalle.setBounds(234, 357, 264, 50);
		add(txtCalle);
		txtCalle.setColumns(10);

		JLabel lblCarrera = new JLabel("Carrera");
		lblCarrera.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblCarrera.setBounds(75, 428, 109, 33);
		add(lblCarrera);

		txtCarrera = new JTextField();
		txtCarrera.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		txtCarrera.setBounds(234, 420, 264, 50);
		add(txtCarrera);
		txtCarrera.setColumns(10);

		 btnActualizar = new JButton("Actualizar");
		 btnActualizar.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		
		btnActualizar.setBounds(50, 488, 232, 108);
		add(btnActualizar);
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal.vistaWiew(0);
			}
		});
		btnRegresar.setBounds(398, 488, 232, 108);
		add(btnRegresar);
		
		JLabel lblAmbulancias = new JLabel("Ambulancias");
		lblAmbulancias.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		lblAmbulancias.setBounds(31, 19, 334, 48);
		add(lblAmbulancias);

	}
	public void agregarPosicion() {
		try{
			int pos = this.table.getSelectedRow();
			////System.out.println(pos+" + "+table.getValueAt(pos, 0));
			int codigo=Integer.valueOf( table.getValueAt(pos, 0).toString());
			////System.out.println("-- "+codigo);
			int carrera = Integer.valueOf(this.txtCarrera.getText());
			int calle = Integer.valueOf(this.txtCalle.getText());
			testGUIAmbulancias.getEmpresaAmbulancia().registrarPosAmbulancia(codigo, calle, carrera);
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
	public void actualizarTabla(IServicioAmbulancias empresaAmbulancia) {
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
	public JButton getBtnActualizar() {
		return btnActualizar;
	}
}
