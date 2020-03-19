
const $form = document.querySelector('#form');

function image(){

}

function video(){

}

const $usuario = document.querySelector('#usuario')
function userName(formData){
	const username = formData.get('usuario')
	$usuario.textContent = username
}

$form.addEventListener('submit', (event) => {
	event.preventDefault()
	const formData = new FormData($form)
	userName(formData)
})

function Deleter(){

}