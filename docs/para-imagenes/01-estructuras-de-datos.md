# Implementación de estructuras de datos

## Objetivo
Explicar cómo se usan las estructuras principales de Java dentro del proyecto para manejar la información de clientes.

## 1. Listas
La clase `ClienteService` usa `List<Cliente>` para devolver todos los clientes registrados.

```java
public List<Cliente> getClientes() {
    return clienteRepository.findAll();
}
```

## 2. Conjuntos
También se usa `Set<Cliente>` para comparar clientes con un nivel superior.

```java
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
```

## 3. Cadenas y enums
Los atributos nombre, apellido y correo son cadenas, y el nivel del cliente se representa con un enum.

```java
public enum NivelCliente {
    PLATA(1),
    ORO(2),
    DIAMANTE(3);
}
```

## 4. Arreglos, colas y mapas
En la versión final del proyecto se puede complementar con estructuras adicionales para mostrar un dominio completo:

```java
Cliente[] clientesArray = clientes.toArray(new Cliente[0]);
Queue<Cliente> cola = new ArrayDeque<>();
Map<Long, Cliente> mapaClientes = new HashMap<>();
```

## Imagen de referencia
![Diagrama de estructuras de datos](./imagenes/estructuras-de-datos.png)

> Coloca aquí la imagen o diagrama que corresponda al tema.
