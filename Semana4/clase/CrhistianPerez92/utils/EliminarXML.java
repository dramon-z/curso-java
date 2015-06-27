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

public class EliminarXML{
	private static final String RUTA_ARCHIVO = "/home/peac/cursos/java_salud/curso-java/Semana4/clase/CrhistianPerez92/xml/CrhistianPerez92.xml";

	public static void main(String[] args)throws ParserConfigurationException, TransformerConfigurationException, FileNotFoundException, TransformerException, IOException, SAXException{
		File file = new File(RUTA_ARCHIVO);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(file);

		Element aseguradosElement = document.getDocumentElement();
		Element asegurado = document.createElement("asegurado");
		Element nombreElement = document.createElement("nombre");
		
		nombreElement.setTextContent("jose");

		asegurado.appendChild(nombreElement);

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
}