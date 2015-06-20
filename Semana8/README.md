#Spring


##Configuracion basica

* Creamos el proyecto como Dynamic web proyect

* Configuramos nuestro web.xml, se encuentra en /WEB-INF/web.xml

```sh
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
###Se configura el /WEB-INF/web-context.xml

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

###Creamos una clase Controlador en nuestro paquete mx.gob.tabasco.spring.controllers

	@Controller //ESTA ANOTACION INDICA QUE NUESTRA CLASE ES UN CONTROLADOR
	@RequestMapping(value="/") //INDICAMOS NUESTRA RUTA A LA CUAL RESPONDE ESTE CONTROLADOR
	public class IndexController {
		
		@RequestMapping(method=RequestMethod.GET)//SE DEFININE EL TIPO DE PETICON QUE RESPONDE NUESTRO METODO
		public String indexAction(){
			return "index";//SE INDICA LA UBICACION DE NUESTRA VISTA
		}
	}


###Creamos nuestra vista en en /WEB-INF/views/index.jsp

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


-