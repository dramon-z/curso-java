package seguro;
import Xml.ManejadorArchivoxml;


import java.util.Scanner;
	public class Asegurado{
    private String nombre;
    private String appat;
    private String apmat;
	private Integer social;
	private Integer edad;
	private Integer c;
	private String sexo;
	private String direc;

	public Asegurado(){
		solictarDatos();
	}
	public void solictarDatos(){
		System.out.print("Escribe tu nombre: ");
		nombre = new Scanner(System.in).nextLine();
		System.out.println(" ");
			
		System.out.print("Escribe tu apellido paterno: ");
		appat = new Scanner(System.in).nextLine();
		System.out.println(" ");
			
		System.out.print("Escribe tu apellido materno: ");
		apmat = new Scanner(System.in).nextLine();
		System.out.println(" ");

		System.out.print("Escribe tu numero de seguro social: ");
		social = new Scanner(System.in).nextInt();
		System.out.println(" ");
			
		System.out.print("Sexo: (Escribe Masculino o Femenino): ");
		sexo = new Scanner(System.in).nextLine();
		System.out.println(" ");

		System.out.print("Tu año de nacimiento es?: ");
		edad = new Scanner(System.in).nextInt();
		c= 2015-edad;
/*		int anos= Integer.parseInt(System.console().readLine());
		int c=(2015-anos);
*/
		System.out.println(" ");

		System.out.print("Escribe tu direccion: ");
		direc = new Scanner(System.in).nextLine();
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		imprimirConfirma();
	}

		public void imprimirConfirma(){
			System.out.println(" ");
			System.out.println("¡Hola, buen dia !!!!! " + nombre + " " + appat + " " + apmat);
			System.out.println(" ");
			System.out.println("Tu numero de seguridad social es: " + social);
			System.out.println("Tu sexo es: " + sexo);
			System.out.println("Vives en: " + direc);
			System.out.println("Y tienes: " + c + " años ");
			System.out.println(" ");
			System.out.println(" ");
			System.out.print("La informacion es correcta (si/no)?: ");
			String esCorrecta=new Scanner(System.in).next();
			System.out.println(" ");

			if ("si".equals(esCorrecta)){
				try{
				ManejadorArchivoxml manejadorAsegurado = new ManejadorArchivoxml();
				manejadorAsegurado.guardarAsegurado(nombre,appat,apmat,social,sexo,direc,c);
				System.out.print("Los datos se Guardaron, presiona enter para continuar");
				} catch (Exception e){
				e.printStackTrace();
			}
			} else {
				solictarDatos();
			}
			System.out.println("Informacion proporcionada desde Asegurado !!!!!!!!!!");

		}
		
}	
