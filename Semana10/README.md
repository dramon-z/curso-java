#Java Fx

##Link recomendados

 http://code.makery.ch/library/javafx-8-tutorial/es/

 http://docs.oracle.com/javafx/2/ui_controls/jfxpub-ui_controls.htm

 http://docs.oracle.com/javafx/scenebuilder/1/user_guide/startup-window.htm

 http://www.oracle.com/webfolder/technetwork/tutorials/obe/java/javafx_con_javaee_tutorial/javafx_javaee7.html

 http://docs.oracle.com/javase/8/javase-clienttechnologies.htm

 http://www.hascode.com/2013/12/jax-rs-2-0-rest-client-features-by-example/

##Configuración de Eclipse

Hay que indicarle a Eclipse que use JDK 8 y también dónde se encuentra el ejecutable del Scene Builder:

* Abre las Preferencias de Eclipse (menú Window | Preferences y navega hasta Java | Installed JREs.

* Si no lo tienes el jre1.8 en la lista de JREs, entonces pulsa Add..., selecciona Standard VM y elige el Directorio de instalación (JRE Home directory) de tu JDK 8.

* Elimina otros JREs o JDKs de tal manera que **JDK 8 se convierta en la opción por defecto.**
![alt text][2]

* Navega a Java | Compiler. Establece el nivel de cumplimiento del **compilador en 1.8** (Compiler compliance level).
![alt text][3]

* Navega hasta Java | JavaFX. Especifica la ruta al ejecutable del Scene Builder.
![alt text][4]

[1]: https://raw.githubusercontent.com/dramon-z/curso-java/master/Semana10/img/1.png
[2]: https://raw.githubusercontent.com/dramon-z/curso-java/master/Semana10/img/2.png
[3]: https://raw.githubusercontent.com/dramon-z/curso-java/master/Semana10/img/3.png
[4]: https://raw.githubusercontent.com/dramon-z/curso-java/master/Semana10/img/4.png

##Contruyendo una Aplicacion con JavaFX

* En Eclipse, selecciona **File > Others**

![alt text][5]

* Seleccionamos JavaFx Project y damos next y le asignamos un nombre y damos finalizar.

![alt text][6]

* Borramos nuestro paquete application y creamos un nuevo paquete llamado **mx.gob.tabasco.seguro**

![alt text][7]

* Creamos nuestro Main en **New|Other|Javafx|classes|JavaFx Main Class**

![alt text][8]

* Colocamos el nombre de nuestro main y damos finalizar

![alt text][9]

* Creamos un paquete **mx.gob.tabasco.seguro.views**

[5]: https://raw.githubusercontent.com/dramon-z/curso-java/master/Semana10/img/5.png
[6]: https://raw.githubusercontent.com/dramon-z/curso-java/master/Semana10/img/6.png
[7]: https://raw.githubusercontent.com/dramon-z/curso-java/master/Semana10/img/7.png
[8]: https://raw.githubusercontent.com/dramon-z/curso-java/master/Semana10/img/8.png
[9]: https://raw.githubusercontent.com/dramon-z/curso-java/master/Semana10/img/9.png

##Crea el archivo FXML de diseño

* Haz clic derecho el paquete views y crea un nuevo archivo FXML (**New | Other | FXML | New FXML**, y seleccione que sea un **BorderPane**

![alt text][10]

![alt text][11]

* Click derecho al archivo **Rootlayout.fxml** Open with SceneBuilder

![alt text][12]

* Cambie las dimenciones del **BorderPane** con la propiedades de **Pref Width**

![alt text][13]

![alt text][14]

* Agregamos un Menu a nuestro **BorderPane** y salvamos

![alt text][15]

##Agregando nuestro FXML a nuestra aplicacion

* En nuestra clase agregamos lo siguiente

MainApp.java
```java
 	private Stage primaryStage;
    private BorderPane rootLayout;

    private ObservableList<Asegurado> aseguradoData = FXCollections.observableArrayList();


    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Nuestro Tituto");

        initRootLayout();

        showPersonOverview();
    }

    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("views/Rootlayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
    public ObservableList<Asegurado> getAsegurdosData(){
        return aseguradoData;
    }
```

[10]: https://raw.githubusercontent.com/dramon-z/curso-java/master/Semana10/img/10.png
[11]: https://raw.githubusercontent.com/dramon-z/curso-java/master/Semana10/img/11.png
[12]: https://raw.githubusercontent.com/dramon-z/curso-java/master/Semana10/img/12.png
[13]: https://raw.githubusercontent.com/dramon-z/curso-java/master/Semana10/img/13.png
[14]: https://raw.githubusercontent.com/dramon-z/curso-java/master/Semana10/img/14.png
[15]: https://raw.githubusercontent.com/dramon-z/curso-java/master/Semana10/img/15.png

##Agregando Nuestro Catalogo de Asegurados

* Creamos nuestro FXML de asegurado en este caso seleccionamos **AnchorPane** y lo nombramos **AseguradoOverview**

![alt text][16]

* Damos click derecho a **AseguradoOverview.fxml** y lo abrimos con el **Scene Builder** y agustamos nuestro layout

![alt text][17]

* Agregamos un **Gridpanel** y colocamos **label** con los datos de asegurado

![alt text][18]

![alt text][19]

* Agregamos un **Tableview** y colocamos las columnas de nuestros asegurados

![alt text][20]
![alt text][21]

* Dentro del paquete views creamos una clase llamada **RootlayoutController** que contendra lo siguiente

RootlayoutController.java
```java
package mx.gob.tabasco.seguro.views;

import javafx.fxml.FXML;
import mx.gob.tabasco.seguro.MainApp;

public class RootlayoutController {


    private MainApp mainApp;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void handleAbrirAsegurado() {
        
    }

}
```

* En nuestro **MainApp** indicamos el controlador que va a utilizar nuestro **Rootlayout.fxml** para eso modificamos nuestro metodo **initRootLayout** y quedaria como sigue:

MainApp.java
```java
...
  public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("views/Rootlayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            
            // Give the controller access to the main app.
            RootlayoutController controller = loader.getController();
            controller.setMainApp(this);
            
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 ...
 ```

 * Abrimos el Archivo **Rootlayout.fxml** con el SceneBuilder y en el apartado de **Cotroller** le asignamos el controlador
 **RootlayoutController**

![alt text][22]

* En **hierarchy|BorderPane|Menu|** Cambiamos el nombre de edit por **Asegurado** y anexamos en el submenu **Abrir|Agregar** y **Eliminar** y seleccionamos **Abrir** y en el apartado **Code|Main|On Action** asignamos el metodo **handleAbrirAsegurado**

![alt text][23]


* Creamos la siguiente clase en views y la llamaremos **AseguradoOverviewController**

AseguradoOverviewController.java
```java
package mx.gob.tabasco.seguro.views;

import javafx.fxml.FXML;
import mx.gob.tabasco.seguro.MainApp;

public class AseguradoOverviewController {
    
    private MainApp mainApp;
    
    public AseguradoOverviewController() {
        
    }
    @FXML
    private void initialize() {
        
    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

}
```

* Vamos a nuestro **MainApp** en **showAsegurado()** y en el **AseguradoOverview.fxml** asigamos nuestro controlador

MainApp.java
```java
...
 public void showAsegurado(){
         try {
             FXMLLoader loader = new FXMLLoader();
             loader.setLocation(MainApp.class.getResource("views/AseguradoOverview.fxml"));
             AnchorPane aseguradoOverview = (AnchorPane) loader.load();
             
             AseguradoOverviewController controller = loader.getController();
             controller.setMainApp(this);
             
             rootLayout.setCenter(aseguradoOverview);
         } catch (IOException e) {
             e.printStackTrace();
         }
        
    }


...
```
![alt text][24]

[16]: https://raw.githubusercontent.com/dramon-z/curso-java/master/Semana10/img/16.png
[17]: https://raw.githubusercontent.com/dramon-z/curso-java/master/Semana10/img/17.png
[18]: https://raw.githubusercontent.com/dramon-z/curso-java/master/Semana10/img/18.png
[19]: https://raw.githubusercontent.com/dramon-z/curso-java/master/Semana10/img/19.png
[20]: https://raw.githubusercontent.com/dramon-z/curso-java/master/Semana10/img/20.png
[21]: https://raw.githubusercontent.com/dramon-z/curso-java/master/Semana10/img/21.png
[22]: https://raw.githubusercontent.com/dramon-z/curso-java/master/Semana10/img/22.png
[23]: https://raw.githubusercontent.com/dramon-z/curso-java/master/Semana10/img/23.png
[24]: https://raw.githubusercontent.com/dramon-z/curso-java/master/Semana10/img/24.png

## Llenar nuestra tabla de asegurados desde un webservice

* En raiz del proyecto agregamos la carpeta lib y colocamos las librerias que se encuentran en el git en **curso-java/Semana10/lib**

* En **AseguradoOverviewController** deblaramos las siguientes variables

AseguradoOverviewController.java
```java
...
 
    @FXML
    private TableView<Asegurado> aseguradoTable;
    @FXML
    private TableColumn<Asegurado, String> nombreColumn;
    @FXML
    private TableColumn<Asegurado, String> apellidosColumn;
    @FXML
    private TableColumn<Asegurado, Number> edadColumn;
    @FXML
    private TableColumn<Asegurado, String> sexoColumn;
    @FXML
    private TableColumn<Asegurado, String> numeroSeguroColumn;    
 
...
```

* Ahora abrimos el **AseguradoOverview.fxml** y asignamos las variables a nuestra tabla y columnas

![alt text][25]

* Agregamos un nuevo paquete llamado **mx.gob.tabasco.seguro.model** y creamos las clases **Asegurado.java** y **AseguradoMessageBodyReader.java**

Asegurado.java
```java

package mx.gob.tabasco.seguro.model;

import java.io.Serializable;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Asegurado implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private IntegerProperty id;
    private StringProperty apellido;
    private IntegerProperty edad;
    private StringProperty nombre;
    private StringProperty numeroSeguroSocial;
    private StringProperty sexo;
        
    public Asegurado() {
        this.id = new SimpleIntegerProperty();
        this.apellido = new SimpleStringProperty();
        this.edad = new SimpleIntegerProperty();
        this.nombre = new SimpleStringProperty();
        this.numeroSeguroSocial = new SimpleStringProperty();
        this.sexo = new SimpleStringProperty();
    }
    
    public IntegerProperty idProperty() {
        return this.id;
    }
    public int getId() {
        return this.idProperty().get();
    }
    public void setId(final int id) {
        this.idProperty().set(id);
    }
    public StringProperty apellidoProperty() {
        return this.apellido;
    }
    public java.lang.String getApellido() {
        return this.apellidoProperty().get();
    }
    public void setApellido(final java.lang.String apellido) {
        this.apellidoProperty().set(apellido);
    }
    public IntegerProperty edadProperty() {
        return this.edad;
    }
    public int getEdad() {
        return this.edadProperty().get();
    }
    public void setEdad(final int edad) {
        this.edadProperty().set(edad);
    }
    public StringProperty nombreProperty() {
        return this.nombre;
    }
    public java.lang.String getNombre() {
        return this.nombreProperty().get();
    }
    public void setNombre(final java.lang.String nombre) {
        this.nombreProperty().set(nombre);
    }
    public StringProperty numeroSeguroSocialProperty() {
        return this.numeroSeguroSocial;
    }
    public java.lang.String getNumeroSeguroSocial() {
        return this.numeroSeguroSocialProperty().get();
    }
    public void setNumeroSeguroSocial(final java.lang.String numeroSeguroSocial) {
        this.numeroSeguroSocialProperty().set(numeroSeguroSocial);
    }
    public StringProperty sexoProperty() {
        return this.sexo;
    }
    public java.lang.String getSexo() {
        return this.sexoProperty().get();
    }
    public void setSexo(final java.lang.String sexo) {
        this.sexoProperty().set(sexo);
    }
}

```

AseguradoMessageBodyReader.java
```java
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

```

* Creamos el paquete utils **mx.gob.tabasco.seguro.util** y creamos una clase llamada **AseguradoWebService**

AseguradoWebService.java
```java
package mx.gob.tabasco.seguro.util;

import java.util.List;

import javafx.collections.ObservableList;

import javax.json.stream.JsonGenerator;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;

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
}
```

* Creamos el metodo y **loadTablaAsegurado**

AseguradoOverviewController.java
```java
...

    private void loadTablaAsegurado(){
        aseguradoTable.setItems(aseguradoData);
        nombreColumn.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        apellidosColumn.setCellValueFactory(cellData -> cellData.getValue().apellidoProperty());
        edadColumn.setCellValueFactory(cellData -> cellData.getValue().edadProperty());
        sexoColumn.setCellValueFactory(cellData -> cellData.getValue().sexoProperty());
        numeroSeguroColumn.setCellValueFactory(cellData -> cellData.getValue().numeroSeguroSocialProperty());
    }
...
```

* Ahora agregamos las variable **private ObservableList<Asegurado> aseguradoData;** y en el metodo setMainApp agregamos nuestro inicializadores de seguro y nuestra tabla

AseguradoOverviewController.java
```java
...
    private ObservableList<Asegurado> aseguradoData;
...
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        aseguradoData = mainApp.getAsegurdosData();
        
        AseguradoWebService ws = new AseguradoWebService();
        ws.loadAsegurados(aseguradoData);
        loadTablaAsegurado();
    }
...
```


[25]: https://raw.githubusercontent.com/dramon-z/curso-java/master/Semana10/img/25.png

## Ajustando nuestra tabla y eventos de seleccion de la tabla

* Creamos las siguientes variables en nuestra clase AseguradoOverviewController

AseguradoOverviewController.java
```java
...
    @FXML
    private Label nombreLabel;
    @FXML
    private Label apellidosLabel;
    @FXML
    private Label edadLabel;
    @FXML
    private Label sexoLabel;
    @FXML
    private Label numeroSeguroLabel;
...
```

* Agregamos las variables a los ids a sus correspondientes label en **AseguradoOverview**

![alt text][26]

* Creamos el metodo **handleLabelSeletcAsegurado** en AseguradoOverviewController que asignara los valores a nuestro label

AseguradoOverviewController.java
```java
...
    private void handleLabelSeletcAsegurado(){
        Asegurado asegurado = aseguradoTable.getSelectionModel().getSelectedItem();
        nombreLabel.setText(asegurado.getNombre());
        apellidosLabel.setText(asegurado.getApellido());
        edadLabel.setText(Integer.toString(asegurado.getEdad()));
        sexoLabel.setText(asegurado.getSexo());
        numeroSeguroLabel.setText(asegurado.getNumeroSeguroSocial());
    }
...
```

* En  AseguradoOverviewController el metodo **loadTablaAsegurado** agregar la siguiente linea

AseguradoOverviewController.java
```java
...
private void loadTablaAsegurado(){
       ...
        aseguradoTable.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override 
            public void handle(MouseEvent event) {
                if (event.isPrimaryButtonDown() && event.getClickCount() == 1) {
                    handleLabelSeletcAsegurado();                   
                }
            }
        });
        ...
    }
...
```

* Para complementar en  AseguradoOverviewController el metodo **loadTablaAsegurado** ajustamos la columna de sexo para que nos muestre la informacion completa de la siguiente manera

AseguradoOverviewController.java
```java
...
    private void loadTablaAsegurado(){
        ...
        sexoColumn.setCellFactory(new Callback<TableColumn<Asegurado,String>, TableCell<Asegurado,String>>() {
            @Override
            public TableCell<Asegurado, String> call( TableColumn<Asegurado, String> param) {
                final TableCell<Asegurado, String> cell = new TableCell<Asegurado, String>() {
                    private Text text;
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (!isEmpty()) {
                            if(item.toString().trim().equals("M")){
                                text = new Text("Masculino");
                            }else{
                                text = new Text("Femenino");
                            }
                            setGraphic(text);
                        }else{
                            text = new Text("");
                            setGraphic(text);
                        }
                    }
                };
                return cell;
            }
        });
        ...
    }
...
```


[26]: https://raw.githubusercontent.com/dramon-z/curso-java/master/Semana10/img/26.png

## Agregando un asegurado

* Creamos un nuevo archivo fxml con el nombre de **AseguradoFormOverview.fxml** y agregamos los campos de asegurados en un **Gridpanel**, anexamos **TexlField** para los campos de input de texto, **ComboBox** para el sexo y dos botones uno para **Guardar** y otro para **Cancelar**

![alt text][27]

* Creamos una clase en views llamada **AseguradoFormOverviewController** que contendra las variables de nuestros textfield y metodos de nuestra ventana de guardado

AseguradoFormOverviewController.java
```java
package mx.gob.tabasco.seguro.views;


import mx.gob.tabasco.seguro.model.Asegurado;

import org.controlsfx.dialog.Dialogs;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AseguradoFormOverviewController {
    
    @FXML
    private TextField nombreField;
    @FXML
    private TextField apellidosField;
    @FXML
    private TextField edadField;
    @FXML
    private ComboBox<String> sexoComboBox;
    @FXML
    private TextField numeroSeguroField;
    
    private Stage dialogStage;
    private Asegurado asegurado;
    private boolean okClicked = false;

    private MainApp mainApp;
    private ObservableList<Asegurado> aseguradoData; 

    @FXML
    private void initialize(){
        sexoComboBox.setItems(FXCollections.observableArrayList(
                "Femenino",
                "Masculino"
            ));
        sexoComboBox.getSelectionModel().select(0);             
    }
    @FXML
    public void handleOK(){
        if(isInputValid()){
            okClicked = true;           
            dialogStage.close();
        }       
    }
    
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
    
    private boolean isInputValid() {
        String errorMessage = "";
        
         if (nombreField.getText() == null || nombreField.getText().length() == 0) {
                errorMessage += "El nombre es un valor requerido!\n"; 
            }
         if (apellidosField.getText() == null || apellidosField.getText().length() == 0) {
                errorMessage += "Los apellido son valores requerido!\n"; 
            }
         if (edadField.getText() == null || edadField.getText().length() == 0) {
                errorMessage += "La edad es un valor requerido!\n"; 
            }
         if (numeroSeguroField.getText() == null || numeroSeguroField.getText().length() == 0) {
                errorMessage += "El numero de seguro social es un valor requerido!\n"; 
            }
        
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Dialogs.create()
                .title("Campos Invalidos")
                .masthead("Porfavor corrija los campos invalidos")
                .message(errorMessage)
                .showError();
            return false;
        }
    }
    
    public void setDialogStage(Stage dialogStage){
        this.dialogStage = dialogStage;
    }
    public boolean isOkClicked(){       
        return okClicked;
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        aseguradoData = mainApp.getAsegurdosData();
    }
    
}
```

* Ahora en nuestra clase **RootlayoutController** agregamos el metodo **handleAgregarAsegurado** y lo asignamos en Rootlayout.fxml en el menu **Asegurado|Agregar** en **on Action**


RootlayoutController.java
```java
...    
    @FXML
    private void handleAgregarAsegurado() {
        boolean ok = mainApp.showFormAsegurado();        
    }
...
```

![alt text][28]

* En MainApp agregamos el metodo que nos mostrara la ventana para agregar nuestro asegurado

MainApp.java
```java
...
  public boolean showFormAsegurado(){
        try {
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("views/AseguradoFormOverview.fxml"));
            AnchorPane aseguradoFormOverview = (AnchorPane) loader.load();
            
            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Asegurado");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(aseguradoFormOverview);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            
            AseguradoFormOverviewController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setMainApp(this);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
            
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
...
```

* Agregamos una pequeña restriccion en el textfield de edad para que solo nos tome numeros en el campo agregamos el siguiente codigo en el inicialize en AseguradoFormOverviewController

AseguradoFormOverviewController.java
```java
...
    @FXML
    private void initialize(){
        ...
        edadField.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            public void handle( KeyEvent t ) {
                char ar[] = t.getCharacter().toCharArray();
                char ch = ar[t.getCharacter().toCharArray().length - 1];
                if (!(ch >= '0' && ch <= '9')) {                   
                   t.consume();
                }
            }
         });
        ...
    }
...
```

* Es hora de darle la funcionalidad de guardado a nuestro boton para ello creamos una instancia de asegurado si no esta inicializado en nuestra clase **AseguradoFormOverviewController** en el metodo **handleOk** y asignamos los valores de nuestros campos e instanciamos **AseguradoWebService** y le enviamos nuestro asegurado y aseguradoData

AseguradoFormOverviewController.java
```java
...
    @FXML
    public void handleOK(){
        if(isInputValid()){
            if(asegurado == null){
                asegurado = new Asegurado();
            }
            asegurado.setNombre(nombreField.getText());
            asegurado.setApellido(apellidosField.getText());
            asegurado.setEdad(Integer.parseInt(edadField.getText()));
            asegurado.setNumeroSeguroSocial(numeroSeguroField.getText());
            asegurado.setSexo(sexoComboBox.getValue()=="Masculino"?"M":"F");
            AseguradoWebService ws = new AseguradoWebService();
                        
            okClicked = ws.guardarAsegurado(asegurado,aseguradoData);
            if(okClicked){
                Dialogs.create()
                .title("Aviso")
                .masthead("El asegurado se guardo de forma correcta.")
                .message("Se registro con el id :"+asegurado.getId())
                .showInformation();
                dialogStage.close();
            }
            
        }       
    }
...
```

* En **AseguradoWebService.java** agregamos el metodo de guardarAsegurado y asignamos los parametros de nuestro asegurado para enviarlos al webservice

AseguradoWebService.java
```java
...
    public boolean guardarAsegurado(Asegurado asegurado,ObservableList<Asegurado> aseguradoData){
        try {
            Client client = ClientBuilder.newBuilder().register(JsonProcessingFeature.class)
                    .property(JsonGenerator.PRETTY_PRINTING, true).build();
            client.register(AseguradoMessageBodyReader.class);
            Form form = new Form();
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
            aseguradoData.add(asegurado);
            return true;
        } catch (Exception e) {
            Dialogs.create()
            .title("Error")
            .masthead("No se pudo cargar los asegurados de forma remota")
            .showException(e);
            return false;
        }   
        
    }
...
```

[27]: https://raw.githubusercontent.com/dramon-z/curso-java/master/Semana10/img/27.png
[28]: https://raw.githubusercontent.com/dramon-z/curso-java/master/Semana10/img/28.png

##Eliminar un asegurado

* En **AseguradoOverviewController** agregamos el metodo de **handleEliminar**, en el cual preguntaremos si existe un asegurado seleccionado y luego preguntamos una confirmacion, de ser afirmada la solicitud instaciamos **AseguradoWebService** y mandamos a llamar el metodo de **eliminarAsegurado** al ser exitosa la eliminacion eliminamos los registros de la tabla y de aseguradoData


AseguradoOverviewController.java
```java
...
    @FXML
    private void handleEliminar(){
        Asegurado asegurado = aseguradoTable.getSelectionModel().getSelectedItem();
        if(asegurado!=null){
            Action response = Dialogs.create()           
                    .title("Eliminar Asegurado")
                    .masthead("Se procedera a eliminar el assegurado"+asegurado.getNombre()+" "+asegurado.getApellido()+" con el No. de Seguro "+asegurado.getNumeroSeguroSocial()+" seleccionado.")
                    .message("¿Deseas continuar?")
                    .showConfirm();

            if (response == Dialog.Actions.YES) {
                
                AseguradoWebService ws = new AseguradoWebService();
                boolean ok = ws.eliminarAsegurado(asegurado);
                if(ok){
                    aseguradoTable.getItems().remove(aseguradoTable.getSelectionModel().getSelectedIndex());                   
                    
                    aseguradoData.remove(asegurado);
                    Dialogs.create()
                    .title("Aviso")
                    .masthead("Se elimino de forma correcta.")
                    .message("")
                    .showInformation();
                }
                
            } 
        }else{
            Dialogs.create()
            .title("Aviso")
            .masthead("No existe asegurado seleccionado.")
            .message("Porfavor seleccione un asegurado.")
            .showWarning();
        }
    }
...
```

* En **AseguradoWebService** agregamos el metodo **eliminarAsegurado** lo cual ara la conexion a nuestro web service para eliminar nuestro registro

AseguradoWebService.java
```java
...
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
...
```

* Abrimos el SceneBuilder nuestro archivo **AseguradoOverview.fxml** y agregamos el buton de eliminar y asingamos en **on Action|handleEliminar** 

![alt text][29]

[29]: https://raw.githubusercontent.com/dramon-z/curso-java/master/Semana10/img/29.png


## Editar asegurado

* En **AseguradoOverviewController** agregamos nuestro metodo **handleEditar** el cual preguntara si existe algun asegurado seleccionado antes de abrir nuestra ventanda de edicion

AseguradoOverviewController.java
```java
...
    @FXML
    private void handleEditar(){
        Asegurado asegurado = aseguradoTable.getSelectionModel().getSelectedItem();
        if(asegurado!=null){
            boolean ok = mainApp.showFormEditarAsegurado(asegurado);            
        }else{
            Dialogs.create()
            .title("Aviso")
            .masthead("No existe asegurado seleccionado.")
            .message("Porfavor seleccione un asegurado.")
            .showWarning();
        }
    }
...
```

* Agregamos en **MainApp** el metodo **showFormEditarAsegurado** el cual nos abrira la ventana de edicion de asegurados


MainApp.java
```java
...
   public boolean showFormEditarAsegurado(Asegurado asegurado){
        try {
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("views/AseguradoFormOverview.fxml"));
            AnchorPane aseguradoFormOverview = (AnchorPane) loader.load();
            
            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Asegurado");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(aseguradoFormOverview);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            
            AseguradoFormOverviewController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setMainApp(this);
            controller.setAsegurado(asegurado);
                
            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
            
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
...
```

* En **AseguradoFormOverviewController** agregamos el metodo setAsegurado para inicializar nuestros campos

AseguradoFormOverviewController.java
```java
...
    public void setAsegurado(Asegurado asegurado){
        this.asegurado = asegurado;
        nombreField.setText(asegurado.getNombre());
        apellidosField.setText(asegurado.getApellido());
        edadField.setText(Integer.toString(asegurado.getEdad()));
        sexoComboBox.getSelectionModel().select(asegurado.getSexo()=="M"?1:0);
        numeroSeguroField.setText(asegurado.getNumeroSeguroSocial());
    }
...
```

* Modificamos el metodo **guardarAsegurado** para enviar el parametro de id al web service

AseguradoWebService.java
```java
...
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
...
```

* Para terminar agregamos el boton editar al **AseguradoOverview.fxml** y asignamos el evento en **on Action|handleEditar**

![alt text][30]

[30]: https://raw.githubusercontent.com/dramon-z/curso-java/master/Semana10/img/30.png
