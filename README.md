# Challenge ONE | Back End | Foro Alura

Aqui presento mi solucion a el reto propuesto por parte de Alura Latam en la formacion Backend, en el cual se nos pidio que hicieramos una API REST, en la cual trabaja con el foro de Alura donde podremos plasmar nuestras dudas referente a los temas tratados en las clases.

## Requerimentos

- Crear una publicacion donde vengan las dudas de los usuarios

- Estas tienen que esta relacionadas con algun curso dentro de la plataforma

- Mostrar todas la publicaciones creadas

- Mostrar publicaciones por medio de un id

- Actualizar los datos de una publicacion

- Eliminar una publicacion

- Manejo excepciones

## Requerimentos de Seguridad

- Autenticacion con usuario y contraseña

- Manejo de contraseñas con encriptacion BCrypt Password Encoder

- Asignar Rol a cada usuario

- Autorizacion JSON Web Tokens (JWT)

### tecnologias usadas

| VsCode     | ![VSCode Icon](src/main/resources/images/file_type_vscode_icon_130084.ico "Hover text")     |
| ---------- | ------------------------------------------------------------------------------------------- |
| Java       | ![Java Icon](src/main/resources/images/java_original_logo_icon_146458.ico "Hover text")     |
| MySql      | ![MySQL Workbench Icon](src/main/resources/images/mysqlworkbench_103806.ico "Hover text")   |
| SpringBoot | ![Spring Boot Icon](src/main/resources/images/icons8-spring-boot-color-32.png "Hover text") |

## EndPoints

| EndPoints                 | Descripcion                                             | Rol                   | Metodo |
| ------------------------- | ------------------------------------------------------- | --------------------- | ------ |
| /duda/dudaAll             | Permite ver todas las consultas de los ususarios        | INVITED, USER y ADMIN | Get    |
| /duda/dudaByIdDto/{id}    | Permite ver las consiltas filtradas por id              | INVITED, USER y ADMIN | Get    |
| /newDuda/newD             | Permite crear una consulta                              | USER y ADMIN          | Post   |
| /newD/actualizarDuda/{id} | Permite actualizar o cambiar los valores de la consulta | USER y ADMIN          | Put    |
| /newD/deletDuda/{id}      | Permite borrat la consulta                              | USER y ADMIN          | Delete |
| /usuarios/crearUsuario    | Permite crear un nuevo usuario por                      | INVITED y ADMIN       | Post   |

### Aplicacion

#### Registro de usuario

#### Busqueda sin token

#### Autenticacion y autorizacion con token

#### Busqueda de todas las consultas

#### Busqueda con Id

#### Actualizar consulta

#### Creacion de consulta



#### 

#### 
