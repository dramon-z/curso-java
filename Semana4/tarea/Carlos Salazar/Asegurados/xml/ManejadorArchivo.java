package xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.*;

import org.xml.sax.SAXException;

import org.w3c.dom.*;

public class ManejadorArchivo{

	private static final String RUTA_ARCHIVO = "c:\\asegurados.xml";
	private File file;
	private DocumentBuilderFactory factory;
	private DocumentBuilder builder;
	private Document document;

	public ManejadorArchivo(){
		verificarExistencia();
	}

	public void verificarExistencia(){

		file = new File(RUTA_ARCHIVO);
		if(!file.exists()){
				try{
					factory = DocumentBuilderFactory.newInstance();
					builder = factory.newDocumentBuilder();
					document = builder.newDocument();

					Element element = document.createElement("Asegurados");
					document.appendChild(element);

					TransformerFactory transformerFactory = TransformerFactory.newInstance();
					Transformer transformer = transformerFactory.newTransformer();

					transformer.setOutputProperty(OutputKeys.INDENT, "yes");
					transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

					Source source = new DOMSource(document);
					FileOutputStream outputStream = new FileOutputStream(RUTA_ARCHIVO);
					Result result = new StreamResult(outputStream);
					transformer.transform(source, result);
					outputStream.close();
			}catch(Exception e){
				e.printStackTrace();
				System.exit(0);
			}
		}
	}

	public void guardarAsegurado(String nombreAsegurado, Integer numeroSeguroSocial,
									Integer edad, String sexo, String direccion) {

		try{

			file = new File(RUTA_ARCHIVO);
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			document = builder.parse(file);

			Element root = document.getDocumentElement();
			Element asegurado = document.createElement("Asegurado");
			Element elementNombre = document.createElement("Nombre");
			Element elementNss = document.createElement("NumeroSeguroSocial");
			Element elementEdad = document.createElement("Edad");
			Element elementSexo = document.createElement("Sexo");
			Element elementDireccion = document.createElement("Direccion");

			elementNombre.setTextContent(nombreAsegurado);
			elementNss.setTextContent(numeroSeguroSocial.toString());
			elementEdad.setTextContent(edad.toString());
			elementSexo.setTextContent(sexo);
			elementDireccion.setTextContent(direccion);

			asegurado.appendChild(elementNombre);
			asegurado.appendChild(elementNss);
			asegurado.appendChild(elementEdad);
			asegurado.appendChild(elementSexo);
			asegurado.appendChild(elementDireccion);

			root.appendChild(asegurado);

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();

			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

			Source source = new DOMSource(document);
			FileOutputStream outputStream = new FileOutputStream(RUTA_ARCHIVO);
			Result result = new StreamResult(outputStream);
			transformer.transform(source, result);
			outputStream.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}

	public void buscarAsegurado(String busqueda){
		try{

			file = new File(RUTA_ARCHIVO);
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			document = builder.parse(file);

			XPath xpath = XPathFactory.newInstance().newXPath();
			NodeList asegurados = (NodeList) xpath.evaluate("//Asegurado[Nombre='"+busqueda+"']", document, XPathConstants.NODESET);

			for(int i = 0; i < asegurados.getLength(); i++){
				
				Node nombre = (Node) xpath.evaluate("Nombre", asegurados.item(i), XPathConstants.NODE);
				Node seguro = (Node) xpath.evaluate("NumeroSeguroSocial", asegurados.item(i), XPathConstants.NODE);
				Node edad = (Node) xpath.evaluate("Edad", asegurados.item(i), XPathConstants.NODE);
				Node sexo = (Node) xpath.evaluate("Sexo", asegurados.item(i), XPathConstants.NODE);
				Node direccion = (Node) xpath.evaluate("Direccion", asegurados.item(i), XPathConstants.NODE);

				System.out.print(nombre.getTextContent() +" "+ seguro.getTextContent()+" "+
					edad.getTextContent()+" "+sexo.getTextContent()+" "+direccion.getTextContent());
			}

			System.out.println("");
			System.out.println("Presione enter para continuar");

		}catch(Exception e){

		}
	}

	public void eliminarAsegurado(String busqueda) {
		
		try{

			file = new File(RUTA_ARCHIVO);
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			document = builder.parse(file);

			XPath xpath = XPathFactory.newInstance().newXPath();
			NodeList asegurados = (NodeList) xpath.evaluate("//Asegurado[Nombre='" + busqueda + "']", document, XPathConstants.NODESET);

			System.out.println(" ");
			System.out.println("Resultado de la busqueda: ");

			NodeList nodes = document.getElementsByTagName("Asegurado");

			for (int i = 0; i < asegurados.getLength(); i++) {
				
				Node nombre = (Node) xpath.evaluate("Nombre", asegurados.item(i), XPathConstants.NODE);
				Node seguro = (Node) xpath.evaluate("NumeroSeguroSocial", asegurados.item(i), XPathConstants.NODE);
				Node edad = (Node) xpath.evaluate("Edad", asegurados.item(i), XPathConstants.NODE);
				Node sexo = (Node) xpath.evaluate("Sexo", asegurados.item(i), XPathConstants.NODE);
				Node direccion = (Node) xpath.evaluate("Direccion", asegurados.item(i), XPathConstants.NODE);

				System.out.println(nombre.getTextContent() +" "+ seguro.getTextContent()+" "+
					edad.getTextContent()+" "+sexo.getTextContent()+" "+direccion.getTextContent());

				System.out.println("¿Esta seguro de eliminar los datos? (si/no)");
				String borrar = new Scanner(System.in).nextLine();
				
				Element nombreAsegurado = (Element)asegurados.item(i);
				if("si".equals(borrar)){		       
			        nombreAsegurado.getParentNode().removeChild(nombreAsegurado);
				}else{
					break;
				}
			}

	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();

			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

			Source source = new DOMSource(document);
			FileOutputStream outputStream = new FileOutputStream(RUTA_ARCHIVO);
			Result result = new StreamResult(outputStream);
			transformer.transform(source, result);
			outputStream.close();		

			System.out.println("");
			System.out.print("Presione enter para continuar...");

		}catch(Exception e){

		}
	}


}