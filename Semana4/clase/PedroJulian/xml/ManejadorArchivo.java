package xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

public class ManejadorArchivo {

	private static final String RUTA_ARCHIVO = "c:\\users\\Maricruz\\documents\\base_datos.xml";

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

	public void crearArchivo() throws ParserConfigurationException, TransformerConfigurationException, FileNotFoundException, TransformerException {
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
		Result result = new StreamResult(new FileOutputStream(RUTA_ARCHIVO));
		transformer.transform(source, result);

		System.out.print("El archivo de base de datos no existía y lo creamos, por favor presione enter para continuar");
	}

}