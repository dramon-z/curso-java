import java.util.Scanner;

public class PruebaScanner{
	
	public static void main(String[] args){
		System.out.println("Escribe Algo:");
		String algo = new Scanner(System.in).nextLine();

		System.out .println("Escribe un numero:");
		Integer numero = new Scanner(System.in).nextInt();

		System.out.println("La cadena que escribiste: "+ algo);
		System.out.println("El numero que escribiste: "+ numero);
	}

}