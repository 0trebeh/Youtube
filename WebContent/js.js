function Log(){
	var form = new FormData();

	var URL = '/Login';

	var user = document.getElementById("U").value;
	var clave = document.getElementById("P").value;

	var resp = "";

	form.append('usuario', user);
	form.append('clave', clave);

	fetch(URL, {
		method : 'POST',
		body : form
	}).then(response => response.text())
	.catch(error => console.log('Error:'+ error))
	.then(response => console.log(response), resp=response);
	
	window.location.replace("/youtube.html");
}