package com.proyecto.models;

public enum NivelCliente {
	
    PLATA(1),
    ORO(2),
    DIAMANTE(3);

	private final int valor;

    NivelCliente(int valor) {
	   this.valor = valor;
    }
    
    public int getValor() {
	   return valor;
    }
	    
	    
	    
}
