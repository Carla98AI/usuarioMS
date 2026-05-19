BLOOM - usuarioMS

Descripción del proyecto

BLOOM es un sistema de gestión de bienestar personal desarrollado mediante arquitectura de microservicios utilizando Java Spring Boot.

Este repositorio corresponde al microservicio usuarioMS, encargado de la administración de usuarios del sistema.

----- El microservicio permite:-----

Registrar usuarios
Listar usuarios
Buscar usuarios por ID
Actualizar información
Eliminar usuarios
Exponer DTOs para comunicación entre microservicios mediante OpenFeign

-----Tecnologías utilizadas----
Java 17
Spring Boot 3.2.5
Spring Data JPA
MySQL
Maven
Lombok
----Puerto del microservicio----

8081

---Base de datos-----

usuarios_db

----Endpoints principales----

GET /api/v1/usuarios

GET /api/v1/usuarios/{id}

GET /api/v1/usuarios/dto/{id}

POST /api/v1/usuarios

PUT /api/v1/usuarios/{id}

DELETE /api/v1/usuarios/{id}

------Estructura del proyecto-----
controller/
service/
repository/
model/
dto/
config/

-----Funcionalidades implementadas----
CRUD completo de usuarios
Integración con MySQL
DTO para comunicación Feign
DataLoader para carga automática de datos
Validación para evitar duplicación de registros

-----Ejecución-----
Crear base de datos usuarios_db
Configurar application.properties
Ejecutar UsuarioMsApplication.java
Probar endpoints en Postman

Carla Acuña

Desarrollo Fullstack I - Duoc UC
