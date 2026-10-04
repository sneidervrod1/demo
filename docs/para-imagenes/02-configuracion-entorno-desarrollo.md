# Configuración de un entorno de desarrollo

## Objetivo
Describir la configuración mínima necesaria para ejecutar la aplicación Java con Spring Boot y PostgreSQL.

## 1. Dependencias principales
El proyecto usa Spring Boot Starter Web, JPA y PostgreSQL.

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-webmvc</artifactId>
</dependency>

<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <scope>runtime</scope>
</dependency>
```

## 2. Configuración de la base de datos
En el archivo application.properties se define la conexión.

```properties
spring.datasource.url=jdbc:postgresql://localhost:5433/proyectoSpring
spring.datasource.username=postgres
spring.datasource.password=1208
spring.jpa.hibernate.ddl-auto=update
```

## 3. Ejecución del proyecto

```bash
./mvnw spring-boot:run
```

## 4. Requisitos del entorno
- Java 18
- Maven
- PostgreSQL
- IDE (VS Code, IntelliJ)

## Imagen de referencia
![Entorno de desarrollo](./imagenes/entorno-desarrollo.png)

> Inserta una imagen del entorno, la base de datos o la estructura del proyecto.
