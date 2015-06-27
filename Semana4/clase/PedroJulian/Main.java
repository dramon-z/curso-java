import java.util.Scanner;
public class Main {
	public static void main (String[] args) {
		PruebaScanner pruebaScanner = new PruebaScanner();
		PruebaScanner imprimirMenu[];
	}
	public void imprimirMenu() {
		System.out.print("Ingrese un numero: ");
		Integer numero = new Scanner(System.in).nextInt();
		ejecutarOpcion(numero);
	}
	public void  ejecutarOpcion(Integer numero) {
		switch (numero) {
			case 1:
			System.out.println("Ingresaste el numero 1. presiona enter para continuar");
			break;
			case 2:
			System.out.println("Ingresaste el numero 2. presiona enter para continuar");
			//Hacer algo para la opción 2
			break;
			case 3:
			System.out.println("Ingresaste el numero 3. presiona enter para continuar");
			//Hacer algo para la opción 3
			break;
			case 4:
			System.out.println("Ingresaste el numero 4. presiona enter para continuar");
			//Hacer algo para la opción 4
			break;
			}
	new Scanner(System.in).nextLine();
	imprimirMenu();
	}
	
	
}