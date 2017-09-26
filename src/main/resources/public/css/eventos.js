function mostrarVentana(id){
	var element = document.getElementById(id);
	element.style.display='inline';
	ocultarVentanaInicio();
}

function ocultarVentanaInicio(){
	var element = document.getElementById("ventanaInicio");
	element.style.display='none';
}

function volverAlInicio(id){
	var element = document.getElementById(id);
	var inic = document.getElementById("ventanaInicio");
	element.style.display='none';
	inic.style.display='inline'
}