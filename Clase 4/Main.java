import java.util.Scanner;
import seguro.AgregarAsegurado;
import seguro.EditarAsegurado;

import Xml.ManejadorArchivoxml;
import java.util.Properties;
import bd.Manejador_BD;


	public class Main{
		public static void main(String[] args) {
			Main menu = new Main();
			menu.imprimirmenu();
			}
			public void imprimirmenu(){
							
			System.out.println("*********************************");
			System.out.println("*****                       *****");
			System.out.println("+++++ Bienvenido al Sistema +++++");
			System.out.println("*****                       *****");
			System.out.println("*********************************");
			System.out.println(" ");
			System.out.println("1.- Agregar Asegurado");
			System.out.println("2.- Consultar Asegurado");
			System.out.println("3.- Eliminar Asegurado");
			System.out.println("4.- Editar Asegurado");
			System.out.println("5.- Salir");
			System.out.println(" ");
			System.out.println(" ");
			System.out.print("Elige una opcion: ");

			Scanner scanner = new Scanner(System.in);
			int numero = scanner.nextInt();
			
			ejecutarOpcion(numero);	
		}

			public void ejecutarOpcion(int numero) {

			switch (numero) {
				case 1:
					System.out.println("La opcion deseada es: Agregar Asegurado");
					System.out.println(" ");
					new AgregarAsegurado();
					System.out.println(" ");
					System.out.println("*** Presiona Enter para continuar ***");
					break;
				case 2:
				System.out.print("Ingreso el nombre del asegurado que desea buscar: ");
				String busqueda =  new Scanner(System.in).nextLine();
				
				try {
					Manejador_BD manejador_BD = new Manejador_BD();
					manejador_BD.busquedaAsegurado(busqueda);
				} catch (Exception e) {
					e.printStackTrace();
					System.exit(0);
				}
			break;

				case 3:
					System.out.println("La opcion deseada es: Eliminar Asegurado");
					System.out.println(" ");
					System.out.print("Ingresa el nombre del Asegurado que desea buscar: ");
					String busqueda2 = new Scanner(System.in).nextLine();

					try {
						Manejador_BD manejador_Bd = new Manejador_BD();
						int idAsegurado = manejador_Bd.obtenerIdAsegurado(busqueda2);

						if (0 == idAsegurado) {
							System.out.print("No se ha encontrado el Asegurado en la Base de Datos... Presiona ENTER para continuar");
						} else {
							manejador_Bd.eliminarAsegurado(idAsegurado);
						}
					} catch (Exception e) {
						e.printStackTrace();
						System.exit(0);
					}
				break;
					
				case 4:
					System.out.println("La opcion deseada es: Salir");
					System.out.println(" ");
					new EditarAsegurado();
				break;

				case 5:
					System.out.println("*** Bye Bye ***");
					System.exit(0);
					break;
					default:
						System.out.print("La opcion seleccionada no es válida....Presiona ENTER para continuar");
						break;
			}
			
			new Scanner(System.in).nextLine();
			imprimirmenu();				
		}
		
}