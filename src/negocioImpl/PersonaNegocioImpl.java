package negocioImpl;

import java.util.List;

import Entidad.Persona;
import negocio.PersonaNegocio;

public class PersonaNegocioImpl implements PersonaNegocio {

	@Override
	public boolean insert(Persona persona) {
		System.out.println(persona.toString());
		return true;
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
