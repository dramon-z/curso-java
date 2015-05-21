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
	public static void main(String[] args)
	    {
	    	
		for(int clear = 0; clear < 200; clear++) //Simulo limpiar pantalla, aunque en realidad no lo hago :P
			  {
			     System.out.println("\b") ;
			  }


	    	Scanner sc = new Scanner(System.in); //Creo el objeto scanner
	    	
//Solicito string y valido que solo ingrese string de a a la z y de A a la Z (MAYUSCULAS)

	    	String nombre="";
	        boolean nombreCorrecto;
	        do{
	            System.out.println("Dime tu NOMBRE, solo letras : ");
	            nombre = sc.nextLine();
	            nombreCorrecto=nombre.matches("[a-zA-z ñÑ]*");
	        }while(!nombreCorrecto);

//Solicito string y valido que solo ingrese string de a a la z y de A a la Z (MAYUSCULAS)

	    	String ape_pat="";
	        boolean ape_patCorrecto;
	        do{
	            System.out.println("Dime tu APELLIDO PATERNO, solo letras : ");
	            ape_pat = sc.next();
	            ape_patCorrecto=ape_pat.matches("[a-zA-z ñÑ]*");
	        }while(!ape_patCorrecto);

//Solicito string y valido que solo ingrese string de a a la z y de A a la Z (MAYUSCULAS)

	    	String ape_mat="";
	        boolean ape_matCorrecto;
	        do{
	            System.out.println("Dime tu APELLIDO MATERNO, solo letras : ");
	            ape_mat = sc.next();
	            ape_matCorrecto=ape_mat.matches("[a-zA-z ñÑ]*");
	        }while(!ape_matCorrecto);

//Solicito int y me aseguro que cumpla con: solo positivo, y que ente entre el rango correspondiente
	    	
	    	int dia_nac=0;
		    do {
		        System.out.println("Ingresa el DIA de nacimiento, debe ser n\u00famero positivo entre 1-31: "); // \u00fa es el unicode para ú
		        while (!sc.hasNextInt()) {
		            System.out.println("DIA de nacimiento debe ser n\u00famero positivo entre 1-31: ");
		            sc.next(); // Importante, no se debe de olvidar ingresar el next para que no vuela a cargar el mismo token
		        }
		        dia_nac = sc.nextInt();
		    } while (dia_nac < 0 || dia_nac > 31);
	    	
//Solicito int y me aseguro que cumpla con: solo positivo, y que ente entre el rango correspondiente

	    	int mes_nac=0;
		    do {
		        System.out.println("Ingresa el MES de nacimiento, debe ser n\u00famero positivo entre 1-12: ");
		        while (!sc.hasNextInt()) {
		            System.out.println("MES de nacimiento debe ser n\u00famero positivo entre 1-12: ");
		            sc.next(); // Importante, no se debe de olvidar ingresar el next para que no vuela a cargar el mismo token
		        }
		        mes_nac = sc.nextInt();
		    } while (mes_nac < 0 || mes_nac > 12);

//Solicito int y me aseguro que cumpla con: solo positivo, y que ente entre el rango correspondiente

			int anio_nac=0;
		    do {
		        System.out.println("Ingresa el A\u00d1O de nacimiento, debe ser n\u00famero positivo entre 1-2015: "); //Uso el unicode \u00d1 para mostrar correctamente la Ñ
		        while (!sc.hasNextInt()) {
		            System.out.println("A\u00d1O de nacimiento debe ser n\u00famero positivo entre 1-2015: ");
		            sc.next(); // Importante, no se debe de olvidar ingresar el next para que no vuela a cargar el mismo token
		        }
		        anio_nac = sc.nextInt();
		    } while (anio_nac < 1 || anio_nac > 2015);

		    Calendar calendario = Calendar.getInstance(); //Creo el objeto calendario para sacar el dia, el mes y el año
		    int dia_actual=calendario.get(Calendar.DAY_OF_MONTH);
		    int mes_actual=calendario.get(Calendar.MONTH)+1; //Agrego +a debido a que calendar.month inicia en 0(enero)-11(diciembre), asi que para igualar el valor le sumo 1.
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
		    
			for(int clear = 0; clear < 200; clear++) //Simulo limpiar pantalla, aunque en realidad no lo hago :P
			  {
			     System.out.println("\b") ;
			  }

//Aqui imprimo la tabla de los valores por el cual se formó el resultado para que sea facilmente cotejable.
			System.out.println("ACTUAL:");
			System.out.println("\tDIA\tMES\tA\u00d1O");
			System.out.println("\t"+dia_actual+"\t"+mes_actual+"\t"+anio_actual);
   			System.out.println("\b") ;
   			System.out.println("NACIMIENTO:");
   			System.out.println("\tDIA\tMES\tA\u00d1O");
			System.out.println("\t"+dia_nac+"\t"+mes_nac+"\t"+anio_nac);
			System.out.println("\b") ;
			System.out.println("DIFERENCIA EN:");
			System.out.println("\tDIAS\tMESES\tA\u00d1OS");
			System.out.println("\t"+d+"\t"+iMonth+"\t"+iYear);

			for(int clear = 0; clear < 5; clear++) //Subo la tabla anterior 5 espacios
			  {
			     System.out.println("\b") ;
			  }

		    String NOMBRE = new String(nombre+" "+ape_pat+" "+ape_mat); 		    
		    System.out.println(NOMBRE.toUpperCase()+" tu edad es: "+iYear+ " a\u00f1o(s) "+iMonth+" mes(es) "+d+" dia(s)"); //Uso el unicode \u00f1 para presentar correctamente la ñ

			for(int clear = 0; clear < 5; clear++) //Subo la salida anterior para que se vea bonito
			  {
			     System.out.println("\b") ;
			  }		      
		    
	    }
}