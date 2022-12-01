import {
	obtenerUsuarios,
	nuevoUsuario,
	eliminarUsuarios
} from "../APIanimal.js";

document.addEventListener("DOMContentLoaded", ()=> {
	getUsuarios();
});

async function getUsuarios(){
	const us = await obtenerUsuarios();
	const user = document.querySelector("#usuarios");
	let html = "";
	us.forEach((anima)=>{
		const {id, nombre, correo, username, password } = anima;
	html += `          
              <td>${nombre}</td>
              <td>${correo}</td>
              <td>${username}</td>
              <td>${password}</td>
              <td ><a href="#" data-acusado="${id}" class="btn btn-danger eliminar">Eliminar</a></td> 
	`;
	});
	user.innerHTML = html;
}

const formulario = document.querySelector("#formulario");
formulario.addEventListener("submit", crearUsuario);

async function crearUsuario(e){
	e.preventDefault(e);
	const nombre = document.querySelector("#nombre").value;
	const correo = document.querySelector("#correo").value;
	const username = document.querySelector("#username").value;
	const password = document.querySelector("#password").value;

	
	const usuario = {
		nombre, 
		correo, 
		username, 
		password, 
 
		};
		console.log("Datos", usuario);
		nuevoUsuario(usuario);
}


const listado = document.querySelector("#usuarios");
listado.addEventListener("click", confirmarEliminar);

async function confirmarEliminar(e) {
  if (e.target.classList.contains("eliminar")) {
    const usuarioId = parseInt(e.target.dataset.usuario);
    console.log(usuarioId);
    const confirmar = confirm("¿Deseas eliminar este Usuario?");

    if (confirmar) {
      /* llamamos a la funcion metodo HTTP DELETE */
      await eliminarUsuarios(usuarioId);
    }
  }
}