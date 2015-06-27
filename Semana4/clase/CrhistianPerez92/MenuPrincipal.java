import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.*;
import org.xml.sax.SAXException;
import java.util.Scanner;
import seguro.Asegurado;

public class MenuPrincipal{
	
	public static void main(String[] args)throws TransformerConfigurationException, FileNotFoundException, ParserConfigurationException, TransformerException, IOException, SAXException, XPathExpressionException{
		System.out.println("¡Bienvenido al sistema de asegurados de la secretaria de salud!");
		MenuPrincipal menu = new MenuPrincipal();
		menu.ImprimirMenu();
		
		
	}

	public void ImprimirMenu() throws TransformerConfigurationException, FileNotFoundException, ParserConfigurationException, TransformerException, IOException, SAXException, XPathExpressionException{
			System.out.println("------------------------");
			System.out.println("Menu de opciones:");
			System.out.println("1.- Agregar asegurados\n2.- Consultar asegurados\n3.- Eliminar asegurados\n4.- Salir");
			System.out.println("------------------------");
			System.out.println("Ingrese la opcion deseada:");
			Integer opcion = new Scanner(System.in).nextInt();
			OpcionesMenu(opcion);
	}

	public void OpcionesMenu(Integer opcion) throws ParserConfigurationException, TransformerConfigurationException, FileNotFoundException, TransformerException, IOException, SAXException, XPathExpressionException{
		
		switch(opcion){
			case 1:{
				
				Asegurado asegurado = new Asegurado();
				
				asegurado.AgregarAsegurado();
				System.out.println("Presione enter para regresar al menu anterior");
				new Scanner(System.in).nextLine();
				break;
			}
			case 2:{
				Asegurado asegurado = new Asegurado();
				asegurado.ConsultarAsegurado();
				System.out.println("Presione enter para regresar al menu anterior");
				new Scanner(System.in).nextLine();
				break;
			}
			case 3:{
				Asegurado asegurado = new Asegurado();
				asegurado.EliminarAsegurado();
				System.out.println("Presione enter para regresar al menu anterior");
				new Scanner(System.in).nextLine();
				break;
			}

			case 4:{
				System.out.println("Su opcion elegida es: Salir");
				System.out.println("¡Adios vuelva pronto!");
				System.exit(0);
				break;
			}
			default:{
				System.out.println("Debe de elegir una opcion valida");
				break;
			}
		}

		ImprimirMenu();

	}
	
}