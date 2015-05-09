console.log(document);
console.log(document.getElementById('id-div'));
document.getElementById('id-div').innerHTML = "TEST";

console.log(document.getElementsByName('nombre'));
document.getElementsByName('nombre')[0].value = "Esto es un nombre";

// comentario en una sola línea
 
/* este es un comentario 
   multilinea
 */
 
/* no puedes, sin embargo, /* anidar comentarios */ 


var respuesta = 42;
const pi = 3.1416;
var mivariabloe="";
globla="mi variable global";
var foo = 42;    // foo is a Number now
var foo = "bar"; // foo is a String now
var foo = true;  // foo is a Boolean now

var a=1;
var b=2;
var c=3;

var a=1,
	b=2,
	c=3;

try{
	for (var i = Things.length - 1; i >= 0; i--) {
		Things[i]
	};	
}catch(e){
	console.log(e);

}



var a="1"+1;
document.getElementById('id-li-1').innerHTML=a;
var b=1+1;
document.getElementById('id-li-2').innerHTML =b;
a = parseInt("1")+1;
document.getElementById('id-li-3').innerHTML=a;

/**
Convertir string a números

En el caso que un valor representando un número está en memoria como string, hay métodos para la conversión.
parseInt() y parseFloat()**/





//document.getElementById()
//document.getElementsByName()
//document.getElementsByClassName()
//document.getElementById("objeto").innerHTML = "TEST";