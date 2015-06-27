
package seguro;
import java.util.Scanner;
public class Asegurado{
	//Creo el constructor
	public Asegurado(){
		imprimirSaludo();
		String nombre = texto("Nombre");
		String ape_pat = texto("APELLIDO MATERNO");
		String ape_mat = texto("APELLIDO PATERNO");
		int edad = entero("EDAD",1,99);
		String sexo = texto("SEXO");
		String direccion = texto("DIRECCIÓN");
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nLos datos ingresados son: ");
		System.out.println("NOMBRE:\t\t\t\t"+nombre+"\nAPELLIDO PATERNO:\t\t"+ape_pat+"\nAPELLIDO MATERNO:\t\t"+ape_mat+"\nEDAD:\t\t\t\t"+edad+"\nSEXO:\t\t\t\t"+sexo+"\nDIRECCIÓN:\t\t\t"+direccion);
		String continuar = new Scanner(System.in).nextLine();
	}
	
	//Creo el METODO 
	public void imprimirSaludo(){
		System.out.println("Hola desde asegurado");
		
	}
	public static String texto(String elemento) { //Creo el METODO DE LA CLASE que retorna String
		Scanner sc = new Scanner(System.in); //Creo el objeto scanner
		String texto="";
		boolean textoCorrecto;
		do{
			System.out.println("Dime tu "+elemento+", solo letras : ");
			texto = sc.nextLine();
			textoCorrecto=texto.matches("[a-zA-z ñÑ 0-9]*");
		}while(!textoCorrecto);
			return texto;
		}

	public static int entero(String elemento, int rango_izquierdo, int rango_derecho) { //Creo el METODO DE LA CLASE que retorna int.
		Scanner sc = new Scanner(System.in);
    	int numero=0;
	    do {
	        System.out.println("Ingrese la "+elemento+" de su preferencia, debe ser n\u00famero positivo entre "+rango_izquierdo+"-"+rango_derecho+": "); // \u00fa es el unicode para ú
	        while (!sc.hasNextInt()) {
	            System.out.println(elemento+" de su preferencia debe ser n\u00famero positivo entre "+rango_izquierdo+"-"+rango_derecho+": ");
	            sc.next(); // Importante, no se debe de olvidar ingresar el next para que no vuela a cargar el mismo token
	        }
	        numero = sc.nextInt();
	    } while (numero < rango_izquierdo || numero > rango_derecho);
	    return numero;
	}
}