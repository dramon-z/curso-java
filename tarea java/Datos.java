

public class Datos{
	
		public static void main(String[] args) {
			System.out.print("Escribe tu nombre: ");
			String nombre= System.console().readLine();
			
			System.out.print("Escribe tu apellido paterno: ");
			String appat= System.console().readLine();
			
			System.out.print("Escribe tu apellido materno: ");
			String apmat= System.console().readLine();
			
			System.out.print("Tu año de nacimiento es?: ");
			int anos= Integer.parseInt(System.console().readLine());
			int c=(2015-anos);
/*
			System.out.print("Tu mes de nacimiento es?(escriba el número): ");
			int mes= Integer.parseInt(System.console().readLine());
			int c=(12 - mes);

			System.out.print("Escribe tu dia de naciemiento:");
			int dia=Integer.parseInt(System.console().readLine();
				if {mes=1; then
					e=31-dia};
				end if; 
				if mes=2; then
					e=28-dia;
				end if;
				if mes=3; then
					e=31-dia;
				end if;
				if mes=4; then
					e=30-dia;
				end if; 
				if mes=5; then
					e=31-dia;
				end if;
				if mes=6; then
					e=30-dia;
				end if;
				if mes=7; then
					e=31-dia;
				end if; 
				if mes=8; then
					e=31-dia;
				end if;
				if mes=9; then
					e=30-dia;
				end if;
				if mes=10; then
					e=31-dia;
				end if; 
				if mes=11; then
					e=30-dia;
				end if;
				if mes=12; then
					e=31-dia;
				end if;
*/
			System.out.println("¡Hola, buen dia, tu eres"+""+nombre+""+appat+""+apmat+"y tienes:"+c+"años");



	}
}