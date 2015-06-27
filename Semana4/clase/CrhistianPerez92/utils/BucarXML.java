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

public class BucarXML{

	private static final String RUTA_ARCHIVO = "/home/peac/cursos/java_salud/curso-java/Semana4/clase/CrhistianPerez92/xml/DB.xml";

	public static void main(String[] args)throws ParserConfigurationException, TransformerConfigurationException, FileNotFoundException, TransformerException, IOException, SAXException, XPathExpressionException{
		File file = new File(RUTA_ARCHIVO);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(file);

		XPath xpath = XPathFactory.newInstance().newXPath();
		NodeList asegurados = (NodeList) xpath.evaluate("//asegurado[nombre='Crhistian Antonio Perez Arias']", document, XPathConstants.NODESET);
		for (int i =0; i<asegurados.getLength();i++){
			Node nombre = (Node) xpath.evaluate("nombre", asegurados.item(i), XPathConstants.NODE);
			System.out.println("Nombre: "+nombre.getTextContent());
		}

	}
}