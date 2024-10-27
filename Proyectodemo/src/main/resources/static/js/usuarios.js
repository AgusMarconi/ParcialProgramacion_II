// Call the dataTables jQuery plugin
$(document).ready(function() {
	
	cargarUsuarios();
  $('#usuarios').DataTable();
});

 async function cargarUsuarios(){
	const request= await fetch('api/usuarios',{
	method: 'GET',
	headers: {
		'Accept': 'application/json',
		'Content-Type': 'application/json'}
	});
	
	const usuarios= await request.json();
	
	
	let listarUsuarios='';
	for (let usuario of usuarios){
		botonEliminar= '<a href="#" onclick="eliminarUsuarios('+usuario.id+')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';
		
		let usuarioHTML='<tr><td>' + usuario.id + 
						'</td><td>' + usuario.nombre + 
						'</td><td>' + usuario.apellido +
						'</td><td>' + usuario.telefono +
						'</td><td>' + usuario.email +
						'</td><td>' + botonEliminar +'</td></tr>';
		listarUsuarios+=usuarioHTML;
						
	}
	
	document.querySelector('#usuarios tbody').outerHTML=listarUsuarios;
	
}
async function eliminarUsuarios(id){
	
	if (!confirm('¿Desea eliminar el usuario?')){
		return
	}
	
	await fetch('api/usuarios/'+id,{
	method: 'DELETE',
	headers: {
		'Accept': 'application/json',
		'Content-Type': 'application/json'}
	});
	
	window.location.href="usuarios.html";
	
}