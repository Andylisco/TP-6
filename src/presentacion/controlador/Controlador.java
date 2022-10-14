package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import Entidad.Persona;
import presentacion.vista.VentanaPrincipal;
import presentacion.vista.pnl_Agregar;
import presentacion.vista.pnl_Eliminar;
import presentacion.vista.pnl_Listar;
import presentacion.vista.pnl_Modificar;
import negocio.PersonaNegocio;
import negocioImpl.PersonaNegocioImpl;
import javax.swing.JLabel;

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
				PanelAgregar.getTxtApellido().addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						int key = e.getKeyChar();
						boolean mayus = key >= 65 && key <=90;
						boolean min = key >=97 && key <= 122;
						boolean espacio = key == 32;
						if(!(mayus|| min || espacio)) {
							e.consume();
							}
						}
				});
				PanelAgregar.getTxtNombre().addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						int key = e.getKeyChar();
						boolean mayus = key >= 65 && key <=90;
						boolean min = key >=97 && key <= 122;
						boolean espacio = key == 32;
						if(!(mayus|| min || espacio)) {
							e.consume();
						}
					}
				});
				
				JLabel lblDni = new JLabel("");
				lblDni.setBounds(341, 86, 69, 20);
				PanelAgregar.add(lblDni);
				
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
		String mensaje;
		String mensajeNombre;
		PersonaNegocio Pnego= new PersonaNegocioImpl() ;
		if(PanelAgregar.getTxtNombre().getText().isEmpty()
				&& PanelAgregar.getTxtApellido().getText().isEmpty()
				&& PanelAgregar.getTxtDni().getText().isEmpty()) 
		{
			mensaje = "complete todos los campos faltan " ;
			this.ventanaPrinci.mostrarMensaje(mensaje);
		}
			if(PanelAgregar.getTxtNombre().getText().isEmpty()) 
			{
				mensaje = "complete todos los campos faltan campo Nombre"  ;
				this.ventanaPrinci.mostrarMensaje(mensaje);
			}
				if(PanelAgregar.getTxtApellido().getText().isEmpty())
				{
					mensaje = "complete todos los campos falta Apellido" ;
					this.ventanaPrinci.mostrarMensaje(mensaje);
				}
					if(PanelAgregar.getTxtDni().getText().isEmpty()) 
					{
						mensaje = "complete todos los campos falta Dni" ;
						this.ventanaPrinci.mostrarMensaje(mensaje);
					}
		if (!PanelAgregar.getTxtNombre().getText().isEmpty()
				&&!PanelAgregar.getTxtApellido().getText().isEmpty()
				&&!PanelAgregar.getTxtDni().getText().isEmpty() ) 
		{

			String nombre = PanelAgregar.getTxtNombre().getText();		
			String apellido = PanelAgregar.getTxtApellido().getText();
			if (!PanelAgregar.getTxtDni().getText().matches("^[0-9]*$")) {
				mensaje = "INGRESO INCORRECTO";
				//System.out.println("Se grabo con exito el registro.");
				this.ventanaPrinci.mostrarMensaje(mensaje);
			}	
			else {
				String dni = PanelAgregar.getTxtDni().getText();				
				Persona P = new Persona(dni,nombre,apellido);	
				if (Pnego.insert(P)) 
					{
						mensaje = "Se agrego correctamente";
//						System.out.println("Se grabo con exito el registro.");
						this.ventanaPrinci.mostrarMensaje(mensaje);
					}
				else {
					mensaje = "complete todos los campos faltan";
//					System.out.println("complete todos los campos faltan.");
					this.ventanaPrinci.mostrarMensaje(mensaje);
				}
			}
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
	public String ValidacionesAgregarNombre(String nombre) {
		String Mensaje= "";
		if(nombre.isEmpty()) {
			Mensaje = "INGRESE NOMBRE";
		}else {
			Mensaje = nombre;
		}
		return Mensaje;
		
	}
}
