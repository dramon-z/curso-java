
public class AsignacionVariables {

	public String frase = "Soy un objeto feliz";

	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		System.out.println("-----------------------");
		System.out.println("1. Valor de 'a': " + a);
		System.out.println("1. Valor de 'b':" + b);
		System.out.println("");

		b = a;

		System.out.println("2. Valor de 'a': " + a);
		System.out.println("2. Valor de 'b':" + b);
		System.out.println("");

		a = 15;

		System.out.println("3. Valor de 'a': " + a);
		System.out.println("3. Valor de 'b':" + b);
		System.out.println("");

		AsignacionVariables c = new AsignacionVariables();
		AsignacionVariables d = new AsignacionVariables();

		System.out.println("4. Frase de 'c': " + c.frase);
		System.out.println("4. Frase de 'd': " + d.frase);
		System.out.println("");

		d.frase = "Soy un objeto mas o menos feliz";

		System.out.println("5. Frase de 'c': " + c.frase);
		System.out.println("5. Frase de 'd': " + d.frase);
		System.out.println("");

		c = d;

		System.out.println("6. Frase de 'c': " + c.frase);
		System.out.println("6. Frase de 'd': " + d.frase);
		System.out.println("");

		c.frase = "Soy un objeto muy loco";

		System.out.println("7. Frase de 'c': " + c.frase);
		System.out.println("7. Frase de 'd': " + d.frase);
		System.out.println("-----------------------");
	}

}