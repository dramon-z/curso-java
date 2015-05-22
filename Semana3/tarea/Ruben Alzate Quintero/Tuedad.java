//Importante, tuve muchos problemas con el tema de tildes y ñ caracteres solo del habla español, por lo tanto tuve que compilar con la siguiente linea:
// javac -encoding ISO-8859-1 Tuedad.java

import java.util.Scanner; //importo la libreria Scanner que es donde se encuentra la clase correspondiente a los inputs akka Scanner
import java.util.Calendar; //importo la libreria Calendar que es donde se encuentra la clase correspondiente a recoger la el dia anio y mes actual
import java.util.GregorianCalendar; //importo la libreria Calendar que es donde se encuentra la clase correspondiente a recoger la el dia anio y mes actual
import java.io.*; //Este es para usar con el .toupper()

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



public class Tuedad{

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
	        System.out.println("Ingresa el "+elemento+" de nacimiento, debe ser n\u00famero positivo entre "+rango_izquierdo+"-"+rango_derecho+": "); // \u00fa es el unicode para ú
	        while (!sc.hasNextInt()) {
	            System.out.println(elemento+" de nacimiento debe ser n\u00famero positivo entre "+rango_izquierdo+"-"+rango_derecho+": ");
	            sc.next(); // Importante, no se debe de olvidar ingresar el next para que no vuela a cargar el mismo token
	        }
	        numero = sc.nextInt();
	    } while (numero < rango_izquierdo || numero > rango_derecho);
	    return numero;
	}

	public static String edad(int dia_nac,int mes_nac,int anio_nac) { //Creo el METODO DE LA CLASE que retorna la edad como un String.
		    Calendar calendario = Calendar.getInstance(); //Creo el objeto calendario para sacar el dia, el mes y el año
		    int dia_actual=calendario.get(Calendar.DAY_OF_MONTH);
		    int mes_actual=calendario.get(Calendar.MONTH)+1; //Agrego +1 debido a que calendar.month inicia en 0(enero)-11(diciembre), asi que para igualar el valor le sumo 1.
		    int anio_actual=calendario.get(Calendar.YEAR);

		    int iYear = anio_actual - anio_nac; //Hago la diferencia de año actual menos el año de nacimiento
		    int iMonth = mes_actual - mes_nac; //Hago la diferencia de mes actual menos el mes de nacimiento
		    int d = dia_actual - dia_nac; //Hago la diferencia de dia actual menos el dia de nacimiento
		         
		    if (d <= -1) { //Aqui realizo los ajustes correspondientes para determinar el valor correcto de dias de edad.
		        d = 30 - Math.abs(d);
		        iMonth = iMonth - 1;
		    }
		     
		    if (iMonth <= -1) { //Aqui realizo los ajustes correspondientes para determinar el valor correcto de años de edad.
		        iMonth = 12 - Math.abs(iMonth);
		        iYear = iYear - 1;
		    }

		    String edad = iYear+ " a\u00f1o(s) "+iMonth+" mes(es) "+d+" dia(s)";
		    return edad;

	}

	public static void espacio(int lineas) { //Creo el METODO DE LA CLASE que avanza la consola n numero de lineas.
		for(int clear = 0; clear < lineas; clear++) //Subo la tabla anterior 5 espacios
			  {
			     System.out.println("\b") ;
			  }

	}

	public static void main(String[] args)
	    {
	    	
		espacio(200); //Simulo limpiar pantalla

		String nombre = texto("NOMBRE"); //Pido el dato
		String ape_pat = texto("APELLIDO PATERNO"); //Pido el dato
		String ape_mat = texto("APELLIDO MATERNO"); //Pido el dato
		espacio(100); //limpio la pantalla
		int dia_nac = entero("DIA",0,31); //Pido DIA
		int mes_nac = entero("MES",0,12); //Pido MES
		int anio_nac = entero("A\u00d1O",1,2015); //Pido AÑO
		String edad = edad(dia_nac,mes_nac,anio_nac); // Pido la edad
		espacio(100); //limpio la pantalla
		Calendar calendario = Calendar.getInstance(); //Creo el objeto calendario para sacar el dia, el mes y el año actual.
//Aqui imprimo la tabla de los valores por el cual se formó el resultado para que sea facilmente cotejable.
		System.out.println("ACTUAL:");
		System.out.println("\tDIA\tMES\tA\u00d1O");
		System.out.println("\t"+calendario.get(Calendar.DAY_OF_MONTH)+"\t"+(calendario.get(Calendar.MONTH)+1)+"\t"+calendario.get(Calendar.YEAR));
		System.out.println("\b") ;
		System.out.println("NACIMIENTO:");
		System.out.println("\tDIA\tMES\tA\u00d1O");
		System.out.println("\t"+dia_nac+"\t"+mes_nac+"\t"+anio_nac);
		System.out.println("\b");
		System.out.println("La diferencia es: "+edad+" por lo tanto...");

		espacio(5); //Subo la pantalla 5 espacios

	    String NOMBRE = new String(nombre+" "+ape_pat+" "+ape_mat); //Hago el upper para el nombre completo
	    System.out.println(NOMBRE.toUpperCase()+" tu edad es: "+edad); //Uso el unicode \u00f1 para presentar correctamente la ñ
	    espacio(5);//le doy 5 espacios para darle formato
			    
	    }
}