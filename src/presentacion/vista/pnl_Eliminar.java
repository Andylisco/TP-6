package presentacion.vista;

import javax.swing.JPanel;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;

public class pnl_Eliminar extends JPanel {

	private DefaultListModel<ArrayList> DlModel;
	/**
	 * Create the panel.
	 */
	public pnl_Eliminar() {
		
		JLabel lblEliminar = new JLabel("ELIMINAR");
		add(lblEliminar);

	}

	public void setDlModel(DefaultListModel<ArrayList> dlModel) {
		DlModel = dlModel;
	}
}
