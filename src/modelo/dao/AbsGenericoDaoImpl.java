package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AbsGenericoDaoImpl {

	protected Connection conn; //Para establecer la conexion
	protected PreparedStatement ps; //El actor principal para preparar y ejecutar
	protected ResultSet rs; //Para leer el fichero que genera la BBDD
	protected String sql; //La sentencia sql
	protected int filas; //Para actualizar
	
	//En el constructor genero la conexion
	public AbsGenericoDaoImpl() {
		conn = ConexionMy8.getConexion();
	}
}