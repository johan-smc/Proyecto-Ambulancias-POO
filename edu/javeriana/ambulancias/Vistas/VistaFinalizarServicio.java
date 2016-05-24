package co.edu.javeriana.ambulancias.Vistas;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import co.edu.javeriana.ambulancias.inteface.IServicioAmbulancias;
import co.edu.javeriana.ambulancias.presentacion.Principal;
import co.edu.javeriana.ambulancias.presentacion.TestGUIAmbulancias;

import java.util.Arrays;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class VistaFinalizarServicio extends JPanel {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tableServicios=null;
	private Vector<String> columNameServicios=null;
	private Vector<Object> dataServicios=null;
	private JScrollPane scrollPaneServicios=null;
	private JButton btnFinalizar=null;
	private String[] nombresServicios={
			"Codigo","Hora solicitud","Paciente","Tipo Servicio","Telefono","Direccion","Estado","IPS","Ambulancia"
			};
	public JButton getBtnFinalizar() {
		return btnFinalizar;
	}
	private TestGUIAmbulancias testGUIAmbulancias=null;
	/**
	 * Create the panel.
	 */
	public VistaFinalizarServicio(TestGUIAmbulancias testGUIAmbulancias) {
		setLayout(null);
		
		this.testGUIAmbulancias=testGUIAmbulancias;
		this.setBounds(0, 0, TestGUIAmbulancias.getW() - 20, TestGUIAmbulancias.getH() - 55);
		
		scrollPaneServicios = new JScrollPane();
		scrollPaneServicios.setBounds(47, 391, 620, 177);
		add(scrollPaneServicios);
		
		tableServicios = infoTablaServicios(testGUIAmbulancias.getEmpresaAmbulancia());
		scrollPaneServicios.setViewportView(tableServicios);
		
		
		
		 btnFinalizar = new JButton("Finalizar");
		 btnFinalizar.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		
		btnFinalizar.setBounds(67, 154, 262, 189);
		add(btnFinalizar);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal.vistaWiew(0);
			}
		});
		btnRegresar.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		btnRegresar.setBounds(382, 154, 262, 189);
		add(btnRegresar);
		
		JLabel lblFinalizarServicio = new JLabel("Finalizar Servicio");
		lblFinalizarServicio.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		lblFinalizarServicio.setBounds(47, 34, 347, 66);
		add(lblFinalizarServicio);

	}
	public void Finalicemos() {
		if(tableServicios.getSelectedRow()==-1)
				{
					JOptionPane.showMessageDialog(this, "No ha seleccionado la Ambulancia","No ha selecionado",JOptionPane.WARNING_MESSAGE);
				}else
				{
					
					testGUIAmbulancias.getEmpresaAmbulancia().finAServicio(((Long) tableServicios.getValueAt(tableServicios.getSelectedRow(), 0)));
					JOptionPane.showMessageDialog(this, "Exito","Exito",JOptionPane.INFORMATION_MESSAGE);
					actualizarServicios(testGUIAmbulancias.getEmpresaAmbulancia());
					//Principal.actulizarTablasServicio(empresaAmbulancia);
				}
		
		
		
	}
	private JTable infoTablaServicios(IServicioAmbulancias empresaAmbulancia) {
		if(this.columNameServicios==null)
			this.columNameServicios=new Vector<String>(Arrays.asList(this.nombresServicios));
		this.dataServicios=  empresaAmbulancia.reporteServiciosFinalizados();
		return new JTable(this.dataServicios,this.columNameServicios);
	}
	public void actualizarServicios(IServicioAmbulancias empresaAmbulancia) {
		tableServicios = infoTablaServicios(empresaAmbulancia);
		scrollPaneServicios.setViewportView(tableServicios);
}
	}
