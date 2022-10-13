package presentacion.vista;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pnl_Agregar extends JPanel {

	private DefaultListModel<ArrayList> DlModel;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JButton btnAceptar;
	/**
	 * Create the panel.
	 */
	public pnl_Agregar() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(91, 33, 46, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Apellido");
		lblNewLabel_1.setBounds(91, 61, 46, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Dni");
		lblNewLabel_2.setBounds(91, 89, 46, 14);
		add(lblNewLabel_2);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(176, 30, 153, 20);
		add(txtNombre);
		txtNombre.setColumns(45);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(176, 58, 153, 20);
		add(txtApellido);
		txtApellido.setColumns(45);
		
		txtDni = new JTextField();
		txtDni.setBounds(176, 86, 153, 20);
		add(txtDni);
		txtDni.setColumns(20);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAceptar.setBounds(73, 141, 124, 23);
		add(btnAceptar);

	}
	
	

	public JButton getBtnAceptar() {
		return btnAceptar;
	}



	public JTextField getTxtNombre() {
		return txtNombre;
	}




	public JTextField getTxtApellido() {
		return txtApellido;
	}


	public JTextField getTxtDni() {
		return txtDni;
	}




	public void setDlModel(DefaultListModel<ArrayList> dlModel) {
		DlModel = dlModel;
	}
	
}
