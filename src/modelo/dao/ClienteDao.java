package modelo.dao;

import java.util.List;

import modelo.javabeans.Cliente;

public interface ClienteDao {
	String altaCliente (Cliente cliente);
	Cliente buscarUno (String cif);
	List<Cliente> buscarTodos();
	String eliminarCliente (String cif);
	//exportarFichero();
	//importarFichero();
}
