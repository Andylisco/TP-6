package presentacion.vista;

import javax.swing.JPanel;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;

public class pnl_Modificar extends JPanel {

	private DefaultListModel<ArrayList> DlModel;
	/**
	 * Create the panel.
	 */
	public pnl_Modificar() {
		
		JLabel lblModificar = new JLabel("MODIFICAR");
		add(lblModificar);

	}

	public void setDlModel(DefaultListModel<ArrayList> dlModel) {
		DlModel = dlModel;
	}
}
