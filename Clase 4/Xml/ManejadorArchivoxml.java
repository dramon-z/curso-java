package Xml;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.*;

import org.xml.sax.SAXException;

import org.w3c.dom.*;


public class ManejadorArchivoxml {

	private static final String RUTA_ARCHIVO = "C:\\Users\\SOPORTE\\Documents\\GitHub\\curso-java\\Clase 4\\Xml\\archivo.xml";
		
		public ManejadorArchivoxml(){
			pruebaxml();
		}

		public void pruebaxml() {
			File archivo = new File(RUTA_ARCHIVO);

			if (!archivo.exists()){
				try {
					crearArchivo();
				} catch (Exception e) {
					e.printStackTrace();
					System.exit(0);
				}
			}
		}

		public void crearArchivo()throws ParserConfigurationException, TransformerConfigurationException, FileNotFoundException, TransformerException, IOException {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.newDocument();

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
		}

		public void guardarAsegurado(String nombre, String appaterno, String apmaterno, Integer social, String sexo, String direccion, Integer c) 
			throws ParserConfigurationException, TransformerConfigurationException, FileNotFoundException, TransformerException, IOException, SAXException {
			File file = new File(RUTA_ARCHIVO);
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(file);

			Element root = document.getDocumentElement();
			Element asegurado = document.createElement("Asegurado");
			Element elementNombre = document.createElement("Nombre");
			Element elementAppat = document.createElement("Appaterno");
			Element elementApmat = document.createElement("Apmaterno");
			Element elementSocial = document.createElement("Social");
			Element elementSexo = document.createElement("Sexo");
			Element elementDirec = document.createElement("Direc");
			Element elementEdad = document.createElement("c");

			elementNombre.setTextContent(nombre);
			elementAppat.setTextContent(appaterno);
			elementApmat.setTextContent(apmaterno);
			elementSocial.setTextContent(social.toString());
			elementSexo.setTextContent(sexo);
			elementDirec.setTextContent(direccion);
			elementEdad.setTextContent(c.toString());

			asegurado.appendChild(elementNombre);
			asegurado.appendChild(elementAppat);
			asegurado.appendChild(elementApmat);
			asegurado.appendChild(elementSocial);
			asegurado.appendChild(elementSexo);
			asegurado.appendChild(elementDirec);
			asegurado.appendChild(elementEdad);

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
		}

		public void buscarAsegurado(String busqueda) 
			throws ParserConfigurationException, TransformerConfigurationException, FileNotFoundException, TransformerException, IOException, SAXException, XPathExpressionException {
			File file = new File(RUTA_ARCHIVO);
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(file);

			XPath xpath = XPathFactory.newInstance().newXPath();
			NodeList asegurados = (NodeList) xpath.evaluate("//Asegurado[Nombre='" + busqueda + "']", document, XPathConstants.NODESET);

			System.out.println("");
			System.out.println("");
			System.out.println("Resultado de la búsqueda: ");
			for (int i = 0; i < asegurados.getLength(); i++) {
				Node nombre = (Node) xpath.evaluate("Nombre", asegurados.item(i), XPathConstants.NODE);
				System.out.println("Nombre: " + nombre.getTextContent());

				Node numeroSeguroSocial = (Node) xpath.evaluate("NumeroSeguroSocial", asegurados.item(i), XPathConstants.NODE);
				System.out.println("Número Seguro Social: " + numeroSeguroSocial.getTextContent());

				Node edad = (Node) xpath.evaluate("Edad", asegurados.item(i), XPathConstants.NODE);
				System.out.println("Edad: " + edad.getTextContent());

				Node sexo = (Node) xpath.evaluate("Sexo", asegurados.item(i), XPathConstants.NODE);
				System.out.println("Sexo: " + sexo.getTextContent());

				Node direccion = (Node) xpath.evaluate("Direccion", asegurados.item(i), XPathConstants.NODE);
				System.out.println("Dirección: " + direccion.getTextContent());
			}
		}

