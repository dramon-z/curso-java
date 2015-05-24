//Importante, tuve muchos problemas con el tema de tildes y ñ caracteres solo del habla español, por lo tanto tuve que compilar con la siguiente linea:
// javac -encoding ISO-8859-1 IMSS.java

import java.util.Scanner; //importo la libreria Scanner que es donde se encuentra la clase correspondiente a los inputs akka Scanner
import seguro.Asegurado;
/*
La siguiente es la lista unicode para que el texto que se imprima en System.out.print() se vea correcto y no con errores como suele pasar...

\u00e1 -> á
\u00e9 -> é
\u00ed -> í
\u00f3 -> ó
\u00fa -> ú
\u00c1 -> Á
\u00c9 -> É
\u00cd -> Í
\u00d3 -> Ó
\u00da -> Ú
\u00f1 -> ñ
\u00d1 -> Ñ

*/



public class IMSS{

	public static String texto(String elemento) { //Creo el METODO DE LA CLASE que retorna String
		Scanner sc = new Scanner(System.in); //Creo el objeto scanner
		String texto="";
		boolean textoCorrecto;
		do{
			System.out.println("Dime tu "+elemento+", solo letras : ");
			texto = sc.nextLine();
			textoCorrecto=texto.matches("[a-zA-z ñÑ]*");
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


	public static void espacio(int lineas) { //Creo el METODO DE LA CLASE que avanza la consola n numero de lineas.
		for(int clear = 0; clear < lineas; clear++) //Subo la tabla anterior 5 espacios
			  {
			     System.out.println("\b") ;
			  }

	}
	
	public static int menu(){
		System.out.println("Bienvenido al IMSS\n\n\n1. Agregar asegurado.\n2. Consultar asegurado.\n3. Eliminar asegurado.\n4. Salir.");
		espacio(5); //limpio la pantalla
		int seleccion = entero("SELECCION",1,4); //Pido entero entre 1 y 4
		return seleccion;
	}

	public static void main(String[] args)
	    {
	    	
		int seleccion;
		String continuar; 
		do{
			espacio(1); //Simulo limpiar pantalla
			seleccion=menu(); //Asigno el numero ingresado por el cliente a la variable seleccion.
			espacio(1);//Agrego espacio para que se vea bonito
			switch(seleccion){
				case 1: /*System.out.println("Su selecci\u00f3n es 1. Agregar asegurado.\n\n\nPresione ENTER para continuar");
						continuar = new Scanner(System.in).nextLine();*/
						Asegurado asegurado = new Asegurado();
						break;
				case 2: System.out.println("Su selecci\u00f3n es 2. Consultar asegurado.\n\n\nPresione ENTER para continuar");
						continuar = new Scanner(System.in).nextLine();
						break;
				case 3: System.out.println("Su selecci\u00f3n es 3. Eliminar asegurado.\n\n\nPresione ENTER para continuar");
						continuar = new Scanner(System.in).nextLine();
						break;
				case 4: System.out.println("Su selecci\u00f3n es 4. Salir.");
						break;
			}
		}while(seleccion!=4);

			    
	    }
}