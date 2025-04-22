package modelo.dao;

import java.util.List;

import modelo.javabeans.Cliente;

public interface ClienteDao {
	
	int altaCliente (Cliente cliente);
	Cliente buscarUno (String cif);
	List<Cliente> buscarTodos();
	boolean eliminarCliente (String cif);
	//exportarFichero();
	//importarFichero();
}
