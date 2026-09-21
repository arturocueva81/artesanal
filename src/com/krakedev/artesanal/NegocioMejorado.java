package com.krakedev.artesanal;

import java.util.ArrayList;

public class NegocioMejorado {
	
	//1. Crear clase NegocioMejorado
	private String nombre;
	private ArrayList<Maquina> maquinas;
	private int ultimoCodigo=100;

	//2. Inicializar el ArrayList
	//constructor que inicializa el arreglo de Maquina
	public NegocioMejorado() {
		maquinas = new ArrayList<Maquina>();
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

	//3. Método generarCodigo
	public String generarCodigo() {
		int numero = (int) (Math.random()*100)+1;
		String codigo;
		codigo = "M-"+numero;
		return codigo;
	}
	
	//4. Método agregarMaquina
	
	//7.Validacion de duplicados. modifica la funcion agergarMaquina
	public boolean agregarMaquina(String nombre, String descripcion, double precio) {
		String codigo = generarCodigo();
		
		Maquina existente =recuperarMaquina(codigo);
		if(existente != null ) {
			return false;
		}
		
		Maquina maquina = new Maquina(codigo, nombre, descripcion, precio);
		maquinas.add(maquina);
		return true;
	}
	
	//5. Método cargarMaquinas
	public void cargarMaquinas() {
		for(int i=0;i<maquinas.size();i++) {
			Maquina m=maquinas.get(i);
			m.llenarMaquina();
		}
	}
	
	//6. Método recuperarMaquina
	
	public Maquina recuperarMaquina(String codigo) {
		
		for(int i=0;i<maquinas.size();i++) {
			Maquina maq=maquinas.get(i);
			if(maq.getCodigo().equals(codigo)) {
				return maq;
			}
		}
		
		return null;
	}
}
