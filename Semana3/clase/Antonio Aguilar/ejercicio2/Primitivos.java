/*
Esta clase muestra los distintos tipos de datos primitivos en Java y 
la forma de declararlos e inicializarlos
*/
public class Primitivos {

	public static void main(String[] args) {
		//El boolean solo puede contener 2 valores, true o false.
		boolean cierto = false;

		System.out.println("Valor de 'cierto': " + cierto);

		//El char representa un solo caracter, a diferencia del String, la declaracion de char se hace comillas simples.
		char letra = 'c';

		System.out.println("Valor de 'letra': " + letra);

		//El byte representa un número de 8 bits, puede contener valores desde -128 hasta 127
		byte numeritito = 120;

		System.out.println("Valor de 'numeritito': " + numeritito);

		//El short representa un número de 16 bits, puede contener valores desde -32768 hasta 32767
		short numerito = 20374;

		System.out.println("Valor de 'numerito': " + numerito);

		//El int representa un número de 32 bits, puede contener valores desde -2147483648 hasta 2147483647
		int numero = 1239874;

		System.out.println("Valor de 'numero': " + numero);

		//El long representa un número de 64 bits, que puede contener numeros muy muy grandes
		long numerote = 129982109811231231L;

		System.out.println("Valor de 'numerote': " + numerote);

		//El double representa un número con digitos decimales de 64 bits
		double decimal = 31323.14;

		System.out.println("Valor de 'decimal': " + decimal);

		//El float representa un número con digitos decimales de 32 bits
		float pi = 3.1416f;

		System.out.println("Valor de 'pi': " + pi);
	}

}