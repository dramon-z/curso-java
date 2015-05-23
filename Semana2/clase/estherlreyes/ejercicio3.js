function Objeto(){
	this.cadena="micadena";
	this.aleatorio=Math.random();
var MiClase;
MiClase = function(){
	"use strict";
	var init,_config
	,handleStorage
	,handleEjemplos
	;
	init = function(config){
		_config =config;
		console.log(_config);
		handleStorage();
	};
	handleStorage = function(){
		if(typeof(Storage) !== "undefined") {
			handleEjemplos();
		} else {
			alert("El sitio web no es soportado por su navegador");
		}
	};
	handleEjemplos = function(){
		var telefonos= {
		casa:"123214",
		oficina:"3213424"
			};
		var variable = {
			nombre:"Daniel",
			ap_paterno:"Ramon",
			ap_materno:"Zapata",
			telefonos:telefonos
		};
		var json_miObjeto = JSON.stringify(variable);
		localStorage.setItem("nombre", json_miObjeto);
		document.getElementById("storage").innerHTML = localStorage.getItem("nombre");
		console.log( localStorage.getItem("nombre"));
		var obj = JSON.parse(localStorage.getItem("nombre"));
		localStorage.removeItem("nombre");
		console.log(obj);
	};	
	return {
		inicializar:init
	};
};


var otroObjeto = {

};

var miObjeto = new Objeto(),
    cadena = "miCadena",
    aleatorio = Math.random(),
    objeto = new Object();

miObjeto.type                 = "Sintaxis con punto";
miObjeto["Fecha de creación"] = "Cadena con espacios y acento";
miObjeto[cadena]              = "String value";
miObjeto[aleatorio]           = "Número Aleatorio";
miObjeto[objeto]              = "Objeto";
miObjeto[""]                  = "Incluso una cadena vacía";

console.log(miObjeto);
document.getElementById("objeto").innerHTML = miObjeto;
/**
function Objeto(){
	this.cadena="micadena";
	this.aleatorio=Math.random();
};

var mi_funcion = function(str){
	mi_variable_local = "dos";
	
	document.getElementById("ejemplo").innerHTML =str;
}

mi_funcion("tres");
console.log(mi_variable_local);
**/

var cars = ["Saab", "Volvo", "BMW"];
document.getElementById("arreglo").innerHTML = cars;

//mostrar el objeto con JSON.stringify() y JSON.parse()
//json_miObjeto = JSON.stringify(miObjeto);
//document.getElementById("objeto").innerHTML = json_miObjeto;

//**ver STORAGE

@@ -40,8 +74,8 @@ if(typeof(Storage) !== "undefined") {
}

// Store
localStorage.setItem("nombre", "Smith");
//localStorage.setItem("nombre", "Smith");
// Retrieve
document.getElementById("result").innerHTML = localStorage.getItem("nombre");
//document.getElementById("result").innerHTML = localStorage.getItem("nombre");

//localStorage.removeItem("el");
