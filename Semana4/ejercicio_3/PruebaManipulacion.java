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


public class PruebaManipulacion {

	private static final String RUTA_ARCHIVO = "c:\\users\\daniel\\documents\\base_datos.xml";

	public static void main(String[] args)
			throws ParserConfigurationException, TransformerConfigurationException, FileNotFoundException, 
			TransformerException, IOException, SAXException, XPathExpressionException {
		File file = new File(RUTA_ARCHIVO);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(file);

		Element root = document.getDocumentElement();

		XPath xpath = XPathFactory.newInstance().newXPath();
		Node asegurado = (Node) xpath.evaluate("//Asegurado[Nombre='jose landero']", document, XPathConstants.NODE);

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