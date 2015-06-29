#Java Fx

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

[16]: https://raw.githubusercontent.com/dramon-z/curso-java/master/Semana10/img/16.png
[17]: https://raw.githubusercontent.com/dramon-z/curso-java/master/Semana10/img/17.png
[18]: https://raw.githubusercontent.com/dramon-z/curso-java/master/Semana10/img/18.png
[19]: https://raw.githubusercontent.com/dramon-z/curso-java/master/Semana10/img/19.png
[20]: https://raw.githubusercontent.com/dramon-z/curso-java/master/Semana10/img/20.png
[21]: https://raw.githubusercontent.com/dramon-z/curso-java/master/Semana10/img/21.png
[22]: https://raw.githubusercontent.com/dramon-z/curso-java/master/Semana10/img/22.png
[23]: https://raw.githubusercontent.com/dramon-z/curso-java/master/Semana10/img/23.png
