package com.krakedev.artesanal;

import java.util.ArrayList;

public class NegocioMejorado {
	
	private String nombre;
	private ArrayList<Maquina> maquinas = new ArrayList<Maquina>();
	private int ultimoCodigo=100;
	
	//constructor
	public NegocioMejorado() {
		
	}
	
	
	//getters y seters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Maquina> getMaquinas() {
		return maquinas;
	}

	public void setMaquinas(ArrayList<Maquina> maquinas) {
		this.maquinas = maquinas;
	}

	public int getUltimoCodigo() {
		return ultimoCodigo;
	}

	public void setUltimoCodigo(int ultimoCodigo) {
		this.ultimoCodigo = ultimoCodigo;
	}
	

}
