
	var URL = '/User';

	var user = document.getElementById("U").value;
	var clave = document.getElementById("M").value;

	const $usuario = document.querySelector('#usuario')
	function username(formData){
		const username = formData.get('usuario')
		$usuario.textContent = username
	}

	$form.addEventListener('submit', (event) => {
		event.preventDefault()
		const formData = new FormData($form)
		username(formData)
	})

function mod(){

}

function Deleter(){

}