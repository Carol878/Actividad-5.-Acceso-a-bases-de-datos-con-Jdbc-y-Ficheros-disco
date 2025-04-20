package principales;
import java.util.Scanner;

import modelo.dao.ClienteDaoImplMy8Jdbc;

public class GestionClientes {
	
	public static void main(String[] args){
		String menu = "";
		Scanner scLeerTeclado = new Scanner(System.in);
		ClienteDaoImplMy8Jdbc aux = new ClienteDaoImplMy8Jdbc();
		
		do {
			System.out.println("Dime que opción quieres realizar: 1 Alta del Cliente, 2 Buscar un Cliente, 3 Mostrar Todos, 4 Eliminar un cliente, "
					+"5 Exportar a fichero, 6 Importar desde fichero, 7 Salir");
			menu = scLeerTeclado.next();
			switch (menu){
			case "1": 
				altaCliente(scLeerTeclado, aux);
				System.out.println("Alta del Cliente");
				break;
			case "2": 
				buscaCliente(scLeerTeclado, aux);
				System.out.println("Buscar un Cliente");
				break;
			case "3": 
				mostrarClientes(aux);
				System.out.println("Mostrar todos");
				break;
			case "4": 
				eliminarCliente(scLeerTeclado, aux);
				System.out.println("Eliminar un cliente");
				break;
			case "5": 
				exportarFichero(scLeerTeclado, aux);
				System.out.println("Exportar un fichero");
				break;
			case "6": 
				importarFichero(scLeerTeclado, aux);
				System.out.println("Importar desde fichero");
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
		//aux.altaCliente(guardarCif, guardarNombre, guardarApellido, guardarDomicilio, guardarFactAnual, guardarNumeroEmpleados);
	}
	
	public static void buscaCliente(Scanner scanner, ClienteDaoImplMy8Jdbc aux) {
		System.out.println("Dime el CIF del cliente a buscar: ");
		String buscarCif = scanner.next();
		aux.buscarUno(buscarCif);
	}
	
	public static void mostrarClientes(ClienteDaoImplMy8Jdbc aux) {
		System.out.println("Dime el CIF del nuevo cliente: ");
		aux.buscarTodos();
	}
	
	public static void eliminarCliente(Scanner scanner, ClienteDaoImplMy8Jdbc aux) {
		System.out.println("Dime el CIF del cliente que vamos a eliminar: ");
		String eliminarCif = scanner.next();
		aux.eliminarCliente(eliminarCif);
	}
	
	public static void exportarFichero(Scanner scanner, ClienteDaoImplMy8Jdbc aux) {
		System.out.println("Dime el CIF del cliente que vamos a exportar: ");
		String exportarCif = scanner.next();
		//aux.exortarCliente();
	}
	
	public static void importarFichero(Scanner scanner, ClienteDaoImplMy8Jdbc aux) {
		System.out.println("Dime el CIF del cliente que vamos a importar: ");
		String importarCif = scanner.next();
		//aux.importarCliente();
	}
}


