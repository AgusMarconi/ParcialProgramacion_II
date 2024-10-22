$(document).ready(function() {
	iniciarSesion();
	
});

 async function iniciarSesion(){
	
	let datos={};
	
	datos.email=document.getElementById('txtEmail').value;
	datos.password=document.getElementById('txtPassword').value;
	
	const request=await fetch('api/login',{
			method: 'POST',
			headers: {
				'Accept': 'application/json',
				'Content-Type': 'application/json'},
				body: JSON.stringify(datos)
			});
	
	const respuesta=await request.text();
	
	
	if (respuesta==="OK"){
		alert("¡Inicio de Sesión con exito!");
		window.location.href="usuarios.html";
	}else{
		alert("Credenciales incorrectas. Intente nuevamente.");
	}
	
	//location.reload();
}