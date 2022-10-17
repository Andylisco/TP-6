package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pnl_Eliminar extends JPanel {

	private DefaultListModel<ArrayList> DlModel;
	private JButton btnEliminar;
	private JList ListUsuarios;
	
	/**
	 * Create the panel.
	 */
	public pnl_Eliminar() {
		setLayout(null);
		
		JLabel lblEliminar = new JLabel("Eliminar usuarios");
		lblEliminar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEliminar.setBounds(111, 11, 157, 21);
		add(lblEliminar);
		
		ListUsuarios = new JList();
		ListUsuarios.setBounds(111, 31, 203, 222);
		add(ListUsuarios);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				//DlModel.remove(ListUsuarios.getSelectedIndex());
			}
		});
		btnEliminar.setBounds(160, 266, 89, 23);
		add(btnEliminar);

	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}



	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}

	public int getIndexJlist() {
		return ListUsuarios.getSelectedIndex();
	}

	
	public void setDlModel(DefaultListModel<ArrayList> dlModel) {
		DlModel = dlModel;
	}
}
