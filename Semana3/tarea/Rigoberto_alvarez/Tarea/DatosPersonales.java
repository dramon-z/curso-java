
public class DatosPersonales {

	public static void main(String[] args) {
		System.out.print("Dime tu nombre: ");
		String nombre = System.console().readLine();
		System.out.print("Dime tu 1er Apellido: ");
		String apellido1 = System.console().readLine();
		System.out.print("Dime tu 2do Apellido: ");
		String apellido2 = System.console().readLine();
		System.out.print("Dime tu Edad: ");
		String Edad = System.console().readLine();

		System.out.println("Hola te llamas: " + nombre + apellido1 + apellido2 );
		System.out.println("Tienes :" + Edad + "años");
	}

}