package seguro;
import xml.*;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Asegurado{

	private String nombre;
	private String folio;
	private String edad;
	private String sexo;
	private String direccion;

	private Integer evalua;

	public Asegurado()
	{
			ingresarDatos();


	}

	public void imprimirSaludo()
	{
		System.out.println("Hola desde asegurado!");


	}


	public void ingresarDatos()
	{

		System.out.print("Nombre del Afiliado:");
		nombre = new Scanner(System.in).nextLine();

		System.out.print("Folio de Afiliado:");
		folio = new Scanner(System.in).nextLine();

		System.out.print("Edad:");
		edad = new Scanner(System.in).nextLine();

		System.out.print("Sexo:");
		sexo = new Scanner(System.in).nextLine();

		System.out.print("Dirección:");
		direccion = new Scanner(System.in).nextLine();

		evalua = 0;
		confirmarIngreso();


	}

	public void confirmarIngreso()
	{


		System.out.println("\nUsted ha capturado los siguientes datos:\n\n");
		System.out.print("Nombre: ");
		evaluarIngreso(nombre,"cadena");

		System.out.print("Folio:: ");
		evaluarIngreso(folio,"numero");

		System.out.print("Edad: ");
		evaluarIngreso(edad,"numero");

		System.out.print("Sexo: ");
		evaluarIngreso(sexo,"cadena");
		
		System.out.print("Dirección: " + direccion);

		System.out.println("\n¿La informacion es correcta (si/no)?: ");
		String esCorrecta = new Scanner(System.in).next();

		if("si".equalsIgnoreCase(esCorrecta) && evalua == 0){
			/*System.out.println("\nIngresaste: " + esCorrecta + ", presiona Enter para continuar");
			*/
	
			ManejadorArchivo manejadorArchivo = new ManejadorArchivo();
			manejadorArchivo.guardarAsegurado(nombre,folio,edad,sexo,direccion); 
	
		}else{

			evalua = 0;
			ingresarDatos();

		}

	}

	public void evaluarIngreso(String cad, String tipo){

		String expresion=".*";
		String [] novalido;

		if("Cadena".equalsIgnoreCase(tipo)){
			expresion = "[a-zA-Z ]{1,}";
		}
		else{ 

			if("Numero".equalsIgnoreCase(tipo)){
				expresion = "[0-9]{1,}";
			}
		}

		Pattern patcad = Pattern.compile(expresion);
		Matcher mat = patcad.matcher(cad);

		if(mat.matches()){
			System.out.println(cad+": Dato valido ");
		}else{
			evalua = 1;
			novalido = cad.split(expresion);
			System.out.print(cad+": Caracteres no validos: ");
			for(int i = 0; i<novalido.length; i++){
         		System.out.print(novalido[i]);
     		}
     		System.out.println("");
			
		}

		// SEXO ----> "[M|F]
		// FOLIO ----> "[A-Za-z0-9]{10,10}"
		// DIRECCION -----> ".*"


	}
}