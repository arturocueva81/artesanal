package com.krakedev.artesanal;

public class Maquina {
	
	//ejercicio 1, , parte 1. agrega atributo codigo de tipo String y actualiza en constructores
	private String codigo;
	private String nombreCerveza;
	private String descripcion;
	private double precioPorMl;
	private double capacidadMaxima;
	private double cantidadActual;
	
	//constructor 1 actualizado
	public Maquina(
			String codigo,
			String nombreCerveza, 
			String descripcion, 
			double precioPorMl, 
			double capacidadMaxima 
			) {
		this.codigo=codigo;
		this.nombreCerveza = nombreCerveza;
		this.descripcion = descripcion;
		this.precioPorMl = precioPorMl;
		this.capacidadMaxima = capacidadMaxima;
		this.cantidadActual = 0;
	}
	
	// constructor 2 actualizado
	public Maquina(
			String codigo,
			String nombreCerveza, 
			String descripcion, 
			double precioPorMl 
			) {
		this.codigo=codigo;
		this.nombreCerveza = nombreCerveza;
		this.descripcion = descripcion;
		this.precioPorMl = precioPorMl;
		this.capacidadMaxima = 1000;
		this.cantidadActual = 0;
	}
	
	//ejercicio 1, solo metodo GET, sin SET
	public String getCodigo() {
		return codigo;
	}

	public String getNombreCerveza() {
		return nombreCerveza;
	}

	public void setNombreCerveza(String nombreCerveza) {
		this.nombreCerveza = nombreCerveza;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioPorMl() {
		return precioPorMl;
	}

	public void setPrecioPorMl(double precioPorMl) {
		this.precioPorMl = precioPorMl;
	}

	public double getCapacidadMaxima() {
		return capacidadMaxima;
	}

	public double getCantidadActual() {
		return cantidadActual;
	}

	//ejercicio 1, parte 2: modifica el metodo para mostrar el nuevo atributo: codigo
	public void imprimir() {
		String mensaje;
		mensaje = "Codigo: " + codigo 
				+ "Nombre cerveza: " + nombreCerveza 
				+ "; Descripcion: " + descripcion 
				+ "; Precio ml: " + precioPorMl
				+ "; Capacidad Maxima: " + capacidadMaxima 
				+ "; Cantidad Actual: " + cantidadActual;
		System.out.println(mensaje);
	}
	
	//ejercicio 2: cambio en la logica del tanque
	public void llenarMaquina() {
		this.cantidadActual=this.capacidadMaxima-200;
	}
	
	public boolean recargarCerveza(double cantidad) {
		double limitePermitido=capacidadMaxima-100;
		
		if(cantidadActual+cantidad <= limitePermitido) {
			cantidadActual=cantidadActual+cantidad;
			return true;
		}else {
			
			return false;
		}
	}
	
	public double servirCerveza(double cantidad) {
		
		if(cantidadActual >= cantidad) {
			cantidadActual=cantidadActual-cantidad;
			double valor = cantidad*precioPorMl;
			return valor;
		}else {
			return 0;
		}
		
	}

}
