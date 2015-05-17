public class Primitivos{
	
	public static void main(String[] args){
		System.out.println("-----------------------");

		//Valores de Cierto o Falso | True or False
		
		System.out.println("Boolean son valores de Cierto o Falso | True or False");
		
		boolean cierto = true;
		System.out.println("Cierto o Falso: "+ String.valueOf(cierto)); 
		System.out.println("-----------------------");

		
		//Char | valor de un Caracter en comillas simples
		
		System.out.println("Char | valor de un Caracter en comillas simples");

		char caracter = 'E';
		System.out.println("Caracter or Char: " + String.valueOf(caracter));
		System.out.println("-----------------------");

		//El byte representa un número de 8 bits, puede contener valores desde -128 hasta 127

		System.out.println("El byte representa un número de 8 bits, puede contener valores desde -128 hasta 127");

		byte numbyte = 5;
		System.out.println("Valor de Byte: " + String.valueOf(numbyte));
		System.out.println("-----------------------");

		//El short representa un número de 16 bits, y pueden ser de -32768 hasta 32767

		System.out.println("El short representa un número de 16 bits, y pueden ser de -32768 hasta 32767");

		short numshort = 1024;
		System.out.println("Valor de Short:" + String.valueOf(numshort));
		System.out.println("-----------------------");

		//El int representa un número de 32 bits, puede contener valores desde -2147483648 hasta 2147483647

		System.out.println("El int representa un número de 32 bits, puede contener valores desde -2147483648 hasta 2147483647");

		int numero_entero = 2147483639;
		System.out.println("Valor de Entero: "+ String.valueOf(numero_entero));
		System.out.println("-----------------------");

		//El long representa un numero de 64 bits, y pueden ser asignado valores de numeros muy grandes;

		System.out.println("El long representa un numero de 64 bits, y pueden ser asignado valores de numeros muy grandes;");

		long numero_grande = 1000000000000L;
		System.out.println("Valor de Long:" + String.valueOf(numero_grande));
		System.out.println("-----------------------");

		//El Float pueden ser asignados valores decimales de 32 Bits

		System.out.println("El Float pueden ser asignados valores decimales de 32 Bits");

		float decimal = 100.7900f;
		System.out.println("Valor de Float: "+ String.valueOf(decimal));
		System.out.println("-----------------------");

		//El Double  pueden ser asignados valores decimales de 64 Bits

		System.out.println("El Double  pueden ser asignados valores decimales de 64 Bits");

		double decimal_grande = 1000000000000.785220;
		System.out.println("Valor de Double: "+ String.valueOf(decimal_grande));
		System.out.println("-----------------------");
	}
}