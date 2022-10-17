package presentacion.vista;

import javax.swing.JPanel;


import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

import Entidad.Persona;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class pnl_Modificar extends JPanel {

	private DefaultListModel<Persona> DlModel;
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
		
		DlModel = new DefaultListModel();
		listPersona = new JList();
		listPersona.setVisibleRowCount(10);
		listPersona.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		listPersona.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Persona PersonaSeleccionada = (Persona) listPersona.getSelectedValue();
				
				txtNombre.setText(PersonaSeleccionada.getNombre());
				txtApellido.setText(PersonaSeleccionada.getApellido());
				txtDni.setText(PersonaSeleccionada.getDni());
			}
		});
		listPersona.setBounds(20, 40, 533, 266);
		add(listPersona);
		listPersona.setModel(DlModel);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(35, 322, 86, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(126, 322, 86, 20);
		add(txtApellido);
		txtApellido.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.setBounds(217, 322, 86, 20);
		add(txtDni);
		txtDni.setColumns(10);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(318, 321, 89, 23);
		add(btnModificar);

	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtApellido() {
		return txtApellido;
	}

	public void setTxtApellido(JTextField txtApellido) {
		this.txtApellido = txtApellido;
	}

	public JTextField getTxtDni() {
		return txtDni;
	}

	public void setTxtDni(JTextField txtDni) {
		this.txtDni = txtDni;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public void setBtnModificar(JButton btnModificar) {
		this.btnModificar = btnModificar;
	}

	public JList getListPersona() {
		return listPersona;
	}

	public void setListPersona(JList listPersona) {
		this.listPersona = listPersona;
	}

	public void setDlModel(DefaultListModel<Persona> dlModel) {
		DlModel = dlModel;
	}
}