		public void eliminarAsegurado(String busqueda) 
		throws ParserConfigurationException, TransformerConfigurationException, FileNotFoundException, TransformerException, IOException, SAXException, XPathExpressionException {
//*			File file = new File(RUTA_ARCHIVO);
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(file);

			XPath xpath = XPathFactory.newInstance().newXPath();

			Element root = document.getDocumentElement();

			Node asegurado = (Node) xpath.evaluate("//Asegurado[Nombre='" + busqueda + "']", document, XPathConstants.NODE);
			root.removeChild(asegurado);

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();

			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

			Source source = new DOMSource(document);
			FileOutputStream outputStream = new FileOutputStream(RUTA_ARCHIVO);
			Result result = new StreamResult(outputStream);
			transformer.transform(source, result);
			outputStream.close();
		}
/*

			System.out.println("");
			System.out.println("");
			System.out.println("Resultado de la búsqueda: ");
			for (int i = 0; i < asegurados.getLength(); i++) {
				Node nombre = (Node) xpath.evaluate("Nombre", asegurados.item(i), XPathConstants.NODE);
				System.out.println("Nombre: " + nombre.getTextContent());

				Node numeroSeguroSocial = (Node) xpath.evaluate("NumeroSeguroSocial", asegurados.item(i), XPathConstants.NODE);
				System.out.println("Número Seguro Social: " + numeroSeguroSocial.getTextContent());

				Node edad = (Node) xpath.evaluate("Edad", asegurados.item(i), XPathConstants.NODE);
				System.out.println("Edad: " + edad.getTextContent());

				Node sexo = (Node) xpath.evaluate("Sexo", asegurados.item(i), XPathConstants.NODE);
				System.out.println("Sexo: " + sexo.getTextContent());

				Node direccion = (Node) xpath.evaluate("Direccion", asegurados.item(i), XPathConstants.NODE);
				System.out.println("Dirección: " + direccion.getTextContent());
			}
		}

}

/*


					DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
					DocumentBuilder builder = factory.newDocumentBuilder();
					Document document = builder.newDocument();

					Element element = document.createElement("Asegurados");
					document.appendChild(element);

					TransformerFactory transformerFactory = TransformerFactory.newInstance();
					Transformer transformer = transformerFactory.newTransformer();

					transformer.setOutputProperty(OutputKeys.INDENT, "yes");
					transformer.setOutputProperty("http://xml.apache.org/xslt}indent-amount", "4");

					Source source = new DOMSource(document);
					FileOutputStream outputStream = new FileOutputStream(RUTA_ARCHIVO);
					Result result = new StreamResult(outputStream);
					transformer.transform(source, result);
					outputStream.close();
				} catch (Exception e) {
					e.printStackTrace();
					System.exit(0);
					}

				
			}


		}
		public void guardarxml(){
				File archivo = File(RUTA_ARCHIVO);
				public static void main(String[] args) {
					throws ParserConfigurationException, TransformerConfigurationException, FileNotFoundException, TransformerConfiguration,IOException, SAXException{
					
					DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
					DocumentBuilder builder = factory.newDocumentBuilder();
					Document document = builder.newDocument();

					Element root = document.getDocumentElement();
					Element asegurado = document.createElement("Asegurado");
					Element elementNombre = document.createElement("Nombre");

					elementNombre.setTextContent("Antonio Aguilar");
					asegurado.appendChild(asegurado);

					TransformerFactory transformerFactory = TransformerFactory.newInstance();
					Transformer transformer = transformerFactory.newTransformer();

					transformer.setOutputProperty(OutputKeys.INDENT, "yes");
					transformer.setOutputProperty("http://xml.apache.org/xslt}indent-amount", "4");

					Source source = new DOMSource(document);
					FileOutputStream outputStream = new FileOutputStream(RUTA_ARCHIVO);
					Result result = new StreamResult(outputStream);
					transformer.transform(source, result);
					outputStream.close();
			}	
		}

	}
}

*/