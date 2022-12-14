package negocioImpl;

import java.util.List;

import dao.PersonaDao;
import daoImpl.daoPersonaImpl;
import Entidad.Persona;
import negocio.PersonaNegocio;

public class PersonaNegocioImpl implements PersonaNegocio {
	PersonaDao pdao = new daoPersonaImpl();
	@Override
	public boolean insert(Persona persona) {
		System.out.println("Inicia PersonaNegocioImpl.Insert Persona");
		boolean estado =false;
		estado = pdao.insert(persona);
		if(estado == true) {
			//System.out.println("Negocio");
			estado= true;
		}
		System.out.println("Fin PersonaNegocioImpl.Insert Persona");
		return estado;
	}

	@Override
	public boolean delete(Persona personaBorrar) {
		System.out.println("Inicia PersonaNegocioImpl.Delete Persona");
		boolean estado = pdao.delete(personaBorrar);
		/*if(estado == true) {
			//System.out.println("Negocio");
			estado= true;
		}*/
		System.out.println("Fin PersonaNegocioImpl.Delete Persona");
		return estado;
	}

	@Override
	public List<Persona> GetAll() {
		// TODO Auto-generated method stub
		return pdao.GetAll();
	}
	public Persona obtenerPersona(String dni) {
		Persona x = new Persona();
		return x;
	}

	@Override
	public boolean obtenerDni(String dni) {
		// TODO Auto-generated method stub
		System.out.println("Inicia PersonaNegocioImpl.obtenerDni");
		boolean existe = pdao.ExisteDni(dni);
		System.out.println("Fin PersonaNegocioImpl.ObtenerDni");
		return existe;
	}

	@Override
	public boolean Update(Persona persona) {
		System.out.println("Inicia PersonaNegocioImpl.Update Persona");
		boolean estado =false;
		estado = pdao.Update(persona);		
		System.out.println("Fin PersonaNegocioImpl.Update Persona");
		return estado;
	}

}
