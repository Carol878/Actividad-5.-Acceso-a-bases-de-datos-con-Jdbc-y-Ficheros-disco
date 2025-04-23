package principales;
import java.util.List;
import java.util.Scanner;

import modelo.dao.ClienteDaoImplMy8Jdbc;
import modelo.javabeans.Cliente;

public class GestionClientes {
	
	public static void main(String[] args){
		String menu = "";
		Scanner scLeerTeclado = new Scanner(System.in);
		ClienteDaoImplMy8Jdbc aux = new ClienteDaoImplMy8Jdbc();

		
		do {
			System.out.println("Dime que opción quieres realizar: \n1 Alta del Cliente \n2 Buscar un Cliente \n3 Mostrar Todos \n4 Eliminar un cliente, "
					+"\n5 Exportar a fichero \n6 Importar desde fichero \n7 Salir");
			menu = scLeerTeclado.next();
			switch (menu){
			case "1": 
				altaCliente(scLeerTeclado, aux);
				break;
			case "2": 
				buscaCliente(scLeerTeclado, aux);
				break;
			case "3": 
				mostrarClientes(aux);
				break;
			case "4": 
				eliminarCliente(scLeerTeclado, aux);
				break;
			case "5": 
				exportarFichero(aux);
				break;
			case "6": 
				importarFichero(aux);
				break;
			case "7": 
				System.out.println("Salir");
				break;
			default: 
				System.out.println("Esa opción no está disponible, selecciona una correcta");
				break;
				}
		}
		while (menu != "7");
	}
	
	public static void altaCliente(Scanner scanner, ClienteDaoImplMy8Jdbc aux) {
		System.out.println("Dime el CIF del nuevo cliente: ");
		String guardarCif = scanner.next();
		System.out.println("Dime el nombre del nuevo cliente: ");
		String guardarNombre = scanner.next();
		System.out.println("Dime el apellido del nuevo cliente: ");
		String guardarApellido = scanner.next();
		System.out.println("Dime el domicilio del nuevo cliente: ");
		String guardarDomicilio = scanner.next();
		System.out.println("Dime la facturación anual del nuevo cliente: ");
		float guardarFactAnual = scanner.nextFloat();
		System.out.println("Dime el número de empleados del nuevo cliente: ");
		int guardarNumeroEmpleados = scanner.nextInt();
		
		// Llamo al constructor y añado datos de cliente
		Cliente cliente = new Cliente(guardarCif, guardarNombre, guardarApellido, guardarDomicilio, guardarFactAnual, guardarNumeroEmpleados);
		aux.altaCliente(cliente);
		System.out.println("Cliente añadido con ÉXITO");
		
	}
	
	public static void buscaCliente(Scanner scanner, ClienteDaoImplMy8Jdbc aux) {
		System.out.println("Dime el CIF del cliente a buscar: ");
		String buscarCif = scanner.next();	
		Cliente cliente = aux.buscarUno(buscarCif);
		// Si el cliente coincide con un cliente de BBDD sale por pantalla
		if (cliente != null) {
			System.out.println("Este es el cliente solicitado: ");
			System.out.println(cliente.toString());
		}
		// Sino coincide no encontrado
		else {
			System.out.println("Cliente no encontrado ");
		}
	}
	
	public static void mostrarClientes(ClienteDaoImplMy8Jdbc aux) {
		// Guardo la lista de clientes de base ClienteDaoImp en clientes 
		List<Cliente> clientes = aux.buscarTodos();
		// Saco por pantalla clientes de BBDD
		for (int i = 0; i < clientes.size(); i++) {
			System.out.println(clientes.get(i));
		}
	}
	
	public static void eliminarCliente(Scanner scanner, ClienteDaoImplMy8Jdbc aux) {
		System.out.println("Dime el CIF del cliente que vamos a eliminar: ");
		String eliminarCif = scanner.next();
		boolean resultado = aux.eliminarCliente(eliminarCif);
		if (resultado == true) {
			System.out.println("Ups, error detectado");
		}
		else {
			System.out.println("Cliente elimind@");
		}
	}
	
	public static void exportarFichero(ClienteDaoImplMy8Jdbc aux) {
		// Guardo mensaje de si exportar funciona correctamente
		String mensaje= aux.exportar("bbdd.txt");
		System.out.println(mensaje);
	}
	
	public static void importarFichero(ClienteDaoImplMy8Jdbc aux) {
		String mensaje = aux.importar("bbdd.txt");
		System.out.println(mensaje);
	}
	
}


