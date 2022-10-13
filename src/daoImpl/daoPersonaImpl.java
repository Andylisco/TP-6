package daoImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import Entidad.Persona;
import dao.PersonaDao;

public class daoPersonaImpl implements PersonaDao {

	public static final String insert ="Insert into usuario(dni,nombre,apellido) values(?,?,?)"; 
	@Override
	public boolean insert(Persona persona) {
		// TODO Auto-generated method stub
		PreparedStatement pst ;
		boolean personaAgregada = false;
		Connection cn = Conexion.getConexion().getSQLConexion();
		try {
			System.out.println("mod4");
			pst = cn.prepareStatement(insert);
			System.out.println(persona.toString());
			pst.setString(1, persona.getDni());
			pst.setString(2, persona.getNombre());
			pst.setString(3, persona.getApellido());
			if(pst.executeUpdate() > 0)
			{
				cn.commit();
				personaAgregada = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				cn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return personaAgregada;
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
