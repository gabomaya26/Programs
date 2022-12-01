const url1 = "http://localhost:8093/api/usuario/"

export const obtenerUsuarios = async () => {
	try{
		const connection = await fetch(`${url1}/all`);
		const result = await connection.json();
		return result
		}catch(error){
		console.log(error);
	}
}

export const agregarUsuarios = async () => {
	try{
		await fetch(`${url1}/add`,{
			method: 'POST',
			body : JSON.stringify(usuario),
			headers: {
				"Contet-Type":"application/json",
			},
			
		});
		
	}catch(error){
		console.log(error);
	}
}


export const eliminarUsuario = async (id) => {
  try {
    await fetch(`${url1}/${id}`, {
      method: "DELETE",
    });
  } catch (error) {
    console.log(error);
  }
  window.location.href = "index.html";
};

