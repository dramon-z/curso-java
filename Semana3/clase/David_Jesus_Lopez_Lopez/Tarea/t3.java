

public class t3 {

	public static void main(String[] args) {
		System.out.print(" Como te llamas: ");
		String nombre = System.console().readLine();

		System.out.print(" Cuales son tus Apellidos: ");
		String apellido = System.console().readLine();

        System.out.print(" En que Dia Nacistes: ");
		String dia = System.console().readLine();

        System.out.print(" En que Mes Nacistes: ");
		String mes = System.console().readLine();

		System.out.print(" Cual es tu Año de Nacimiento: ");
		int edad = 2015 - Integer.parseInt(System.console().readLine());

		System.out.println(" Hola: " + nombre + apellido);
		System.out.println("\n"+"Tu edad es: " + edad);
		
	}

}