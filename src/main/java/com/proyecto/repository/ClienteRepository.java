package com.proyecto.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.proyecto.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}