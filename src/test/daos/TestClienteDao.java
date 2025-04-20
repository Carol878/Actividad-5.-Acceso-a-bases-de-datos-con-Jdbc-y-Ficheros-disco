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
