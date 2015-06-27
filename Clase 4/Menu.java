import java.util.Scanner;

import seguro.Asegurado;
import Xml.ManejadorArchivoxml;


	public class Menu{
		public static void main(String[] args) {
			Menu menu = new Menu();
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
			System.out.println("4.- Salir");
			System.out.println(" ");
			System.out.println(" ");

			System.out.print("Elige una opcion: ");
			Integer numero = new Scanner(System.in).nextInt();
			ejecutarOpcion(numero);	
		}

			public void ejecutarOpcion(Integer numero){

			switch (numero) {
				case 1:
					System.out.println("La opcion deseada es: Agregar Asegurado");
					System.out.println(" ");
					new Asegurado();
					System.out.println(" ");
					System.out.println("*** Presiona Enter para continuar ***");
					break;
				case 2:
					System.out.println("La opcion deseada es: Consultar Asegurado");
					System.out.println(" ");
					System.out.print("Ingresa el nombre del asegurado que desea buscar: ");
					String busqueda =  new Scanner(System.in).nextLine();
					System.out.println("*** Presiona Enter para continuar ***");
					break;
				case 3:
					System.out.println("La opcion deseada es: Eliminar Asegurado");
					System.out.println(" ");
					String busqueda
					System.out.println("*** Presiona Enter para continuar ***");
					break;
				case 4:
					System.out.println("La opcion deseada es: Salir");
					System.out.println(" ");
					System.out.println("*** Bye Bye ***");
					System.exit(0);
					break;
			}
			
			new Scanner(System.in).nextLine();
			imprimirmenu();				
		
			

	}
	
	
	
}