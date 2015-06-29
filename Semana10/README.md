#Java Fx

##Configuración de Eclipse

Hay que indicarle a Eclipse que use JDK 8 y también dónde se encuentra el ejecutable del Scene Builder:

1.	Abre las Preferencias de Eclipse (menú Window | Preferences y navega hasta Java | Installed JREs.

2.	Si no lo tienes el jre1.8 en la lista de JREs, entonces pulsa Add..., selecciona Standard VM y elige el Directorio de instalación (JRE Home directory) de tu JDK 8.

3.	Elimina otros JREs o JDKs de tal manera que **JDK 8 se convierta en la opción por defecto.**
![alt text][2]

4.	Navega a Java | Compiler. Establece el nivel de cumplimiento del **compilador en 1.8** (Compiler compliance level).
![alt text][3]

5.	Navega hasta Java | JavaFX. Especifica la ruta al ejecutable del Scene Builder.
![alt text][4]

[1]: https://raw.githubusercontent.com/dramon-z/curso-java/master/Semana10/img/1.png
[2]: https://raw.githubusercontent.com/dramon-z/curso-java/master/Semana10/img/2.png
[3]: https://raw.githubusercontent.com/dramon-z/curso-java/master/Semana10/img/3.png
[4]: https://raw.githubusercontent.com/dramon-z/curso-java/master/Semana10/img/4.png

##Contruyendo una Aplicacion con JavaFX

1. En Eclipse, selecciona **File > Others**

![alt text][5]

2. Seleccionamos JavaFx Project y damos next y le asignamos un nombre y damos finalizar.

![alt text][6]

3. Borramos nuestro paquete application y creamos un nuevo paquete llamado **mx.gob.tabasco.seguro**

![alt text][7]

4. Creamos nuestro Main en **New|Other|Javafx|classes|JavaFx Main Class**
![alt text][8]

5. Colocamos el nombre de nuestro main y damos finalizar
![alt text][9]

6. Creamos un paquete **mx.gob.tabasco.seguro.views**

[5]: https://raw.githubusercontent.com/dramon-z/curso-java/master/Semana10/img/5.png
[6]: https://raw.githubusercontent.com/dramon-z/curso-java/master/Semana10/img/6.png
[7]: https://raw.githubusercontent.com/dramon-z/curso-java/master/Semana10/img/7.png
[8]: https://raw.githubusercontent.com/dramon-z/curso-java/master/Semana10/img/8.png
[9]: https://raw.githubusercontent.com/dramon-z/curso-java/master/Semana10/img/9.png

##Crea el archivo FXML de diseño

1. Haz clic derecho el paquete views y crea un nuevo archivo FXML (**New | Other | FXML | New FXML**, y seleccione que sea un **BorderPane**

2. Click derecho al archivo **Rootlayout.fxml** Open with SceneBuilder

3. Cambie las dimenciones del **BorderPane** con la propiedades de **Pref Width**

4. Agregamos un Menu a nuestro **BorderPane** y salvamos