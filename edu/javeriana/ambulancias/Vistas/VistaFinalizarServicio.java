package co.edu.javeriana.ambulancias.Vistas;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import co.edu.javeriana.ambulancias.inteface.IServicioAmbulancias;
import co.edu.javeriana.ambulancias.presentacion.TestGUIAmbulancias;

import java.util.Arrays;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JOptionPane;



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
	/**
	 * Create the panel.
	 */
	public VistaFinalizarServicio(TestGUIAmbulancias testGUIAmbulancias) {
		setLayout(null);
		
		
		
		scrollPaneServicios = new JScrollPane();
		scrollPaneServicios.setBounds(10, 149, 360, 104);
		add(scrollPaneServicios);
		
		tableServicios = infoTablaServicios(testGUIAmbulancias.getEmpresaAmbulancia());
		scrollPaneServicios.setViewportView(tableServicios);
		
		
		
		 btnFinalizar = new JButton("Finalizar");
		
		btnFinalizar.setBounds(60, 59, 89, 23);
		add(btnFinalizar);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.setBounds(239, 59, 89, 23);
		add(btnRegresar);

	}
	public void Finalicemos(IServicioAmbulancias empresaAmbulancia) {
		if(tableServicios.getSelectedRow()==-1)
				{
					JOptionPane.showMessageDialog(this, "No ha seleccionado la Ambulancia","No ha selecionado",JOptionPane.WARNING_MESSAGE);
				}else
				{
					
					empresaAmbulancia.finAServicio(((Long) tableServicios.getValueAt(tableServicios.getSelectedRow(), 0)));
					JOptionPane.showMessageDialog(this, "Exito","Exito",JOptionPane.INFORMATION_MESSAGE);
					actualizarServicios(empresaAmbulancia);
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
