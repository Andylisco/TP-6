package presentacion.vista;

import javax.swing.JPanel;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;

public class pnl_Listar extends JPanel {

	private DefaultListModel<ArrayList> DlModel;
	/**
	 * Create the panel.
	 */
	public pnl_Listar() {
		
		JLabel lblListar = new JLabel("Listar");
		add(lblListar);

	}

	public void setDlModel(DefaultListModel<ArrayList> dlModel) {
		DlModel = dlModel;
	}
}
