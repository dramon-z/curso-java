import java.util.Scanner;

public class PruebaScanner  {
	
	public static void main(String[] args) {
	      System.out.print("Escribe algo: ");
	      String algo = new Scanner(System.in).nextLine();

	      System.out.print("Escribe un numero: ");
	      String numero = new Scanner(System.in).nextLine();

	      System.out.println("Escribistes: " + algo + "y el numero: " + numero);
	}

}