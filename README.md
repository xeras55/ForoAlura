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

## Aplicacion

#### Registro de usuario

![Registro de Usuario](src/main/resources/images/registroUsuario.png "Hover text")

Creamos un usuario con los datos solicitados

#### Busqueda sin token

![Consulta sin Token](src/main/resources/images/consultaSinToken.png "Hover text")

intentamos acceder sin previamente conseguir un token y nos arroja un error

#### Autenticacion y autorizacion con token

![Conseguir Token](src/main/resources/images/conseguirToken.png "Hover text")

Hacemos la autenticacion y conseguimos autorizacion por medio del token

![Acceso con Token](src/main/resources/images/accesoConToken.png "Hover text")

Ingresamos el token y nos da el acceso a consultas

#### Busqueda de todas las consultas

![Buscar Todas las Dudas](src/main/resources/images/buscarTodasDudas.png "Hover text")

Aqui ya podemos realizar busquedas sin embargo estas nos arrojan informacion incesesaria en este caso en particulas

#### Busqueda con Id

![Buscar Duda por ID](src/main/resources/images/buscarDudaId.png "Hover text")

Aqui en base a lo visto en el punto anterior ya aplicamos un patron DTO para poder filtrar la informacion recivida y mostrar mejor los datos sin informacion inecesaria

#### Actualizar consulta

![Duda Actualizada](src/main/resources/images/dudaActualizada.png "Hover text")

En el punto anterior buscamos la consulta con id 3 aqui la actualizamos y podemos ver que mantiene el mismo id

#### Creacion de consulta

![Creación de Nueva Consulta](src/main/resources/images/creacionNuevaConsulta.png "Hover text")

Creamos una nueva consulta



#### 

#### 
