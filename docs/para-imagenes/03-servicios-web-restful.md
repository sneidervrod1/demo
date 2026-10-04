# Implementación de servicios web RESTful

## Objetivo
Mostrar la forma en que la API expone operaciones CRUD para gestionar clientes mediante HTTP.

## 1. Controlador REST
El controlador usa anotaciones para mapear rutas y operaciones.

```java
@RestController
public class ClienteController {

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
    public List<Cliente> updateClientes(@PathVariable("id") long id, @RequestBody Cliente clienteNuevo) {
        return clienteService.updateClientes(id, clienteNuevo);
    }

    @DeleteMapping("/deleteUser/{id}")
    public List<Cliente> deleteClientes(@PathVariable("id") long id) {
        clienteService.deleteClientes(id);
        return clienteService.getClientes();
    }
}
```

## 2. Métodos HTTP utilizados
- GET para consultar
- POST para crear
- PUT para actualizar
- DELETE para eliminar

## 3. Ejemplo de request JSON

```json
[
  {
    "nombre": "Ana",
    "apellido": "García",
    "edad": 28,
    "correo": "ana@gmail.com",
    "nivel": "ORO"
  }
]
```

## Imagen de referencia
![API REST del proyecto](./imagenes/api-rest.png)

> Añade una imagen del flujo de las peticiones o de Postman/Insomnia.
