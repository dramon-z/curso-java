import java.util.Scanner;
import seguro.Asegurado;
import xml.ManejadorArchivo;

public class Menu{

	private Asegurado persona = new Asegurado();

	public void imprimirMenu(){
		System.out.println("Bienvenido selecciona la opcion deseada: ");
		System.out.println("***********************************");
		System.out.println("* 1 Agregar asegurado             *");
		System.out.println("* 2 Consultar asegurado           *");
		System.out.println("* 3 Eliminar asegurado            *");
		System.out.println("* 4 Salir                         *");
		System.out.println("***********************************");
		System.out.print("Ingrese un valor numerico: ");
		Integer opcion = new Scanner(System.in).nextInt();
		ejecutarOpcion(opcion);
	}

	public void ejecutarOpcion(Integer opcion){
		switch (opcion) {

				case 1: persona.ingresarDatos();
				break;
				case 2: persona.buscar();
				break;
				case 3: persona.eliminar();
				break;
				case 4: System.out.println("¡Gracias por utilizar el Sistema!");
						System.exit(0);
				break;
				default: System.out.print("La opcion: " + opcion +" no es valida" +
							" Presiona enter para continuar");
				break;
		}
		new Scanner(System.in).nextLine();
		imprimirMenu();
	}

	public static void main (String [] args){

		Menu scann = new Menu();	
		scann.imprimirMenu();
	}
}