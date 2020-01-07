package com.example.holdertraduccionesapp;

public class Traduccion {
	private String pais;
	private String traduccion;

	public Traduccion(String pais, String traduccion){
		this.pais = pais;
		this.traduccion = traduccion;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getTraduccion() {
		return traduccion;
	}

	public void setTraduccion(String traduccion) {
		this.traduccion = traduccion;
	}
}
