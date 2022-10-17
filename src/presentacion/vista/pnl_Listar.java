package presentacion.vista;

import javax.swing.JPanel;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class pnl_Listar extends JPanel {

	private DefaultListModel<ArrayList> DlModel;
	private JTable TablaPersonas;
	/**
	 * Create the panel.
	 */
	public pnl_Listar() {
		setLayout(null);
		
		TablaPersonas = new JTable();
		TablaPersonas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Apellido", "Dni"
			}
		));
		TablaPersonas.setBounds(386, 240, -336, -235);
		add(TablaPersonas);

	}

	public void setDlModel(DefaultListModel<ArrayList> dlModel) {
		DlModel = dlModel;
	}
}
