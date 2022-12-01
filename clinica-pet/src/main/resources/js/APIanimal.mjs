const url = "http://localhost:8093/api/animal/"


export const nuevoAnimal = async (animal)=>{
	try {
		await fetch(`${url}/add`, {
			method: "POST",
			body: JSON.stringify(animal),
			headers: {"Content-Type": "application/json", 
			},
		});
  	} catch (error) {
		  console.log(error);
	}
	window.location.href = "index.html";
}


export const obtenerAnimales = async () => {
	try{
		const connection = await fetch(`${url}/all`);
		const result = await connection.json();
		return result
		}catch(error){
		console.log(error);
	}
}

export const eliminarAnimales = async (id) => {
  try {
    await fetch(`${url}/${id}`, {
      method: "DELETE",
    });
  } catch (error) {
    console.log(error);
  }
  window.location.href = "index.html";
};






