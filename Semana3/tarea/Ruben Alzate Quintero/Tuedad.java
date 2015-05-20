import java.util.Scanner; //importo la libreria Scanner que es donde se encuentra la clase correspondiente a los inputs akka Scanner
import java.util.Calendar; //importo la libreria Calendar que es donde se encuentra la clase correspondiente a recoger la el dia anio y mes actual
import java.util.GregorianCalendar; //importo la libreria Calendar que es donde se encuentra la clase correspondiente a recoger la el dia anio y mes actual
import java.io.*;
public class Tuedad{
	public static void main(String[] args)
	    {
	    	Scanner sc = new Scanner(System.in); //Creo el objeto scanner
	    	
//Solicito string y valido que solo ingrese string de a a la z y de A a la Z (MAYUSCULAS)

	    	String nombre="";
	        boolean nombreCorrecto;
	        do{
	            System.out.println("Dime tu NOMBRE, solo letras : ");
	            nombre = sc.nextLine();
	            nombreCorrecto=nombre.matches("[a-zA-z]*");
	        }while(!nombreCorrecto);

//Solicito string y valido que solo ingrese string de a a la z y de A a la Z (MAYUSCULAS)

	    	String ape_pat="";
	        boolean ape_patCorrecto;
	        do{
	            System.out.println("Dime tu APELLIDO MATERNO, solo letras : ");
	            ape_pat = sc.next();
	            ape_patCorrecto=nombre.matches("[a-zA-z]*");
	        }while(!ape_patCorrecto);

//Solicito string y valido que solo ingrese string de a a la z y de A a la Z (MAYUSCULAS)

	    	String ape_mat="";
	        boolean ape_matCorrecto;
	        do{
	            System.out.println("Dime tu APELLIDO PATERNO, solo letras : ");
	            ape_pat = sc.next();
	            ape_patCorrecto=nombre.matches("[a-zA-z]*");
	        }while(!ape_patCorrecto);

//Solicito int y me aseguro que cumpla con: solo positivo, y que ente entre el rango correspondiente
	    	
	    	int dia_nac=0;
		    do {
		        System.out.println("Ingresa el DIA de nacimiento, debe ser número positivo entre 1-31: ");
		        while (!sc.hasNextInt()) {
		            System.out.println("DIA de nacimiento debe ser número positivo entre 1-31: ");
		            sc.next(); // Importante, no se debe de olvidar ingresar el next para que no vuela a cargar el mismo token
		        }
		        dia_nac = sc.nextInt();
		    } while (dia_nac < 0 || dia_nac > 31);
	    	
//Solicito int y me aseguro que cumpla con: solo positivo, y que ente entre el rango correspondiente

	    	int mes_nac=0;
		    do {
		        System.out.println("Ingresa el MES de nacimiento, debe ser número positivo entre 1-12: ");
		        while (!sc.hasNextInt()) {
		            System.out.println("MES de nacimiento debe ser número positivo entre 1-12: ");
		            sc.next(); // Importante, no se debe de olvidar ingresar el next para que no vuela a cargar el mismo token
		        }
		        mes_nac = sc.nextInt();
		    } while (mes_nac < 0 || mes_nac > 12);

//Solicito int y me aseguro que cumpla con: solo positivo, y que ente entre el rango correspondiente

			int anio_nac=0;
		    do {
		        System.out.println("Ingresa el ANIO de nacimiento, debe ser número positivo entre 1-2015: ");
		        while (!sc.hasNextInt()) {
		            System.out.println("ANIO de nacimiento debe ser número positivo entre 1-2015: ");
		            sc.next(); // Importante, no se debe de olvidar ingresar el next para que no vuela a cargar el mismo token
		        }
		        anio_nac = sc.nextInt();
		    } while (anio_nac < 1 || anio_nac > 2015);

		    Calendar calendario = Calendar.getInstance();
		    int dia_actual=calendario.get(Calendar.DAY_OF_MONTH);
		    int mes_actual=calendario.get(Calendar.MONTH)+1;
		    int anio_actual=calendario.get(Calendar.YEAR);

		    int iYear = anio_actual - anio_nac;
		    int iMonth = mes_actual - mes_nac;
		    int d = dia_actual - dia_nac;
		    
		 //   System.out.println("RUBEN ALZATE QUINTERO, NACISTE EN: "+dia_nac+"/"+mes_nac+"/"+anio_nac+" LA FECHA ACTUAL ES "+dia_actual+"/"+mes_actual+"/"+anio_actual);


		     
		    if (d <= -1) {
		        d = 30 - Math.abs(d);
		        iMonth = iMonth - 1;
		    }
		     
		    if (iMonth <= -1) {
		        iMonth = 12 - Math.abs(iMonth);
		        iYear = iYear - 1;
		    }
		     
		    System.out.println(nombre+" "+ape_pat+" "+ape_mat+" tu edad es: "+iYear+ " anio(s) "+iMonth+" mes(es) "+d+" dia(s)"); 
		      
		    
	    }
}