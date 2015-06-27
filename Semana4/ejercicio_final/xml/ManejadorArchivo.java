package xml;

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

public class ManejadorArchivo {

	private static final String RUTA_ARCHIVO = "c:\\users\\joselandero\\documents\\base_datos.xml";

	public ManejadorArchivo() {
		verificarExistencia();
	}

	public void verificarExistencia() {
		File archivo = new File(RUTA_ARCHIVO);

		if (!archivo.exists()) {
			try {
				crearArchivo();
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(0);
			}
		}
	}

	public void crearArchivo() throws ParserConfigurationException, TransformerConfigurationException, FileNotFoundException, TransformerException, IOException {
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

	public void guardarAsegurado(String nombreAsegurado, String numeroSeguroSocial, Integer edad, String sexo, String direccion) 
			throws ParserConfigurationException, TransformerConfigurationException, FileNotFoundException, TransformerException, IOException, SAXException {
		File file = new File(RUTA_ARCHIVO);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(file);

		Element root = document.getDocumentElement();
		Element asegurado = document.createElement("Asegurado");
		Element elementNombre = document.createElement("Nombre");
		Element elementNss = document.createElement("NumeroSeguroSocial");
		Element elementEdad = document.createElement("Edad");
		Element elementSexo = document.createElement("Sexo");
		Element elementDireccion = document.createElement("Direccion");

		elementNombre.setTextContent(nombreAsegurado);
		elementNss.setTextContent(numeroSeguroSocial);
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

		System.out.println("");
		System.out.print("Presione enter para continuar...");
	}

	public void eliminarAsegurado(String busqueda)
			throws ParserConfigurationException, TransformerConfigurationException, FileNotFoundException, TransformerException, IOException, SAXException, XPathExpressionException {
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

}