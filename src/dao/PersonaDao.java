package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entidad.Persona;

public interface PersonaDao {
	public boolean insert(Persona persona);
	public boolean delete(Persona personaBorrar);
	public ArrayList<Persona> GetAll();
	public Persona obtenerDni(ResultSet resultSet)throws SQLException;
	public boolean ExisteDni(String dni);
}
