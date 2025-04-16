package principales;
import java.util.Scanner;

public class GestionClientes {
	
	public static void main(String[] args){
		String menu = "";
		Scanner scLeerTeclado = new Scanner(System.in);
		do {
			System.out.println("Dime que opción quieres realizar: 1 Alta del Cliente, 2 Buscar un Cliente, 3 Mostrar Todos, 4 Eliminar un cliente, "
					+"5 Exportar a fichero, 6 Importar desde fichero, 7 Salir");
			menu = scLeerTeclado.next();
			switch (menu){
			case "1": 
				System.out.println("Alta del Cliente");
				break;
			case "2": 
				System.out.println("Buscar un Cliente");
				break;
			case "3": 
				System.out.println("Mostrar todos");
				break;
			case "4": 
				System.out.println("Eliminar un cliente");
				break;
			case "5": 
				System.out.println("Exportar un fichero");
				break;
			case "6": 
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
}
