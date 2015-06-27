package utils;
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

public class ManageXML{
	private static final String RUTA_ARCHIVO = "/home/peac/cursos/java_salud/curso-java/Semana4/clase/CrhistianPerez92/xml/DB.xml";
	
	public ManageXML(){
		GenerarArchivo();
	}	
	
	public void GenerarArchivo(){
		File archivo = new File(RUTA_ARCHIVO);
		if(!archivo.exists()){
			try{
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document document = builder.newDocument();

				Element element = document.createElement("Asegurados");
				document.appendChild(element);

				TransformerFactory transformerfactory = TransformerFactory.newInstance();
				Transformer transformer  = transformerfactory.newTransformer();

				transformer.setOutputProperty(OutputKeys.INDENT, "yes");
				transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

				Source source = new DOMSource(document);
				FileOutputStream outputstream = new FileOutputStream(RUTA_ARCHIVO);
				Result result = new StreamResult(outputstream);
				transformer.transform(source, result);
				outputstream.close();
			}catch (Exception e) {
				e.printStackTrace();
				System.exit(0);
			}
		}
	}

	public void GuardarAsegurado(String nombre, String num_social, Integer edad, char sexo, String domicilio)throws ParserConfigurationException, TransformerConfigurationException, FileNotFoundException, TransformerException, IOException, SAXException{
		File file = new File(RUTA_ARCHIVO);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(file);

		Element aseguradosElement = document.getDocumentElement();
		Element asegurado = document.createElement("asegurado");
		Element nombreElement = document.createElement("nombre");
		Element numSocialElement = document.createElement("num_social");
		Element edadElement = document.createElement("edad");
		Element sexoElement = document.createElement("sexo");
		Element domicilioElement = document.createElement("domicilio");
		nombreElement.setTextContent(nombre);
		numSocialElement.setTextContent(num_social);
		edadElement.setTextContent(String.valueOf(edad));
		sexoElement.setTextContent(String.valueOf(sexo));
		domicilioElement.setTextContent(domicilio);

		asegurado.appendChild(nombreElement);
		asegurado.appendChild(numSocialElement);
		asegurado.appendChild(edadElement);
		asegurado.appendChild(sexoElement);
		asegurado.appendChild(domicilioElement);

		aseguradosElement.appendChild(asegurado);
		

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

	public void BuscarAsegurado(String bus)
		throws ParserConfigurationException, TransformerConfigurationException, FileNotFoundException, TransformerException, IOException, SAXException, XPathExpressionException{
		File file = new File(RUTA_ARCHIVO);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(file);

		XPath xpath = XPathFactory.newInstance().newXPath();
		NodeList asegurados = (NodeList) xpath.evaluate("//asegurado[nombre='"+bus+"']", document, XPathConstants.NODESET);
		for (int i =0; i<asegurados.getLength();i++){
			
			Node nombre = (Node) xpath.evaluate("nombre", asegurados.item(i), XPathConstants.NODE);
			System.out.println("Nombre: "+nombre.getTextContent());
			
			Node num_social = (Node) xpath.evaluate("num_social", asegurados.item(i), XPathConstants.NODE);
			System.out.println("Num Social: "+num_social.getTextContent());
			
			Node edad = (Node) xpath.evaluate("edad", asegurados.item(i), XPathConstants.NODE);
			System.out.println("Edad: "+edad.getTextContent());
			
			Node domicilio = (Node) xpath.evaluate("domicilio", asegurados.item(i), XPathConstants.NODE);
			System.out.println("domicilio: "+domicilio.getTextContent());
		}
	}

	public void EliminarAsegurado(String bus)
		throws ParserConfigurationException, TransformerConfigurationException, FileNotFoundException, TransformerException, IOException, SAXException, XPathExpressionException{
		File file = new File(RUTA_ARCHIVO);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(file);

		Element aseguradosElement = document.getDocumentElement();

		XPath xpath = XPathFactory.newInstance().newXPath();
		Node asegurado = (Node) xpath.evaluate("//asegurado[nombre='"+bus+"']", document, XPathConstants.NODE);
		aseguradosElement.removeChild(asegurado);

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