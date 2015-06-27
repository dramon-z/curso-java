import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

public class PruebaXml{
	private static final String RUTA_ARCHIVO = "C:\\Users\\SOPORTE\\Documents\\GitHub\\curso-java\\Clase 4\\Xml\\archivo.xml";

	public static void main(String[] args) {
		File archivo = new File(RUTA_ARCHIVO);

		if (!archivo.exists()){
			try {
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document docuemnt = builder.newDocument();

				Element element = document.createElement("Asegurados");
				document.appendChild(element);

				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();

				transformer.setOutputProperty(OutputKeys.IDENT, "yes");
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

}

