import {
	obtenerAnimales,
	nuevoAnimal,
	eliminarAnimales
} from "../APIanimal.js";

document.addEventListener("DOMContentLoaded", ()=> {
	getAnimales();
});

async function getAnimales(){
	const animal = await obtenerAnimales();
	const animales = document.querySelector("#animales");
	let html = "";
	animal.forEach((anima)=>{
		const {id, nombre, peso, raza, problema, genero, imagen } = anima;
	html += `          
              <td>${nombre}</td>
              <td>${peso}</td>
              <td>${raza}</td>
              <td>${problema}</td>
              <td>${genero}</td>
              <td>${imagen}</td>
              
              <td ><a href="#" data-acusado="${id}" class="btn btn-danger eliminar">Eliminar</a></td> 
	`;
	});
	animales.innerHTML = html;
}

const formulario = document.querySelector("#formulario");
formulario.addEventListener("submit", crearAnimal);

async function crearAnimal(e){
	e.preventDefault(e);
	const nombre = document.querySelector("#nombre").value;
	const peso = document.querySelector("#peso").value;
	const raza = document.querySelector("#raza").value;
	const problema = document.querySelector("#problema").value;
	const genero = document.querySelector("#genero").value;
	const imagen = document.querySelector("#imagen").value;
	
	const animal = {
		nombre, 
		peso, 
		raza, 
		problema, 
		genero, 
		imagen 
		};
		console.log("Datos", animal);
		nuevoAnimal(animal);
}


const listado = document.querySelector("#animales");
listado.addEventListener("click", confirmarEliminar);

async function confirmarEliminar(e) {
  if (e.target.classList.contains("eliminar")) {
    const animalId = parseInt(e.target.dataset.animal);
    console.log(animalId);
    const confirmar = confirm("¿Deseas eliminar este Animal?");

    if (confirmar) {
      /* llamamos a la funcion metodo HTTP DELETE */
      await eliminarAnimales(animalId);
    }
  }
}