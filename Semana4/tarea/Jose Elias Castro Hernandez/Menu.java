import java.util.Scanner;
import seguro.*;
import xml.*;


public class Menu{

	public static void main(String[] args){
			Menu menu = new Menu();
			menu.imp_menu();
		}


	public void imp_menu(){

		System.out.println("Bienvenido al sistema...");

		System.out.println("Menu...\n");
		System.out.println("1. Agregar asegurado");
		System.out.println("2. Consultar asegurado");
		System.out.println("3. Eliminar asegurado");
		System.out.println("4. Salir\n");
		System.out.print("   Escribe la Opcion: ");

		try{
			Integer opcion = new Scanner(System.in).nextInt();
			ejecutaOpcion(opcion);
		}

		catch(Exception e){
			System.out.println(e.getMessage());
			imp_menu();
		}
	

	}

	public void ejecutaOpcion(Integer opcion){
		switch(opcion){
			case 1:
				
				Asegurado asegurado = new Asegurado();
				

			break;
			case 2:

			/*	System.out.println("Ingresa nombre a consultar");
				String query = new Scanner(System.in).nextInt();*/
				ManejadorArchivo manejadorArchivo = new ManejadorArchivo();
				manejadorArchivo.buscarAsegurado("elias"); 

				/*	
				ManejadorArchivo manejadorArchivo2 = new ManejadorArchivo();
				manejadorArchivo2.buscarTodos(); 
				*/
			break;
			case 3:

				System.out.println("Ingresaste la opcion 3.");

				
			/*	ManejadorArchivo manejadorArchivo3 = new ManejadorArchivo();
				manejadorArchivo3.eliminarAsegurado("elias");*/

			break;
			case 4:

				System.out.println("Ingresaste la opcion 4.");				
				System.exit(0);

			break;
			default:

				System.out.println("default");

			break;
		}

		new Scanner(System.in).nextLine();
		imp_menu();

	}
	

}