function Objeto(){
	this.cadena="micadena";
	this.aleatorio=Math.random();
};

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
console.log(variable);
console.log(variable.telefonos);
console.log(variable.telefonos.casa);
console.log(variable.nombre);
document.getElementById('ejemplo1').innerHTML=variable.nombre+" "+variable.ap_paterno+" "+variable.ap_materno;



function Objeto(){
	this.cadena="micadena";
	this.aleatorio=Math.random();
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

var cars = ["Saab", "Volvo", "BMW"];
document.getElementById("arreglo").innerHTML = cars;

//mostrar el objeto con JSON.stringify() y JSON.parse()
json_miObjeto = JSON.stringify(variable);
document.getElementById("objeto").innerHTML = json_miObjeto;

var l = cars.length
var i=0;

for ( i = 0; i < l; i++) {
	cars[i];
};

for (variable in cars){
	console.log(cars[variable]);
}