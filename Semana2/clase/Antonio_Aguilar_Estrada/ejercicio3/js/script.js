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
//json_miObjeto = JSON.stringify(miObjeto);
//document.getElementById("objeto").innerHTML = json_miObjeto;

//**ver STORAGE

//VALIDAR SI ES SOPORTADO
if(typeof(Storage) !== "undefined") {
    // Code for localStorage/sessionStorage.
} else {
    // Sorry! No Web Storage support..
}

// Store
localStorage.setItem("nombre", "Smith");
// Retrieve
document.getElementById("result").innerHTML = localStorage.getItem("nombre");

//localStorage.removeItem("el");