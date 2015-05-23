import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundExcepcion;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;;
import javax.xml.transform.stream.StreamResult;

import org.w3w.dom.*;

public class ArchivoXML{
	
	public static final String RUTA_ARCHIVO = "/home/peac/cursos/java_salud/curso-java/Semana4/clase/CrhistianPerez92/xml/CrhistianPerez92.xml";	
	
	public static void main(String[] args){
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
				transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount");

				Source source = new DOMSource(document);
				FileOutputStream outputstream = new FileOutputStream(RUTA_ARCHIVO);
				Result result = new StreamResult(outputstream);
				transformer.transform(source, result);
				outputstream.close();
			} catch(Exception e){
				e.printStrackTrace();
				System.exit(0);
			}
		}
	}

	public void CrearArchivo(String nombre){

	}

}