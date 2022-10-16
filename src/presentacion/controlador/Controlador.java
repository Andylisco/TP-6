package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
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
		String mensaje;
		System.out.println("Inicia Controlador.Click_btnAceptar");
		try {
			// se obtiene el mensaje para mostrar en pantalla se llama a la funcion validacionesBtnAceptar
			mensaje = this.validacionesBtnAceptar(PanelAgregar.getTxtDni().getText(),
					PanelAgregar.getTxtNombre().getText(), 
					PanelAgregar.getTxtApellido().getText());
			//muesta mensaje en pantalla 
			this.ventanaPrinci.mostrarMensaje(mensaje);
			// limpia txt
			PanelAgregar.getTxtDni().setText("");
			PanelAgregar.getTxtNombre().setText(""); 
			PanelAgregar.getTxtApellido().setText("");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("FIN Controlador.Click_btnAceptar");
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
	
	public String validacionesBtnAceptar(String txtDni, String txtNombre, String txtApellido) {
		String mensaje = "";
		System.out.println("Inicia Controlador.validacionesBtnAceptar");
		PersonaNegocio Pnego= new PersonaNegocioImpl() ;
		boolean blPersona = false;
		boolean validaDni = false;
		try {
				if(txtNombre.isEmpty()&& txtApellido.isEmpty()&& txtDni.isEmpty()) 
				{
					return mensaje = "complete todos los campos faltan " ;
				}
					if(txtNombre.isEmpty()) 
					{
						return mensaje = "complete todos los campos faltan campo Nombre"  ;
					}
						if(txtApellido.isEmpty())
						{
							return mensaje = "complete todos los campos falta Apellido" ;
						}
							if(txtDni.isEmpty()) 
							{
								return mensaje = "complete todos los campos falta Dni" ;
							}
								if (!txtNombre.isEmpty()
										&&!txtApellido.isEmpty()
										&&!PanelAgregar.getTxtDni().getText().isEmpty() ) 
								{								
									String nombre = txtNombre;		
									String apellido = txtApellido;
									if (!txtDni.matches("^[0-9]*$")) 
									{
										return mensaje = "INGRESE SOLO NUMEROS";								
									}	
									else 
									{			
										validaDni = Pnego.obtenerDni(txtDni);
										if (validaDni) 
										{
											System.out.println("Existe Dni");
											return mensaje = "Existe Dni";
										}
										else 
										{
											blPersona = true;
											System.out.println("No Existe Dni");
										}
										if (blPersona) 
										{
										String dni = txtDni;				
										Persona P = new Persona(dni,nombre,apellido);	
											if (Pnego.insert(P)) 
											{	
												return mensaje = "Se agrego correctamente";
											}
											else 
											{
												return mensaje = "complete todos los campos faltan";
											}
										}
									}
								}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("FIN Controlador.validacionesBtnAceptar");

		return mensaje;
	}
}
