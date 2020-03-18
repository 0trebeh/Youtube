window.addEventListener('load', Perfil);
function Perfil(){
	var URL = '/User';

	var user = document.getElementById("U").value;
	var clave = document.getElementById("M").value;

	var resp = "";

	fetch(URL, {
		method : 'POST',
	}).then(response => response.text())
	.catch(error => console.log('Error:'+ error))
	.then(response => console.log(response), resp=response);
	
	window.location.replace("/youtube.html");
}

function mod(){

}

function Deleter(){

}