# Implementación de la conectividad de bases de datos

## Objetivo
Explicar cómo la aplicación se conecta a PostgreSQL mediante Spring Data JPA.

## 1. Repositorio JPA
La capa de persistencia se basa en `JpaRepository`.

```java
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
```

## 2. Operaciones CRUD
El repositorio permite hacer operaciones básicas sobre la base de datos.

```java
clienteRepository.save(cliente);
clienteRepository.findAll();
clienteRepository.findById(id);
clienteRepository.saveAll(listaClientes);
clienteRepository.delete(cliente);
```

## 3. Servicio de acceso a datos

```java
@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }

    public List<Cliente> addClientes(List<Cliente> nuevosClientes) {
        return clienteRepository.saveAll(nuevosClientes);
    }
}
```

## 4. Relación con PostgreSQL
La conexión se realiza en `application.properties` y Hibernate crea o actualiza la estructura de la base de datos.

```properties
spring.datasource.url=jdbc:postgresql://localhost:5433/proyectoSpring
spring.datasource.username=postgres
spring.datasource.password=1208
spring.jpa.hibernate.ddl-auto=update
```

## Imagen de referencia
![Conexión a PostgreSQL](./imagenes/base-de-datos.png)

> Inserta aquí una imagen de la base de datos o del esquema de conexión.
