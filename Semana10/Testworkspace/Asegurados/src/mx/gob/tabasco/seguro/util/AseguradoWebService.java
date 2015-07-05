package mx.gob.tabasco.seguro.util;

import java.util.List;

import javax.json.stream.JsonGenerator;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;

import org.controlsfx.dialog.Dialogs;
import org.glassfish.jersey.jsonp.JsonProcessingFeature;

import mx.gob.tabasco.seguro.model.Asegurado;
import mx.gob.tabasco.seguro.model.AseguradoMessageBodyReader;
import javafx.collections.ObservableList;

public class AseguradoWebService {

	private static final String REST_SERVICE_URL = "http://localhost:8080/MiProyecto/api";
	
    public void loadAsegurados(ObservableList<Asegurado> aseguradoData){
        try {
        	
        	
            Client client = ClientBuilder.newBuilder().register(JsonProcessingFeature.class)
                    .property(JsonGenerator.PRETTY_PRINTING, true).build();
            client.register(AseguradoMessageBodyReader.class);
            GenericType<List<Asegurado>> aseguradoType = new GenericType<List<Asegurado>>() {};
            List<Asegurado> asegurados= client.target(REST_SERVICE_URL).path("/asegurados").request("application/json").get(aseguradoType);

            aseguradoData.clear();
            for(Asegurado a:asegurados){
                aseguradoData.add(a);           
            }
        } catch (Exception e) {
            Dialogs.create()
            .title("Error")
            .masthead("No se pudo cargar los asegurados de forma remota")
            .showException(e);
        }       
    }
    
	
}
