package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Entidad.Persona;
import presentacion.vista.VentanaPrincipal;
import presentacion.vista.pnl_Agregar;
import presentacion.vista.pnl_Eliminar;
import presentacion.vista.pnl_Listar;
import presentacion.vista.pnl_Modificar;
import negocio.PersonaNegocio;
import negocioImpl.PersonaNegocioImpl;

public class Controlador implements ActionListener {
	
	private VentanaPrincipal ventanaPrinci;
	private PersonaNegocio persoNeg;
	private ArrayList<Persona> PersonasEnTablas;
	private pnl_Agregar PanelAgregar;
	

	
	public Controlador(VentanaPrincipal vista, PersonaNegocio pNeg)
	{
		this.ventanaPrinci = vista;
				this.persoNeg = pNeg;
				//Instancio los paneles
				this.PanelAgregar = new pnl_Agregar();
				
				this.ventanaPrinci.getJMenuBar().getMenu(0).getItem(0).addActionListener(a -> VentanaMenuAgregar(a));
				this.ventanaPrinci.getJMenuBar().getMenu(0).getItem(1).addActionListener(m -> VentanaMenuModificar(m));
				this.ventanaPrinci.getJMenuBar().getMenu(0).getItem(2).addActionListener(e -> VentanaMenuEliminar(e));
				this.ventanaPrinci.getJMenuBar().getMenu(0).getItem(3).addActionListener(l -> VentanaMenuListar(l));
				//

				//Eventos PanelAgregarPersonas
				 this.PanelAgregar.getBtnAceptar().addActionListener(a -> Click_btnAceptar(a));
				//ventanaPrinci.setVisible(true);		
	}
	
	private void VentanaMenuAgregar(ActionEvent a)
	{
		System.out.println("mod1");
		this.ventanaPrinci.getContentPane().removeAll();				
		this.ventanaPrinci.getContentPane().add(PanelAgregar);
		this.ventanaPrinci.getContentPane().repaint();
		this.ventanaPrinci.getContentPane().revalidate();
	}
	
	private void Click_btnAceptar(ActionEvent a) {
		System.out.println("mod2");
		Persona P = new Persona();
		P.setNombre(PanelAgregar.getTxtNombre().getText());		
		P.setApellido(PanelAgregar.getTxtApellido().getText());
		P.setDni(PanelAgregar.getTxtDni().getText());
		
		PersonaNegocio Pnego = new PersonaNegocioImpl();		
		if (Pnego.insert(P)) 
		{
			System.out.println("mod3");
			System.out.println("Se grabo con exito el registro.");
		}
	}

	private void VentanaMenuModificar(ActionEvent m)
	{
		
		this.ventanaPrinci.getContentPane().removeAll();
			
		pnl_Modificar panel = new pnl_Modificar();
		
		panel.setDlModel(this.ventanaPrinci.getDlModel());
		this.ventanaPrinci.getContentPane().add(panel);
		this.ventanaPrinci.getContentPane().repaint();
		this.ventanaPrinci.getContentPane().revalidate();
	}
	private void VentanaMenuListar(ActionEvent l)
	{
		
		this.ventanaPrinci.getContentPane().removeAll();
			
		pnl_Listar panel = new pnl_Listar();
		
		panel.setDlModel(this.ventanaPrinci.getDlModel());
		this.ventanaPrinci.getContentPane().add(panel);
		this.ventanaPrinci.getContentPane().repaint();
		this.ventanaPrinci.getContentPane().revalidate();
	}
	private void VentanaMenuEliminar(ActionEvent e)
	{
		
		this.ventanaPrinci.getContentPane().removeAll();
			
		pnl_Eliminar panel = new pnl_Eliminar();
		
		panel.setDlModel(this.ventanaPrinci.getDlModel());
		this.ventanaPrinci.getContentPane().add(panel);
		this.ventanaPrinci.getContentPane().repaint();
		this.ventanaPrinci.getContentPane().revalidate();
	}
	public void inicializar() {
		this.ventanaPrinci.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
