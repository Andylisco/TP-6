package main;

import java.util.ArrayList;


import javax.swing.JPanel;

import presentacion.vista.VentanaPrincipal;

import negocio.PersonaNegocio;
import negocioImpl.PersonaNegocioImpl;
import presentacion.controlador.Controlador;;

public class Principal {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		VentanaPrincipal vista = new VentanaPrincipal();
		PersonaNegocio Pnegocio = new PersonaNegocioImpl();
		
		
		
		Controlador controlador = new Controlador(vista,Pnegocio);
		
		
		
	}

}
