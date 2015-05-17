
public class OperacionesAritmeticas {

	public static void main(String[] args) {
		int a = 10;
		int b = 20;

		//Suma
		int c = a + b;
		System.out.println("-----------------------");
		System.out.println("Suma a + b: " + c);

		//Resta
		int d = a - b;

		System.out.println("Resta a - b: " + d);

		//Multiplicación
		int e = a * b;

		System.out.println("Multiplicacion a * b: " + e);

		//División
		double f = a / b;

		System.out.println("Division a / b: " + f);

		double g = a / 20.0;

		System.out.println("Division a / 20.0: " + g);

		//Módulo
		int h = a % b;

		System.out.println("Modulo a % b: " + h);

		double i = a % 20.0;

		System.out.println("Modulo de a % 20.0: " + i);
		System.out.println("-----------------------");
	}

}