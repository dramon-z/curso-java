package mx.gob.tabasco.seguro.util;

import java.util.List;

import javafx.collections.ObservableList;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.stream.JsonGenerator;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import mx.gob.tabasco.seguro.model.Asegurado;
import mx.gob.tabasco.seguro.model.AseguradoMessageBodyReader;

import org.controlsfx.dialog.Dialogs;
import org.glassfish.jersey.jsonp.JsonProcessingFeature;

public class AseguradoWebService {
	
	private static final String REST_SERVICE_URL = "http://localhost:8080/MiProyecto/api";
	
	public void loadAsegurados(ObservableList<Asegurado> aseguradoData){
		/**Client client = ClientBuilder.newBuilder().register(JsonProcessingFeature.class)
	                .property(JsonGenerator.PRETTY_PRINTING, true).build();
	    WebTarget path = client.target(REST_SERVICE_URL);
		JsonArray data = path.request().get(JsonArray.class);		
		int arrSize = data.size();
		for (int i = 0; i < arrSize; ++i) {
			JsonObject o = data.getJsonObject(i);
			System.out.println(o.get("nombre"));
		}**/
		
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
	public boolean eliminarAsegurado(Asegurado asegurado){
		try {
			Client client = ClientBuilder.newBuilder().register(JsonProcessingFeature.class)
			        .property(JsonGenerator.PRETTY_PRINTING, true).build();
			client.register(AseguradoMessageBodyReader.class);
			
			JsonObject aseguradoResult = client.target(REST_SERVICE_URL).path("/asegurados/eliminar/{id}")
			.resolveTemplate("id", asegurado.getId()).request("application/json").delete(JsonObject.class);
			System.out.println(aseguradoResult.get("success"));
			return aseguradoResult.get("success").toString().equals("true")?true:false;
		} catch (Exception e) {
			Dialogs.create()
            .title("Error")
            .masthead("No se pudo cargar los asegurados de forma remota")
            .showException(e);
			return false;
		}	
		
	}
	
	public boolean guardarAsegurado(Asegurado asegurado,ObservableList<Asegurado> aseguradoData){
		try {
			Client client = ClientBuilder.newBuilder().register(JsonProcessingFeature.class)
			        .property(JsonGenerator.PRETTY_PRINTING, true).build();
			Form form = new Form();
			Integer id = asegurado.getId();
			if(id !=0){
				form.param("id",Integer.toString(asegurado.getId()));
			}			
			form.param("nombre",asegurado.getNombre());
			form.param("apellido", asegurado.getApellido());
			form.param("sexo", asegurado.getSexo());
			form.param("edad", Integer.toString(asegurado.getEdad()));
			form.param("numeroSeguroSocial", asegurado.getNumeroSeguroSocial());

			JsonObject aseguradoResult = client
					.target(REST_SERVICE_URL).path("/asegurados/guardar")
					.request("application/json")
					.post(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED_TYPE),JsonObject.class);
			asegurado.setId(Integer.parseInt(aseguradoResult.get("id").toString()));
			
			if(id ==0){
				aseguradoData.add(asegurado);
			}			
			return true;
		} catch (Exception e) {
			Dialogs.create()
            .title("Error")
            .masthead("No se pudo cargar los asegurados de forma remota")
            .showException(e);
			return false;
		}	
		
	}
}
