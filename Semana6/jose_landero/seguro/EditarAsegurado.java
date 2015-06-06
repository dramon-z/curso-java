package seguro;

import java.util.*;

import db.ManejadorDB;

public class EditarAsegurado {

	private int id;
	private String nombreAsegurado;
	private String apellidoAsegurado;
	private String numeroSeguroSocial;
	private Integer edad;
	private String sexo;

	public EditarAsegurado() {
		ejecutarFormulario();
	}

	public void ejecutarFormulario() {
		System.out.print("Introduzca el nombre del asegurado que desea editar: ");

		String busqueda = new Scanner(System.in).nextLine();
		ManejadorDB manejadorDb = new ManejadorDB();

		Map<String, Object> asegurado = null;

		try {
			asegurado = manejadorDb.obtenerAsegurado(busqueda);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (null == asegurado || asegurado.keySet().isEmpty()) {
			System.out.println("No se ha encontrado el beneficiario ingresado..");
			return;
		}

		nombreAsegurado = (String) asegurado.get("nombre");
		apellidoAsegurado = (String) asegurado.get("apellido");
		edad = (Integer) asegurado.get("edad");
		sexo = (String) asegurado.get("sexo");
		numeroSeguroSocial = (String) asegurado.get("numeroSeguroSocial");
		id = (int) asegurado.get("id");

		System.out.println("Ingrese los nuevos datos para el asegurado (deje en blanco si no desea editar)");

		System.out.print("Nombre del Asegurado: ");
		String tmpNombreAsegurado = new Scanner(System.in).nextLine();

		System.out.print("Apellido del Asegurado: ");
		String tmpApellidoAsegurado = new Scanner(System.in).nextLine();
		
		System.out.print("Numero de Seguro Social: ");
		String tmpNumeroSeguroSocial = new Scanner(System.in).nextLine();

		System.out.print("Edad: ");
		String tmpEdad = new Scanner(System.in).nextLine();

		System.out.print("Sexo: ");
		String tmpSexo = new Scanner(System.in).nextLine();

		if (tmpNombreAsegurado != null && !tmpNombreAsegurado.isEmpty()) {
			nombreAsegurado = tmpNombreAsegurado;
		}

		if (tmpApellidoAsegurado != null && !tmpApellidoAsegurado.isEmpty()) {
			apellidoAsegurado = tmpApellidoAsegurado;
		}

		if (tmpEdad != null && !tmpEdad.isEmpty()) {
			edad = new Integer(tmpEdad);
		}

		if (tmpSexo != null && !tmpSexo.isEmpty()) {
			sexo = tmpSexo;
		}

		if (tmpNumeroSeguroSocial != null && !tmpNumeroSeguroSocial.isEmpty()) {
			numeroSeguroSocial = tmpNumeroSeguroSocial;
		}

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
				ManejadorDB manejadorDb = new ManejadorDB();
				manejadorDb.actualizarAsegurado(id, nombreAsegurado, apellidoAsegurado, edad, sexo, numeroSeguroSocial);
				System.out.print("Los datos del asegurado se han actualizado, presione enter para continuar...");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			ejecutarFormulario();
		}
	}

}