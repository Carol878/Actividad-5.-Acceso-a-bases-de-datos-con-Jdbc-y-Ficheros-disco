package modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMy8 {
	
	private static Connection conn;
	private String url = "jdbc:mysql://localhost:3306/proyectos_fp_2025";
	private String user = "root";
	private String password = "";
	
	//En el constructor genero la conexion para que sea unica y la pongo privada.
	private ConexionMy8() {
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("CONEXION ESTABLECIDA");
		} catch (SQLException e) {
			e.printStackTrace();
			
			System.out.println("CONEXION NO ESTABLECIDA");
		}
	}
	
	public static Connection getConexion() {
		
		if (conn == null)
			new ConexionMy8();
		
		return conn;	
	}
}
