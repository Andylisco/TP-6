package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Entidad.Persona;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import java.awt.Rectangle;
import java.awt.GridLayout;

public class pnl_Eliminar extends JPanel {

	private DefaultListModel<ArrayList> DlModel;
	private JButton btnEliminar;
	private JTable table;
	private DefaultTableModel modelPersonas;
	private String[] nombreColumnas = {"DNI","NOMBRE","APELLIDO"};
	/**
	 * Create the panel.
	 */
	public pnl_Eliminar() {
		setLayout(null);
		modelPersonas = new DefaultTableModel(null,nombreColumnas);
		JLabel lblEliminar = new JLabel("Eliminar usuarios");
		lblEliminar.setBounds(53, 16, 228, 21);
		lblEliminar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblEliminar);
		
		JPanel panel = new JPanel();
		panel.setBounds(53, 62, 406, 169);
		add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 406, 169);
		panel.add(scrollPane);
		
		table = new JTable(modelPersonas);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"DNI", "NOMBRE", "APELLIDO"
			}
		));
		scrollPane.setViewportView(table);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(190, 262, 157, 23);
		add(btnEliminar);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				//DlModel.remove(ListUsuarios.getSelectedIndex());
			}
		});

	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}

	public void setDlModel(DefaultListModel<ArrayList> dlModel) {
		DlModel = dlModel;
	}
	public JTable getTable() {
		return table;
	}
	public void llenarTabla(List<Persona> personasEnTabla) {
		this.getModelPersonas().setRowCount(0); //Para vaciar la tabla
		this.getModelPersonas().setColumnCount(0);
		this.getModelPersonas().setColumnIdentifiers(this.getNombreColumnas());

		for (Persona p : personasEnTabla)
		{
			String dni = p.getDni();
			String nombre = p.getNombre();
			String apellido = p.getApellido();
			Object[] fila = {dni, nombre, apellido};
			this.getModelPersonas().addRow(fila);
		}
		
	}

	private String[] getNombreColumnas() {
		// TODO Auto-generated method stub
		return nombreColumnas;
	}

	private DefaultTableModel getModelPersonas() {
		// TODO Auto-generated method stub
		return null;
	}
}
