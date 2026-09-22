package com.krakedev.artesanal;

import java.util.ArrayList;

public class NegocioMejorado {
	
	//1. Crear clase NegocioMejorado
	private String nombre;
	private ArrayList<Maquina> maquinas;
	private int ultimoCodigo=100;
	
	//8. Crear atributo clientes, sin inicializar
	private ArrayList<Cliente> clientes;

	//2. Inicializar el ArrayList
	//constructor que inicializa el arreglo de Maquina
	public NegocioMejorado() {
		maquinas = new ArrayList<Maquina>();
		
		//11. Corregir error
		clientes = new ArrayList<Cliente>();
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
	
	

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}


	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
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
	
	//9. Metodo registrarCliente
	public void registrarCliente(String nombre, String cedula) {
		Cliente cliente = new Cliente(nombre, cedula);
		ultimoCodigo++;
		cliente.setCodigo(ultimoCodigo);
		clientes.add(cliente);
	}
	
	//13. Método buscarClientePorCedula
	public Cliente buscarClientePorCedula(String cedula) {
		for(int i=0;i<clientes.size();i++) {
			Cliente c=clientes.get(i);
			if(c.getCedula().equals(cedula)) {
				return c;
			}
		}
		return null;
	}
}
