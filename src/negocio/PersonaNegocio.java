package negocio;

import java.util.List;

import Entidad.Persona;

public interface PersonaNegocio {
	public boolean insert(Persona persona);
	public boolean delete(Persona personaBorrar);
	public List<Persona> GetAll();
	public boolean obtenerDni(String dni);
}
