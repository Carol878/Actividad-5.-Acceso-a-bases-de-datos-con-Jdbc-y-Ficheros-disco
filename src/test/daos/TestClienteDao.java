package test.daos;

import java.util.List;

import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImplMy8Jdbc;
import modelo.javabeans.Cliente;

public class TestClienteDao {
	private static ClienteDao cdao;
	static {
		cdao = new ClienteDaoImplMy8Jdbc();
	}
	public static void main(String[] args) {
		//alta();
		//uno();
		todos();
		//eliminar();
		//exportar();
		//importar();
	}
	
	public static void alta() {
		System.out.println("\nAlta nuevo cliente\n");
		Cliente cliente = new Cliente ("C86446897", "Ana", "Garcia Ruiz","Barcelona", 120000.00, 1600);
		
		System.out.println("Cliente dado de alta (me espero 1)" + cdao.altaCliente(cliente));
		
		Cliente cliente2 = new Cliente ("A11111111","Eva","González Pérez","Madrid",	850000.00, 20);
		System.out.println("El cliente ya está dado de alta (me espero 0)" + cdao.altaCliente(cliente2));
		
	}
	
	public static void uno() {
		
	}
	
	public static void todos() {
		System.out.println("\nBuscar Todos\n");
		for (Cliente ele: cdao.buscarTodos())
			System.out.println(ele);
	}
	
	public static void eliminar() {
		
	}
	
	public static void exportar() {
		
	}

	public static void importar() {
	
}
		
}
