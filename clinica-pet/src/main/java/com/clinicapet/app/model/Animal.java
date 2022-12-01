package com.clinicapet.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.*;


@Document(collection = "animal")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Animal {
	@Id
	@Getter @Setter
	private String getId;
	@Getter @Setter 
	private String nombre;
	@Getter @Setter
	private String peso;
	@Getter @Setter
	private String problema;
	@Getter @Setter
	private String raza;
	@Getter @Setter
	private String genero;
	@Getter @Setter
	private String imagen;
	
	public String getGetId() {
		return getId;
	}
	public void setGetId(String getId) {
		this.getId = getId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPeso() {
		return peso;
	}
	public void setPeso(String peso) {
		this.peso = peso;
	}
	public String getProblema() {
		return problema;
	}
	public void setProblema(String problema) {
		this.problema = problema;
	}
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
}

