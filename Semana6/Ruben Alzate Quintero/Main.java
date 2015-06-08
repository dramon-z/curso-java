import java.util.Scanner;
import seguro.BD;

//import xml.ManejadorArchivo;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		main.imprimirMenu();
	}

	public void imprimirMenu() {
		Scanner scanner = new Scanner(System.in);
		int opcion;
		do{
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("Bienvenido al sistema de registro y consulta del padrón del seguro social, a continuación aparecen las opciones disponibles:");
			System.out.println("");
			System.out.println("1. Agregar asegurado");
			System.out.println("2. Consultar asegurado");
			System.out.println("3. Eliminar asegurado");
			System.out.println("4. Salir");
			System.out.println("");
			System.out.print("Ingrese el número de la opción deseada y presione enter: ");
			opcion = scanner.nextInt();
			ejecutarOpcion(opcion);
		}while(opcion!=4);

	}

	public void ejecutarOpcion(int opcion) {
		switch (opcion) {
			case 1:
				BD a = new BD(1);
			break;
			case 2:
				BD b = new BD(2);
			break;
			case 3:
				BD c = new BD(3);
			break;
			case 4:
				System.out.print("¡Gracias por utilizar el sistema!");
				System.exit(0);
			break;
			default:
				System.out.print("La opción seleccionada no es válida. Presione enter para continuar.");
			break;
		}

		new Scanner(System.in).nextLine();

	}



}