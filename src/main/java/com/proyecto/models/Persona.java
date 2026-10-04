package com.proyecto.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@MappedSuperclass
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Persona {
	
	@Column // El campo column no es obligatorio
	private String nombre; 

	@Column
	private String apellido; 
	
	@Column
	private int edad; 
	
	
}
