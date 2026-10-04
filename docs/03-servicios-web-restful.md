# Implementación de servicios web RESTful

La capa web de la aplicación se encarga de exponer endpoints para consultar, crear, actualizar y eliminar clientes.

## 1. Controlador principal

La clase `ClienteController` usa la anotación `@RestController` para devolver JSON directamente.

```java
package com.proyecto.controllers;

import java.util.List;
import java.util.Set;

import com.proyecto.models.*;
import org.springframework.web.bind.annotation.*;

import com.proyecto.service.ClienteService;

@RestController
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
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
    public List<Cliente> addClientes(@PathVariable("id") long id, @RequestBody Cliente clienteNuevo) {
        return clienteService.updateClientes(id, clienteNuevo);
    }

    @DeleteMapping("/deleteUser/{id}")
    public List<Cliente> addClientes(@PathVariable("id") long id) {
        clienteService.deleteClientes(id);
        return clienteService.getClientes();
    }
}
```

## 2. Endpoints principales

### Obtener todos los clientes
```http
GET /getUsers
```

### Obtener un cliente por id
```http
GET /getUser/1
```

### Crear un cliente
```http
POST /addUser
Content-Type: application/json
```

```json
{
  "nombre": "Ana",
  "apellido": "García",
  "edad": 28,
  "correo": "ana@gmail.com",
  "nivel": "ORO"
}
```

### Crear varios clientes a la vez
```http
POST /addUsers
Content-Type: application/json
```

```json
[
  {
    "nombre": "Ana",
    "apellido": "García",
    "edad": 28,
    "correo": "ana@gmail.com",
    "nivel": "ORO"
  },
  {
    "nombre": "Luis",
    "apellido": "Pérez",
    "edad": 32,
    "correo": "luis@gmail.com",
    "nivel": "DIAMANTE"
  }
]
```

## 3. Beneficios de la API REST

- Permite comunicación con un cliente web o móvil.
- Maneja datos en formato JSON.
- Facilita la integración con aplicaciones externas.
- Mantiene una estructura clara de recursos y operaciones.

La API REST de este proyecto expone un conjunto de operaciones CRUD sobre la entidad `Cliente` con una lógica orientada a servicios.
