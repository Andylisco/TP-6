package daoImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import Entidad.Persona;
import dao.PersonaDao;

public class daoPersonaImpl implements PersonaDao {

	public static final String insert ="Insert into personas(Dni,Nombre,Apellido) values(?,?,?)"; 
	public static final String delete ="Delete from personas where dni=?"; 
	public static final String buscaDNI = "Select dni from personas where dni = ";
	public static final String obtenerTodos = "Select * from personas";
	@Override
	public boolean insert(Persona persona) {
		// TODO Auto-generated method stub
		System.out.println("Inicia daoPersonaImpl.Insert Persona ");
		PreparedStatement pst ;
		boolean personaAgregada = false;
		Connection cn = Conexion.getConexion().getSQLConexion();
		try {
			//System.out.println("mod4");
			pst = cn.prepareStatement(insert);
			//System.out.println(persona.toString());
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
		System.out.println("FIN daoPersonaImpl.Insert Persona ");
		return personaAgregada;
	}

	@Override
	public boolean delete(Persona personaBorrar) {
		// TODO Auto-generated method stub
		
		System.out.println("Inicia daoPersonaImpl.Delete Persona ");
		PreparedStatement pst ;
		boolean personaEliminada = false;
		Connection cn = Conexion.getConexion().getSQLConexion();
		try {
			//System.out.println("mod4");
			pst = cn.prepareStatement(delete);
			//System.out.println(persona.toString());
			pst.setString(1, personaBorrar.getDni());
			
			if(pst.executeUpdate() > 0)
			{
				cn.commit();
				personaEliminada = true;
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
		System.out.println("FIN daoPersonaImpl.Delete Persona ");
		return personaEliminada;	
	}

	@Override
	public List<Persona> GetAll() {
		// TODO Auto-generated method stub
		System.out.println("Inicia daoPersonaImpl.GetAll");
		PreparedStatement st;
		ResultSet rst;
		ArrayList<Persona> pers = new ArrayList<Persona>();
		Conexion cn = Conexion.getConexion();
		try {
			st = cn.getSQLConexion().prepareStatement(obtenerTodos);
			rst = st.executeQuery();
			while(rst.next()) 
			{
				pers.add(obtenerDni(rst));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println("FIN daoPersonaImpl.GetAll");
		return pers;
	}
	public Persona obtenerDni(ResultSet resultSet) throws SQLException {
		System.out.println("Inicia daoPersonaImpl.obtenerDNI");
		String dni = resultSet.getString(1);
		String nombre = resultSet.getString(2);
		String apellido = resultSet.getString(3);
		System.out.println("dni: " + dni);		
		System.out.println("nombre: " + nombre);
		System.out.println("apellido: " + apellido);
		System.out.println("FIN daoPersonaImpl.obtenerDNI");
		return new Persona(dni,nombre, apellido); 
	}


	public boolean ExisteDni(String dni) {
		// TODO Auto-generated method stub
		System.out.println("INICIA daoPersonaImpl.ExisteDni");
		boolean existe = false;
		PreparedStatement ps;
		Connection cn = Conexion.getConexion().getSQLConexion();
		ResultSet rs;
		int valorBase =0;
		try {
			System.out.println("Parametro: "+dni);
			if(!dni.isEmpty()) {				
			ps = cn.prepareStatement(obtenerTodos);
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println("Ingresa while");
				valorBase = Integer.parseInt(rs.getString(1));
				if(valorBase == Integer.parseInt(dni)) {
					System.out.println("SON IGUALES");
					existe= true;
					cn.close();
					return existe;
					}
				}
			}		
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("FIN daoPersonaImpl.ExisteDni");
		return existe;
	}
}
