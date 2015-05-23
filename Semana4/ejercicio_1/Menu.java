import java.util.Scanner;

import seguro.Asegurado;

public class Menu  {
	
    public static void main(String[] args) {
    	Menu menu = new Menu();
    	menu.imprimeMenu();
    }

    public void imprimeMenu() {
    	System.out.println("Bienvenido al Sistema");
	    System.out.println("1 Agregar Asegurado");
	    System.out.println("2 Consultar Asegurado");
	    System.out.println("3 Eliminar Asegurado");
	    System.out.println("4 Salir");
    	
    	System.out.print("Ingrese un numero: ");
    	Integer numero = new Scanner(System.in).nextInt();
    	ejecutarOpcion(numero);
    }

    public void ejecutarOpcion(Integer numero) {
    	switch (numero) {
    		case 1:
    		Asegurado asegurado = new Asegurado();
    		System.out.println("Presiona enter para continuar");
    		break;
    		case 2:
    		System.out.println("Ingresastes el numero 2");
    		System.out.println("Presiona enter para continuar");
    		break;
    		case 3:
    		System.out.println("Ingresastes el numero 3");
    		System.out.println("Presiona enter para continuar");
    		break;
    		case 4:
    		System.out.println("¡Gracias por utilizar el sistema!");
    		System.exit(0);
    		break;
    		default:
    		     System.out.println("La opcion seleccionada no es valida");
    		     System.out.println("Presione enter para continuar");
    		break;
    	}

    	new Scanner(System.in).nextLine();
    	imprimeMenu();
    }

}