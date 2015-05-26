package seguro;

import java.util.Scanner;
import xml.ManejadorArchivo;

public class Asegurado{

	private String nombre;
	private int idSeguroSocial;
	private int edad;
	private String sexo;
	private String direccion;
	private ManejadorArchivo archivo;

	//Se instancia un objeto de tipo ManejadorArchivo
	public Asegurado(){
		archivo = new ManejadorArchivo();
	}

	/*
	*Ingresa por consola los datos de un Asegurado.
	**/
	public void ingresarDatos(){
		System.out.print("Escribe tu nombre: ");
		setNombre();
		System.out.print("Escribe tu numero de seguro social: ");
		setIdSeguroSocial();
		System.out.print("Escribe tu Edad: ");
		setEdad();
		System.out.print("Escribe tu Sexo: ");
		setSexo();
		System.out.print("Escribe tu direccion: ");
		setDireccion();
		System.out.println(" ");
		confirmacion();
	}

	/*
	*Despues de que se indica al programa que los datos
	*no son correctos entra a este metodo para poder
	*realizar la correción de 1 o todos los datos.
	**/
	public void corregirDatos(){
		System.out.println("¿Que dato deseas modificar?");
		System.out.println("***************");
		System.out.println("* 1 Nombre    *");
		System.out.println("* 2 SS        *");
		System.out.println("* 3 Edad      *");
		System.out.println("* 4 Sexo      *");
		System.out.println("* 5 Direccion *");
		System.out.println("* 6 Todo      *");
		System.out.println("***************");

		Integer opcion = esNumero();

		switch(opcion){
			case 1: System.out.print("Ingresa nuevamente el nombre: ");
					setNombre();
					System.out.print("Se modifico correctamente nombre: " + this.nombre +
						" Presiona enter para continuar...");
			break;
			case 2: System.out.print("Ingresa nuevamente el Seguro Social: ");
					setIdSeguroSocial();
			break;
			case 3: System.out.print("Ingresa nuevamente la edad: ");
					setEdad();
			break;
			case 4: System.out.print("Ingresa nuevamente el Sexo: ");
					setSexo();
			break;
			case 5: System.out.print("Ingresa nuevamente la direccion: ");
					setDireccion();
			break;
			case 6: System.out.print("Ingresa todos los datos nuevamente: ");
					ingresarDatos();
			break;
			default: System.out.print("Opcion Incorrecta");
			break;
		}

	}

	//Guarda el asegurado por medio del metodo guardarAsegurado accedido desde una instancia de ManejadorArchivo
	public void guardar(){
		archivo.guardarAsegurado(nombre, idSeguroSocial, edad, sexo, direccion);
	}

	//Revisa que los datos esten correctos y en caso contrario puedes corregir.
	public void confirmacion(){
		System.out.println(this.idSeguroSocial + " "+ this.nombre +
			" "+ this.edad + " " + this.sexo + " " + this.direccion);
		System.out.print("La Informacion es correcta (si o no)");
		String esCorrecta = new Scanner(System.in).next();

		if("si".equals(esCorrecta)){
			System.out.print("Ingresaste " + esCorrecta + " Presiona enter para continuar...");
			guardar();
		}else{
			System.out.print("Ingresaste " + esCorrecta);
			corregirDatos();
			guardar();
		}
	}

	/*
	*Ingresa un valor por consola y este
	*a su vez es enviado como parametro al metodo
	*buscarAsegurado() de la clase ManejadorArchivo
	*para realizar una busqueda de un Asegurado.
	**/
	public void buscar(){

		System.out.print("Ingresa el Nombre del Asegurado: ");
		String busqueda = new Scanner(System.in).nextLine();
		archivo.buscarAsegurado(busqueda);
	}

	/*
	*Ingresa un valor por consola y este
	*a su vez es enviado como parametro al metodo
	*eliminarAsegurado() de la clase ManejadorArchivo
	*para realizar una busqueda de un Asegurado y eliminarlo.
	**/
	public void eliminar(){

		System.out.print("Ingresa el Nombre del Asegurado que deseas eliminar: ");
		String busqueda = new Scanner(System.in).nextLine();
		archivo.eliminarAsegurado(busqueda);
	}

	//@return numbero Retorna un valor numerico positivo
	public int esNumero(){

		Scanner sc = new Scanner(System.in);
	    int numero;
	    do {
	        while (!sc.hasNextInt()) {
	            System.out.print("Ingresa un valor numerico: ");
	            sc.next();
	        }
	        numero = sc.nextInt();
	    } while (numero <= 0);

	   return numero;
	}

	//@return cadena Retorna una cadena de letras usando una expresion regular
	public String esCadena(){

		 Scanner sc = new Scanner(System.in);
	    while (!sc.hasNext("[A-Za-z]*")) {
	        System.out.print("Ingresa solo letras: ");
	        sc.next();
	    }
	    String cadena = sc.next();
	    return cadena;
	}

	//recibe un valor de consola para almacenar el nombre de un Asegurado
	public void setNombre(){
		this.nombre = esCadena();
	}
	
	//recibe un valor de consola para almacenar la edad de un Asegurado
	public void setEdad(){
		this.edad = esNumero();
	}

	//recibe un valor de consola para almacenar el idSeguroSocial de un Asegurado
	public void setIdSeguroSocial(){
		this.idSeguroSocial = esNumero();
	}

	//recibe un valor de consola para almacenar el sexo de un Asegurado
	public void setSexo(){
		this.sexo = esCadena();
	}

	//recibe un valor de consola para almacenar la direccion de un Asegurado
	public void setDireccion(){
		this.direccion = new Scanner(System.in).nextLine();
	}

}