package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	public static Conexion instancia;
	private Connection cn;
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "bdPersonas";
	private String url = host+dbName;
	
	private Conexion() {			
		try {
			this.cn = DriverManager.getConnection(url,user,pass);
			this.cn.setAutoCommit(false);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Conexion getConexion()   
	{								
		if(instancia == null)
		{
			instancia = new Conexion();
		}
		return instancia;
	}

	public Connection getSQLConexion() 
	{
		return this.cn;
	}
	
	public void cerrarConexion()
	{
		try 
		{
			this.cn.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		instancia = null;
	}
}
