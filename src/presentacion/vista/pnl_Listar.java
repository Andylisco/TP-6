package presentacion.vista;

import javax.swing.JPanel;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.FlowLayout;

public class pnl_Listar extends JPanel {

	private DefaultListModel<ArrayList> DlModel;
	private JTable TablaPersonas;
	/**
	 * Create the panel.
	 */
	public pnl_Listar() {
		setLayout(null);
		
		
		TablaPersonas = new JTable();
		TablaPersonas.setBounds(79, 253, 318, -217);
		TablaPersonas.setBackground(Color.GRAY);
		TablaPersonas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Apellido", "Dni"
			}
		));
		add(TablaPersonas);

	}

	public JTable getTablaPersonas() {
		return TablaPersonas;
	}

	public void setTablaPersonas(JTable tablaPersonas) {
		TablaPersonas = tablaPersonas;
	}

	public void setDlModel(DefaultListModel<ArrayList> dlModel) {
		DlModel = dlModel;
	}
}
