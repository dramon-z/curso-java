

public class Datos{

		public static void main(String[] args) {
			System.out.print("Escribe tu nombre: ");
			String nombre= System.console().readLine();
			System.out.println(nombre);

			System.out.print("Escribe tu apellido paterno: ");
			String appat= System.console().readLine();
			System.out.println(appat);

			System.out.print("Escribe tu apellido materno: ");
			String apmat= System.console().readLine();
			System.out.println(apmat);

			System.out.print("Tu año de nacimiento es: ");
			Int anio= System.console().readLine();
			int c=(2015 - anio);

			System.out.println(c);






	}
}