 $(document).ready(function() {
	
});

 async function registrarUsuario(){

	
	let datos={};
	datos.nombre=document.getElementById('txtNombre').value;
	datos.apellido=document.getElementById('txtApellido').value;
	datos.email=document.getElementById('txtEmail').value;
	datos.telefono=document.getElementById('txtTelefono').value;
	datos.password=document.getElementById('txtPassword').value;
	
	let repetirpassword=document.getElementById('txtRepetirPassword').value;
	if (repetirpassword!=datos.password || datos.password==null){
		alert("Contraseña Incorrecta. Intente nuevamente.");
		return;
	}else{
		alert("¡Usuario registrado con exito!");
			await fetch('api/usuarios',{
				method: 'POST',
				headers: {
					'Accept': 'application/json',
					'Content-Type': 'application/json'},
					body: JSON.stringify(datos)
				});
		window.location.href='login.html';
	
	}
	
}