package mx.gob.tabasco.seguro.model;


import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;

@Provider
@Consumes({"application/json"})
public class AseguradoMessageBodyReader implements MessageBodyReader<List<Asegurado>>{

    @Override
    public boolean isReadable(Class<?> arg0, Type arg1, Annotation[] arg2,
            MediaType mt) {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public List<Asegurado> readFrom(Class<List<Asegurado>> arg0, Type arg1,
            Annotation[] arg2, MediaType mt,
            MultivaluedMap<String, String> arg4, InputStream in)
            throws IOException, WebApplicationException {
        if (mt.getType().equals("application") && mt.getSubtype().equals("json")) {
              Asegurado asegurado = new Asegurado();
              List<Asegurado> asegurados = new ArrayList<Asegurado>();
              JsonParser parser = Json.createParser(in);
              while (parser.hasNext()) {
                JsonParser.Event event = parser.next();
                switch (event) {
                  case START_OBJECT:
                    asegurado = new Asegurado();
                    break;
                  case END_OBJECT:
                    asegurados.add(asegurado);
                    break;
                  case KEY_NAME:
                    String key = parser.getString();
                    parser.next();
                    switch (key) {
                      case "id":
                          asegurado.setId(Integer.parseInt(parser.getString()));
                        break;
                      case "apellido":
                          asegurado.setApellido(parser.getString());
                        break;
                      case "nombre":
                          asegurado.setNombre(parser.getString());
                          break;
                      case "edad":
                          asegurado.setEdad(Integer.parseInt(parser.getString()));
                          break;
                      case "sexo":
                          asegurado.setSexo(parser.getString());
                          break;
                      case "numeroSeguroSocial":
                          asegurado.setNumeroSeguroSocial(parser.getString());
                          break;
                      default:
                        break;
                    }
                    break;
                  default:
                    break;
                }
              }
              return asegurados;
            }
            throw new UnsupportedOperationException("No suporta MediaType: " + mt);
    }

}
