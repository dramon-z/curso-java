package Xml;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import javax.xml.xpath.*;

import org.w3c.dom.*;


public class PruebaManipulacion{
	private static final String RUTA_ARCHIVO = "C:\\Users\\SOPORTE\\Documents\\GitHub\\curso-java\\Clase 4\\Xml\\base_datos.xml";
	
	public static void main(String[] args) {
			throws ParserConfigurationException, TransformerConfigurationException, FileNotFoundException, TransformerConfiguration,IOException, SAXException{
			File file = File(RUTA_ARCHIVO);
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