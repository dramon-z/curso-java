console.log(document);
console.log(document.getElementById('id-div'));
document.getElementById('id-div').innerHTML="TEST";

console.log(document.getElementsByName('nombre'));
document.getElementsByName('nombre')[0].value="Esto es un nombre";
