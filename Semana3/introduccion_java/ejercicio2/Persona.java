/*
Esta clase crea un objeto y saludo a partir de una propiedad del objeto: nombre
*/
public class Persona {

	private String nombre = "David Jesus Lopez";

	public static void main(String[] args) {
		Persona yo = new Persona();

		System.out.println("¡Hola " + yo.nombre + "!");
	}

}