package dao;

import java.util.List;

import Entidad.Persona;

public interface PersonaDao {
	public boolean insert(Persona persona);
	public boolean delete(Persona personaBorrar);
	public List<Persona> GetAll();
}
