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
	
	botonEliminar= '<a href="#" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';
	
	let listarUsuarios='';
	for (let usuario of usuarios){
		
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