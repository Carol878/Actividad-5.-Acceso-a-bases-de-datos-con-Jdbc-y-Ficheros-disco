package modelo.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.javabeans.Cliente;

public class ClienteDaoImplMy8Jdbc extends AbsGenericoDaoImpl implements ClienteDao {
	
	public ClienteDaoImplMy8Jdbc() {
		super();
	}

	@Override
	public int altaCliente(Cliente cliente) {
		sql = "insert into clientes (cif, nombre, apellidos, domicilio, facturacion_anual, numero_empleados) values (?,?,?,?,?,?)";
		filas = 0;
		 try {
		ps = conn.prepareStatement(sql);
		ps.setString(1, cliente.getCif());
		ps.setString(2, cliente.getNombre());
		ps.setString(3, cliente.getApellidos());
		ps.setString(4, cliente.getDomicilio());
		ps.setDouble(5, cliente.getFacturacionAnual());
		ps.setInt(6, cliente.getNumeroEmpleados());
		
		filas = ps.executeUpdate();
		
		 } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				filas = 0;
			}
		
		return filas;
	}

	@Override
	public Cliente buscarUno(String cif) {
		sql = "select * from clientes where cif = ?";
		Cliente cliente = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cif);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				cliente = new Cliente();
				cliente.setCif(rs.getString("cif"));
				cliente.setNombre(rs.getString("nombre"));
				cliente.setApellidos(rs.getString("apellidos"));
				cliente.setDomicilio(rs.getString("domicilio"));
				cliente.setFacturacionAnual(rs.getDouble("facturacion_anual"));
				cliente.setNumeroEmpleados(rs.getInt("numero_empleados"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cliente;
	}

	@Override
	public List<Cliente> buscarTodos() {
		sql = "select * from clientes";
		List<Cliente> aux = new ArrayList<Cliente>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Cliente cliente = new Cliente();
				
				cliente.setCif(rs.getString("cif"));
				cliente.setNombre(rs.getString("nombre"));
				cliente.setApellidos(rs.getString("apellidos"));
				cliente.setDomicilio(rs.getString("domicilio"));
				cliente.setFacturacionAnual(rs.getDouble("facturacion_anual"));
				cliente.setNumeroEmpleados(rs.getInt("numero_empleados"));
				
				aux.add(cliente);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aux;
	}

	@Override
	public boolean eliminarCliente(String cif) {	
		boolean resultado = false;
		sql = "DELETE FROM clientes WHERE cif = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cif);
			resultado = ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}
	
	@Override
	public String exportar(String nombreFichero) {
		String mensaje;
		// Fuente el fichero en disco
		File fichero = new File("C:\\Users\\Carol\\OneDrive\\Escritorio\\UNIR\\PROGRAMACIÓN 1\\DAW JAVA 24-25\\WS_DAW\\NahirCarolinaTorres_Activ5\\bbdd.txt"); //¿Dónde se encuentra y qué extensión tiene? 
		// El flujo
		String linea = null; //creamos fuera la variable pq dentro del try da problemas
		try {
			FileWriter fileWriter  = new FileWriter(fichero);
			BufferedWriter bf = new BufferedWriter(fileWriter);
			List<Cliente> clientes = buscarTodos();
			for (int i = 0; i < clientes.size(); i++) {
				// Grabo por lineas datos del cliente, transformo los datos de la lista en String con toString
				bf.write(clientes.get(i).toString());
			}
			mensaje = "Clientes bien exportados";
		} catch (IOException e) {
			mensaje = "Fichero no existe";
			e.printStackTrace();
		}
		return mensaje;
	}
	
	@Override
	public List<Cliente> importar(String nombreFichero){
		try {
			File fichero = new File("C:\\Users\\Carol\\OneDrive\\Escritorio\\UNIR\\PROGRAMACIÓN 1\\DAW JAVA 24-25\\WS_DAW\\NahirCarolinaTorres_Activ5\\bbdd.txt"); //¿Dónde se encuentra y qué extensión tiene? 
			Scanner leer = new Scanner(fichero);
			// Busca si hay registro y en caso afirmativo lo trae a memoria
			while(leer.hasNext()) {
				System.out.println(leer.nextLine()); 
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("fin de programa");
		return null;
	}

}
