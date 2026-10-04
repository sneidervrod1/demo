package com.proyecto.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;
import com.proyecto.models.Cliente;
import com.proyecto.models.NivelCliente;
import com.proyecto.repository.ClienteRepository;

@Service
public class ClienteService {

	
	private final ClienteRepository clienteRepository;

	public ClienteService(ClienteRepository clienteRepository) {
	    this.clienteRepository = clienteRepository;
	}

	public List<Cliente> getClientes() {
        return clienteRepository.findAll();
	}
	
	
	public Cliente getCliente(long id) {
		
		Cliente cliente = clienteRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
	
		return cliente;
		
//	    Cliente cliente = clienteRepository.findById(id);
//		
//		if (cliente != null) {
//			return cliente;
//		} else {
//			Cliente x= new Cliente();
//			return x;
//		}
//		
	}
	
	
	public List<Cliente> addClientes(Cliente nuevoCliente) {
		 clienteRepository.save(nuevoCliente); 
		 return clienteRepository.findAll(); 
	}
	
	public List<Cliente> addClientes(List<Cliente> nuevosClientes) {
		 return clienteRepository.saveAll(nuevosClientes);
	}
	
	public List<Cliente> updateClientes(long id, Cliente nuevoCliente) {
	    Cliente cliente = clienteRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
	    nuevoCliente.setId(cliente.getId());
	    clienteRepository.save(nuevoCliente);
		return clienteRepository.findAll();
	}

	public void deleteClientes(long id) {
		 Cliente cliente =  clienteRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

		 
		 clienteRepository.delete(cliente);
	}
	
	
	public Set<Cliente> clientesConNivelSuperior(Long id) {

	    Cliente cliente = clienteRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

	    NivelCliente nivelActual = cliente.getNivel();

	    List<Cliente> clientes = clienteRepository.findAll();

	    Set<Cliente> resultado = new HashSet<>();

	    for (Cliente c : clientes) {

	        if (c.getNivel().getValor() > nivelActual.getValor()) {
	            resultado.add(c);
	        }
	    }

	    return resultado;
	}
	
}

















