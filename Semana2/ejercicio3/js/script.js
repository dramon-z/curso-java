var MiClase;
MiClase = function(){
	"use strict";
	var init,_config
	,handleStorage
	,handleEjemplos
	,eventClick
	;
	init = function(config){
		_config =config;
		console.log(_config);
		handleStorage();
	};
	eventClick = function(){
		alert("Success");
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
		inicializar:init,
		eventClick:eventClick
	};
};






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



//**ver STORAGE

//VALIDAR SI ES SOPORTADO
if(typeof(Storage) !== "undefined") {
    // Code for localStorage/sessionStorage.
} else {
    // Sorry! No Web Storage support..
}

// Store
//localStorage.setItem("nombre", "Smith");
// Retrieve
//document.getElementById("result").innerHTML = localStorage.getItem("nombre");

//localStorage.removeItem("el");