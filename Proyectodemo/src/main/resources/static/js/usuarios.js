$(document).ready(function() {
    cargarUsuarios();
    $('#usuarios').DataTable();
    actualizarEmailUsuario();
});

function actualizarEmailUsuario(){
    document.getElementById("text-email-usuario").outerHTML = localStorage.email;
}

function getHeaders(){
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + localStorage.token  // <-- agregado "Bearer "
    };
}

async function cargarUsuarios(){
    const request = await fetch('api/usuarios', {
        method: 'GET',
        headers: getHeaders()
    });

    if (request.status === 401) {
        alert("Token inválido o expirado. Hacé login de nuevo.");
        window.location.href = "login.html";
        return;
    }

    const usuarios = await request.json();

    let listarUsuarios = '';
    for (let usuario of usuarios){
        let botonEliminar = '<a href="#" onclick="eliminarUsuarios('+usuario.id+')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';

        let usuarioHTML = '<tr><td>' + usuario.id +
                          '</td><td>' + usuario.nombre +
                          '</td><td>' + usuario.apellido +
                          '</td><td>' + usuario.telefono +
                          '</td><td>' + usuario.email +
                          '</td><td>' + botonEliminar +'</td></tr>';
        listarUsuarios += usuarioHTML;
    }

    document.querySelector('#usuarios tbody').innerHTML = listarUsuarios;  // <-- usar innerHTML
}

async function eliminarUsuarios(id){
    if (!confirm('¿Desea eliminar el usuario?')){
        return;
    }

    await fetch('api/usuarios/'+id,{
        method: 'DELETE',
        headers: getHeaders()
    });

    window.location.href="usuarios.html";
}
