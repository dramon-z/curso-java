#Spring


##Configuracion basica

* Creamos el proyecto como Dynamic web proyect

* Configuramos nuestro web.xml, se encuentra en /WEB-INF/web.xml

web.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://xmlns.jcp.org/xml/ns/javaee" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd" id="WebApp_ID" version="3.1">	  
  <display-name>MiProyecto</display-name>
  <!-- The front controller of this Spring Web application, responsible for handling all application requests -->
	<servlet>
		<servlet-name>springDispatcherServlet</servlet-name>
		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
		<init-param>
			<param-name>contextConfigLocation</param-name>
			<!-- **Se asigna la ubicacion del context**-->
			<param-value>/WEB-INF/web-context.xml</param-value>
		</init-param>
		<load-on-startup>1</load-on-startup>
	</servlet>
	<!-- Map all requests to the DispatcherServlet for handling -->
	<servlet-mapping>
		<servlet-name>springDispatcherServlet</servlet-name>
		<!-- Se asigna la ubicacion de la url a la que respode nuestra peticiones-->
		<url-pattern>/</url-pattern>
	</servlet-mapping>
</web-app>
```

* Se configura el /WEB-INF/web-context.xml

web-context.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xmlns:mvc="http://www.springframework.org/schema/mvc"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd
		http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc.xsd">
	<!--SE INDICA EL PACKAGE QUE CONTIENE NUESTROS CONTROLADOR-->
	<context:component-scan base-package="mx.gob.tabasco.spring.controllers"></context:component-scan>
	<!--SE INDICA QUE SE TRABAJARA CON ANOTACIONES EL MVC-->
	<mvc:annotation-driven></mvc:annotation-driven>	
	<!--SE INDICA LA UBICACION DE NUESTRAS VISTAS -->
	<bean class="org.springframework.web.servlet.view.ContentNegotiatingViewResolver">
		<property name="viewResolvers">
			<list>
				<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
					<property name="prefix" value="/WEB-INF/views/"></property>
					<property name="suffix" value=".jsp"></property>
				</bean>
			</list>
		</property>
	</bean>
</beans>
```

* Creamos una clase Controlador en nuestro paquete mx.gob.tabasco.spring.controllers

IndexController.java
```java
@Controller //ESTA ANOTACION INDICA QUE NUESTRA CLASE ES UN CONTROLADOR
@RequestMapping(value="/") //INDICAMOS NUESTRA RUTA A LA CUAL RESPONDE ESTE CONTROLADOR
public class IndexController {		
	@RequestMapping(method=RequestMethod.GET)//SE DEFININE EL TIPO DE PETICON QUE RESPONDE NUESTRO METODO
	public String indexAction(){
		return "index";//SE INDICA LA UBICACION DE NUESTRA VISTA
	}
}
```

* Creamos nuestra vista en en /WEB-INF/views/index.jsp

index.jsp
```jsp
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<h1>Hola mundo</h1>
</body>
</html>
```

## Envio de parametros desde la vista

* se agrega el argumento de tipo Model y se asigna nuestro prametro en el controlador

IndexController.java
```java
...
	@RequestMapping(method=RequestMethod.GET)
	public String indexAction(Model model){
		model.addAttribute("nombre","mi nombre");
		return "index";
	}
...
```

* Se agrega la variable en nuestro jsp

index.jsp
```jsp
	...
	<h1>Hola ${nombre}</h1>
	...
```
## Recibir parametros en mi vista

* Recibir parametros por url ejemplo: /miweb/?nombre=daniel

* Se tiene que agregar la notacion @RequestParam para agregar el parametro
* Los atributos que pude tener @RequestParam
	
	* value: el nombre por el cual debemos enviar el parametro
	* required: indicamos si es requerido o no 
	* defaultValue: se le asigna un valor por default	

IndexController.java
```java
...
	@RequestMapping(method=RequestMethod.GET)
	public String indexAction(Model model,@RequestParam(value="nombre",required=false,defaultValue="Desconocido") String nombre){
		model.addAttribute("nombre",nombre);
		return "index";
	}
...
```


* Recibir mas de un parametro, solo se enlista en los argumentos

IndexController.java
```java
...
	@RequestMapping(method=RequestMethod.GET)
	public String indexAction(Model model,
			@RequestParam(value="nombre",required=false,defaultValue="Desconocido") String nombre,
			@RequestParam Integer edad,//POR DEFUALT SON REQUERIDO SI NO SE LE INDICA LO CONTRARIO
			@RequestParam String ciudad){
		model.addAttribute("nombre",nombre);
		model.addAttribute(edad);//TOMA EL NOMBRE DE LA VARIABLE PARA SE USADO EN EL CONTEXTO
		model.addAttribute(ciudad);
		return "index";
	}
...
```
index.jsp
```html
...
	<h1>Hola ${nombre}, tiene ${edad}, de la ciudad ${ciudad}</h1>
...
```

## Trabajando con formularios 

* Realizamos los siguientes cambios en nuestros html index.jsp 

	* creamos un formulario donde capturemos los que le enviaremos a la vista y lo enviamos por "POST"

index.jsp
```html
...
<form action="" method="post">
		<table>
			<tr>
				<td>Nombre:</td>
				<td><input type="text" name="nombre"/></td>
			</tr>
			<tr>
				<td>Edad:</td>
				<td><input type="text" name="edad"/></td>
			</tr>
			<tr>
				<td>Ciudad</td>
				<td><input type="text" name="ciudad"/></td>
			</tr>
			<tr>
				<td></td>
				<td><td><button type="submit">Guardar</button></td></td>
			</tr>
		</table>
		</form>
...
```

