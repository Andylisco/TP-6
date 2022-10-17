package presentacion.vista;

import javax.swing.JPanel;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;

public class pnl_Modificar extends JPanel {

	private DefaultListModel<ArrayList> DlModel;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JButton btnModificar;
	private JList listPersona;
	
	/**
	 * Create the panel.
	 */
	public pnl_Modificar() {
		setLayout(null);
		
		JLabel lblModificar = new JLabel("Seleccione la persona que desea modificar");
		lblModificar.setBounds(20, 25, 299, 19);
		add(lblModificar);
		
		listPersona = new JList();
		listPersona.setBounds(20, 40, 420, 171);
		add(listPersona);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(20, 222, 86, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(116, 222, 86, 20);
		add(txtApellido);
		txtApellido.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.setBounds(212, 222, 86, 20);
		add(txtDni);
		txtDni.setColumns(10);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(321, 222, 89, 23);
		add(btnModificar);

	}

	public void setDlModel(DefaultListModel<ArrayList> dlModel) {
		DlModel = dlModel;
	}
}
