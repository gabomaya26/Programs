import {
	obtenerAnimales,
	agregarAnimales,
} from "../APIanimal.js";

document.addEventListener("DOMContentLoaded", ()=> {
	getAnimales();
});

async function getAnimales(){
	const animal = await obtenerAnimales();
	const animales = document.querySelector("#animales");
	let html = "";
	animal.forEach((Animal)=>{
		const {nombre, peso, problema, raza, genero, imagen} = Animal;
		html += ` 
		       <div class="card">
		       <img src="${imagen}" class="card-img-top" alt="..." />
		       <div class="card-body">
		       <h2 class="card-title">${nombre}</h2>
		       <p class="card-text">${peso}</p>
		       <p class="card-text">${raza}</p>
		       <p class="card-text">${genero}</p>
            </div>
        </div>`;
        animales.innerHTML = html;
	});
}

const formulario = document.querySelector("#formulario");
formulario.addEventListener("submit", addAnimal);

async function addAnimal(e) {
  e.preventDefault(e);

  const nombre = document.querySelector("#nombre").value;
  const peso = document.querySelector("#peso").value;
  const problema = document.querySelector("#problema").value;
  const raza = document.querySelector("#raza").value;
  const genero = document.querySelector("#genero").value;
  const imagen = document.querySelector("#imagen").value;
  
  

  const animal = {
    nombre,
    peso,
    problema,
    raza,
    genero,
    imagen
  };
  agregarAnimales(animal);
}