* Creamos un nuevo jsp con el nombre resultado en el cual recibiremos lo que enviamos

resultado.jsp
```jsp
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Resultado</h1>
		<table>
			<tr>
				<td>Nombre:</td>
				<td>${nombre}</td>
			</tr>
			<tr>
				<td>Edad:</td>
				<td>${edad}</td>
			</tr>
			<tr>
				<td>Ciudad</td>
				<td>${ciudad}</td>
			</tr>
		</table>
</body>
</html>

```

* Modificamos nuestros metodods dentro de la clase IndexController
	
	* Creamos un metodo formAction que recibira nuestros parametros por "POST" y lo enviara al nuevo resultado.jsp

IndexController.java
```java
...
	@RequestMapping(method=RequestMethod.GET)
	public String indexAction(Model model){
		return "index";
	}	
	@RequestMapping(method=RequestMethod.POST)
	public String formAction(Model model,
			@RequestParam String nombre,
			@RequestParam Integer edad,
			@RequestParam String ciudad){
		model.addAttribute("nombre",nombre);
		model.addAttribute("edad",edad);
		model.addAttribute("ciudad",ciudad);
		return "resultado";
	}
...
```

##Manejar parametros mediante un Plain Old Java Object(POJO)

* Se crea un paquete con el siguiente nombre mx.gob.tabasco.spring.vo el cual tendra nuetro objeto POJO
* Creamos nuesto objeto POJO dentro del paquete
	* Debemos tomar en cuenta que el nombre de nuestras variables debe de coicidir con el de los parametros que enviamos desde el formulario

Asegurado.java
```java
package mx.gob.tabasco.spring.vo;
//Plain Old java object(POJO)
public class Asegurado {	
	private String nombre;
	private Integer edad;
	private String sexo;
	private String numeroSeguroSocial;
	private String apellido;	
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getNumeroSeguroSocial() {
		return numeroSeguroSocial;
	}
	public void setNumeroSeguroSocial(String numeroSeguroSocial) {
		this.numeroSeguroSocial = numeroSeguroSocial;
	}
}
```

* Nuestro metodo de recepcion quedaria de la siguiente manera


IndexController.java
```java
...
@RequestMapping(value="/resultado",method=RequestMethod.POST)
public String formAction(Model model,
	Asegurado asegurado //AGREGAMOS NUESTRO OBJETO COMO ARGUMENTO DEL METODO Y RECIBIRA LOS PARAMENTROS ENVIADOS DEL FORMULARIO
	){
	//ACCEDEMOS A CADA VALOR DE LOS PARAMETROS MEDIANTE LOS GETTERS DE NUESTRO OBJETO
	model.addAttribute("nombre",asegurado.getNombre());
	model.addAttribute("edad",asegurado.getEdad());
	model.addAttribute("apellido",asegurado.getApellido());
	model.addAttribute("numeroSeguroSocial",asegurado.getNumeroSeguroSocial());
	model.addAttribute("sexo",asegurado.getSexo());
	return "resultado";
}
...
```


##Persistencia de base de datos

* Click derecho al proyecto
	* ->seleccione property
	* ->seleccione property faces 
	* checked a JPA
	* ->click a OK

* Se crea el archivo META-INF/presistence.xml
	* se configura el Presisten provider con el siguiente valor:
		* org.hibernate.jpa.HibernatePersistenceProvider

* Se crea un paquete con el siguiente nombre
	* mx.gob.tabasco.sprint.entities

* Se da click derecho  new y others busquen dentro 
	* JPA Entities from Tables
	* le dan aceptar
* En Generate Custom Entities
	*  Seleccione una nueva conexion
		* Seleccione mysql
		* Dentro en New Connection Profile
			* Seleccione el driver
				* En caso de no tenerlo
				* Click en nuevo seleccione la ultima version del dirver
				* En la pestaña JAR list seleccione la ubicacion de su jar del driver de mysql
				* En property configure la conexion de la base de datos y dan ok
			* Seleccione la configuracion y damos testconexion y si es exitoso damos ok

	* Seleccionamos el esquema y nos muestra todas las tablas de nuestra base de datos y las seleccionamos
	* Damos siguiente y nos muestra las relaciones y damos siguiente
	* En key generator seleccionamos identity
	* En package nuestra ruta del paquete entities
	* Siguiente y nos sercioramos de la configuracion de nuestras entidades id como Long y Entity access en property y damos finalizar

* En archivo META-INF presistence.xml
	* Seleccionamos la pestaña connection
		* seleccionamos Transaction type como Resource Local
		* Seleccionamos Populate from connection y nos acompleta nuestra configuracion

* En nuestro WEB-INF/web.xml y agregamos lo siguiente

web.xml
```xml
...
	<context-param>
		<param-name>contextConfigLocation</param-name>
		<param-value>/WEB-INF/data-context.xml</param-value>
	</context-param>
	<!-- Bootstraps the root web application context before servlet initialization -->
	<listener>
		<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
	</listener>
...  
```

* Creamos nuestro archivo data-context.xml dentro de WEB-INF

data-context.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xmlns:tx="http://www.springframework.org/schema/tx"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd
		http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx.xsd">

	<bean class="org.springframework.orm.jpa.LocalEntityManagerFactoryBean">
		<!--"MiProyecto" es el nombre asignado en mi archivo persistence.xml-->
		<property name="persistenceUnitName" value="MiProyecto"></property>
	</bean>

	<context:component-scan base-package="mx.gob.tabasco.spring.services"></context:component-scan>
	
</beans>

```

* Creamos el paquete de servicios mx.gob.tabasco.spring.services 