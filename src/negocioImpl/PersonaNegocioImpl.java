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
		boolean estado =false;
		estado = pdao.insert(persona);
		if(estado == true) {
			//System.out.println("Negocio");
			estado= true;
		}
		return estado;
	}

	@Override
	public boolean delete(Persona personaBorrar) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Persona> GetAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
