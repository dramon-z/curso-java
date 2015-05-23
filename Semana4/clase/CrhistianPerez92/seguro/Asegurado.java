package seguro;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.*;

import org.xml.sax.SAXException;

import java.util.Scanner;
import utils.ManageXML;

public class Asegurado{
	private String nombre = null;
	private String num_seguro = null;
	private Integer edad = null;
	private char sexo = ' ';
	private String direccion = null;
	
	public Asegurado(){
		
	}

	public void AgregarAsegurado()throws TransformerConfigurationException, FileNotFoundException, ParserConfigurationException, TransformerException, IOException, SAXException{
		System.out.println("Ingrese el nombre completo del Asegurado:");
		nombre = new Scanner(System.in).nextLine();
		System.out.println("Ingrese el numero de seguro social del Asegurado:");
		num_seguro = new Scanner(System.in).nextLine();
		System.out.println("Ingrese la edad del Asegurado:");
		edad = new Scanner(System.in).nextInt();
		System.out.println("Ingrese un caracter del sexo del Asegurado:\n  * M = Masculino\n  * F = Femenino");
		sexo = new Scanner(System.in).next().charAt(0);
		System.out.println("Ingrese la direccion del Asegurado:");
		direccion = new Scanner(System.in).nextLine();
		ImprimirConfirmacion("Registrar");
	}
	
	public void ImprimirConfirmacion(String text)throws TransformerConfigurationException, FileNotFoundException, ParserConfigurationException, TransformerException, IOException, SAXException{
		System.out.println("------------------------\n");
		System.out.println("Datos de acuse del registro del Asegurado \n         Para "+text+ "\n");
		System.out.println("Nombre: "+ nombre +"\nNum de Seguro: "+ num_seguro +"\nEdad: "+edad+"\nSexo:"+sexo+"\nDireccion:"+direccion);
		System.out.println("------------------------");
		System.out.println("¿La informacion es la correcta (si/no)?");
		String esCorrecta = new Scanner(System.in).nextLine();

		if("si".equals(esCorrecta)){
			ManageXML archivo = new ManageXML();
			archivo.GuardarAsegurado(nombre, num_seguro, edad, sexo, direccion);
		}else{
			System.out.println("Ingresaste " + esCorrecta + ", presiona enter para continuar");
		}
	}	

	public void ConsultarAsegurado()throws ParserConfigurationException, TransformerConfigurationException, FileNotFoundException, TransformerException, IOException, SAXException, XPathExpressionException{
		System.out.println("Ingrese el nombre completo del Asegurado a buscar:");
		nombre = new Scanner(System.in).nextLine();
		ManageXML archivo = new ManageXML();
		archivo.BuscarAsegurado(nombre);
	}

	public void EliminarAsegurado()throws ParserConfigurationException, TransformerConfigurationException, FileNotFoundException, TransformerException, IOException, SAXException, XPathExpressionException{
		System.out.println("Ingrese el nombre completo del Asegurado a eliminar:");
		nombre = new Scanner(System.in).nextLine();
		ManageXML archivo = new ManageXML();
		archivo.EliminarAsegurado(nombre);
	}
}