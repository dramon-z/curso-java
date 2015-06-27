package seguro;

import java.util.Scanner;

import bd.Manejador_BD;

public class AgregarAsegurado {

	private String nombreAsegurado;
	private String apellidoAsegurado;
	private String numeroSeguroSocial;
	private Integer edad;
	private String sexo;

	public AgregarAsegurado() {
		ejecutarFormulario();
	}

	public void ejecutarFormulario() {
		System.out.print("Nombre del Asegurado: ");
		nombreAsegurado = new Scanner(System.in).nextLine();

		System.out.print("Apellido del Asegurado: ");
		apellidoAsegurado = new Scanner(System.in).nextLine();

		System.out.print("Numero de Seguro Social: ");
		numeroSeguroSocial = new Scanner(System.in).nextLine();

		System.out.print("Edad: ");
		edad = new Scanner(System.in).nextInt();

		System.out.print("Sexo: ");
		sexo = new Scanner(System.in).nextLine();

		imprimirConfirmacion();
	}

	public void imprimirConfirmacion() {
		System.out.println("");
		System.out.println("Usted ha capturado los siguientes datos:");
		System.out.println("Nombre del Asegurado: " + nombreAsegurado);
		System.out.println("Apellido del Asegurado: " + apellidoAsegurado);
		System.out.println("Número de Seguro Social: " + numeroSeguroSocial);
		System.out.println("Edad: " + edad);
		System.out.println("Sexo: " + sexo);
		System.out.println("");
		System.out.print("¿La información es correta (si/no)?: ");
		String esCorrecta = new Scanner(System.in).next();

		if ("si".equals(esCorrecta)) {
			try {
				Manejador_BD manejador_Db = new Manejador_BD();
				manejador_Db.guardarAsegurado(nombreAsegurado, apellidoAsegurado, edad, sexo, numeroSeguroSocial);
				System.out.print("Los datos del asegurado se han guardado, presione enter para continuar...");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			ejecutarFormulario();
		}
	}

}