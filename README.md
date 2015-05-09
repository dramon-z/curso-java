# curso-java

Referencias del curso.

#HTML 5

NUEVAS ETIQUETAS

		ELEMENTOS SEMANTICOS
			header
			hgroup
			nav
			article
			section
			aside
			time
			mark
			footer

		ELEMENTOS PARA ESTRUCTURA EL CODIGO
			details
			summary

		ELEMENTOS MULTIMEDIA
			audio
			video
			source
			canvas

ETIQUETAS ELIMINADAS

		acronym
		applet
		big
		center
		dir
		font
		frame
		frameset
		strike
		tt
		basefont

DIFERENCIAS

	En HTML4 
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	En HTML5 
	<metacharset="utf-8">

	En HTML4 
	<link rel="stylesheet" href="style.css" type="text/css" media="screen"/>
	En HTML5
	<link rel="stylesheet" href="style.css"/>

	En HTML4 
	<script src="code.js" type="text/javascript"></script>
	En HTML5
	<script src="code.js"> </script>

#CSS

PSEUDO ELEMENTOS

		:first-line
		:first-letter
		:before
		:after


PSEUDO CLASES

		:visited
		:lang
	    :link
	    :visited
	    :active
	    :hover
	    :focus
	    :first-child
	    :last-child
	    :nth-child
	    :nth-last-child
	    :nth-of-type
	    :first-of-type
	    :last-of-type
	    :empty
	    :target
	    :checked
	    :enabled
	    :disabled

ejercicio 3:

	:enabled{
		border:2px solid #000882D;
	}

ejercicio:

	li{
		float:left;
		list-style:none;
		width:180px;
		height:180;
		text-align:center;
		font-size:50px;
		font-weight:bold;
		background:#585858;
		margin-fight:20px;
		margin-bottom:20px;
		line-height:180px;
	}
	ul > li {
		border-radius:50%;
	}

Selectores

	E:disabled /*
	Elemento que esta desactivado*/
	E:checked /*
	Elemento es que esta marcado (radiobutton, checkbox)*/
	E[foo^="bar"]/*E
	l que el valor del atributo “foo” de E comienza con la cadena “bar”.*/
	E[foo$="bar"]/*
	El valor del atributo  “foo” de E acaba exactamente con la cadena “bar”.*/
	E[foo*="bar"]/*el
	atributo “foo” de E contiene la cadena “bar”.*/

	:hover, se activa cuando el usuario pasa el ratón o cualquier otro elemento apuntador por encima de un elemento.
	:active, se activa cuando el usuario activa un elemento, por ejemplo cuando pulsa con el ratón sobre un elemento El estilo se aplica durante un espacio de tiempo prácticamente imperceptible, ya que sólo dura desde que el usuario pulsa el botón del ratón hasta que lo suelta.
	:focus, se activa cuando el elemento tiene el foco del navegador, es decir, cuando el elemento está seleccionado Normalmente se aplica a los elementos <input> de los formularios cuando están activados y por tanto, se puede escribir directamente en esos campos.
	:first-child,selecciona el primer elemento hijo de un elemento.
	:link,se aplica a todos los enlaces que todavía no han sido visitados por el usuario.
	:visited,se aplica a todos los enlaces que han sido visitados al menos una vez por el usuario

#GIT

Git

	http://es.wikipedia.org/wiki/Git

Gitflow 

	http://danielkummer.github.io/git-flow-cheatsheet/

#JAVASCRIPT	

DOM (ejemplo1)

	http://javascript.info/tutorial/dom-nodes
	http://www.w3schools.com/jsref/dom_obj_document.asp

Comentarios y declaracion de variables(ejemplo1)

	https://developer.mozilla.org/es/docs/Web/JavaScript/Guide/Grammar_and_types

Manejo de errores (ejemplo1)

	https://developer.mozilla.org/es/docs/Web/JavaScript/Guide/Control_de_flujo_y_manejo_de_errores

Manejo de objetos y arreglos (ejemplo2)

	https://developer.mozilla.org/es/docs/Web/JavaScript/Guide/Trabajando_con_objectos#Objetos_y_propiedades
	
	http://www.w3schools.com/js/js_arrays.asp
	
	http://www.w3schools.com/js/js_array_methods.asp

Funciones y clases (ejemplo3)

	https://developer.mozilla.org/es/docs/Web/JavaScript/Guide/Details_of_the_Object_Model
	https://developer.mozilla.org/es/docs/Web/JavaScript/Guide/Funciones#Predefined_functions
	https://developer.mozilla.org/es/docs/Web/JavaScript/Guide/Details_of_the_Object_Model

Storage (ejemplo3)

	http://www.w3schools.com/html/html5_webstorage.asp

Extras
	
	http://lineadecodigo.com/categoria/javascript/
	https://developer.mozilla.org/es/docs/Web/JavaScript/Referencia
	https://developer.mozilla.org/es/docs/Web/JavaScript/Guide

#Jquery 
	
	https://jquery.com/download/

Iniciar(ejercicio4)

		http://www.w3schools.com/jquery/jquery_get_started.asp
		https://learn.jquery.com/using-jquery-core/document-ready/

Selectores(ejercicio4)

		https://learn.jquery.com/using-jquery-core/selecting-elements/
		https://learn.jquery.com/using-jquery-core/attributes/
		https://learn.jquery.com/using-jquery-core/working-with-selections/		
		https://learn.jquery.com/using-jquery-core/manipulating-elements/
		https://learn.jquery.com/using-jquery-core/jquery-object/

Parents(ejercicio4)

		https://learn.jquery.com/using-jquery-core/traversing/

css(ejercicio4)

		https://learn.jquery.com/using-jquery-core/css-styling-dimensions/

data(ejercicio4)
	
		https://learn.jquery.com/using-jquery-core/data-methods/

each(ejercicio4)

		https://learn.jquery.com/using-jquery-core/iterating/

event(ejercicio5)

		https://learn.jquery.com/events/event-basics/
		https://learn.jquery.com/events/introduction-to-events/
		https://learn.jquery.com/events/
		https://learn.jquery.com/events/triggering-event-handlers/

#Peticiones AJAX(ejercicio6)

		https://learn.jquery.com/ajax/jquery-ajax-methods/
		https://learn.jquery.com/ajax/ajax-and-forms/		

Extra

	http://lineadecodigo.com/categoria/jquery/
	https://learn.jquery.com/plugins/basic-plugin-creation/
	https://jquery.com/
	http://api.jquery.com/
	https://learn.jquery.com/plugins/basic-plugin-creation/



#Validaciones de formularios(ejercicio7)

validar submit(ejericio7)

	https://api.jquery.com/submit/

validar ajax(ejericio7)

plugin(ejericio7)
	
	http://jqueryvalidation.org/validate/
	http://datatables.net/



#Framework HTML/CSS Bootstrap(ejercicio8)
	
	http://getbootstrap.com/getting-started/

css

	http://getbootstrap.com/css/

components

	http://getbootstrap.com/components/

javascript

	http://getbootstrap.com/javascript/