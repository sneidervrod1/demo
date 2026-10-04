package com.proyecto.controllers;
import java.util.List;
import java.util.Set;

import com.proyecto.models.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.service.ClienteService;

@RestController
public class ClienteController {

		//ClienteService x= new ClienteService();
	   
		private final ClienteService clienteService;
	   
		public ClienteController(ClienteService clienteService) {
		       this.clienteService = clienteService;
		}
		
		@GetMapping("/")
		public String inicioClientes() {
			return "exitoso";
		}
		
		 
		@GetMapping("/getUsers")
		public List<Cliente> obtenerClientes() {
			return clienteService.getClientes();
		}

		@GetMapping("/getUser/{id}")
		public Cliente obtenerClientes(@PathVariable("id") long id) {
			return clienteService.getCliente(id);
		}
		
		
		@PostMapping("/addUser")
	    public List<Cliente> addClientes(@RequestBody Cliente clienteNuevo) {
		    return clienteService.addClientes(clienteNuevo);
		}
		
		@PostMapping("/addUsers")
	    public List<Cliente> addClientesMasivos(@RequestBody List<Cliente> clientesNuevos) {
		    return clienteService.addClientes(clientesNuevos);
		}
		
		@PutMapping("/udateUser/{id}")
	    public List<Cliente> addClientes( @PathVariable("id") long id ,@RequestBody Cliente clienteNuevo) {
		    return clienteService.updateClientes(id, clienteNuevo);
		}
		
		
		@DeleteMapping("/deleteUser/{id}")
	    public List<Cliente> addClientes( @PathVariable("id") long id) {
		    clienteService.deleteClientes(id);
		    return clienteService.getClientes();
		}
		
		@GetMapping("/clientes/{id}/superiores")
	    public Set<Cliente> clientesConNivelSuperior(@PathVariable Long id) {
	        return clienteService.clientesConNivelSuperior(id);
	    }
		
}

