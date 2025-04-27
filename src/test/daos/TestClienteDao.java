package test.daos;
 
 import java.io.File;
import modelo.dao.ClienteDao;
 import modelo.dao.ClienteDaoImplMy8Jdbc;
 import modelo.javabeans.Cliente;
 
 public class TestClienteDao {
 	private static ClienteDao cdao;
 	static {
 		cdao = new ClienteDaoImplMy8Jdbc();
 	}
 	public static void main(String[] args) {
 		alta();
 		uno();
 		todos();
 		eliminar();
 		exportar();
 		importar();
 	}
 
 	public static void alta() {
 		System.out.println("\nAlta nuevo cliente\n");
 		Cliente cliente = new Cliente ("C86446897", "Ana", "Garcia Ruiz","Barcelona", 120000.00, 1600);
 		
 		System.out.println("Cliente dado de alta (me espero 1)" + cdao.altaCliente(cliente));
 		
 		Cliente cliente2 = new Cliente ("A11111111","Eva","González Pérez","Madrid",	850000.00, 20);
 		System.out.println("El cliente ya está dado de alta (me espero 0)" + cdao.altaCliente(cliente2));
 
 	}
 /* Comprobamos que el cliente anterior se añadió correctamente y comprobamos BuscarCliente */
 	public static void uno() {
 		System.out.println("\nBuscar un cliente\n");
 		System.out.println("El cliente existe: "+ cdao.buscarUno("C86446897"));
 		System.out.println("El cliente no existe: "+ cdao.buscarUno("C864468007"));
 	}
 
 	public static void todos() {
 		System.out.println("\nBuscar Todos\n");
 		for (Cliente ele: cdao.buscarTodos())
 			System.out.println(ele);
 	}
 
 	public static void eliminar() {
 		System.out.println("\nEliminar un cliente\n");
 		
 		System.out.println("Eliminar cliente que existe, me espero un true: "+ cdao.eliminarCliente("C86446897"));
 		System.out.println("Eliminar cliente que NO existe, me espero un false: "+ cdao.eliminarCliente("C86400897"));
 		}
 
 	public static void exportar() {
 		System.out.println("\nExportar fichero\n");
 		/* Creamos fichero y añadimos datos de BBDD */
 		String nombreFichero = "clientes_exportados.txt";
        String resultado = cdao.exportar(nombreFichero);
        System.out.println(resultado);
 		/* Comprobamos si se creo el fichero correctamente e informamos del resultado */
 		File file = new File(nombreFichero);
        if (file.exists()) {
            System.out.println("El archivo fue creado correctamente.");
        } else {
            System.out.println("Error al crear el archivo.");
        }
 	}
  
 	public static void importar() {
 		System.out.println("\nImportar fichero\n");
 		
 		String fichero = "clientes_exportados.txt";
        System.out.println(cdao.importar(fichero));
 		}
 
 }
