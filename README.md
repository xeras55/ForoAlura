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

| Va         | imagen perrona |
| ---------- | -------------- |
| Java       |                |
| MySql      |                |
| SpringBoot |                |

## EndPoints

| EndPoints                 | Descripcion                                             | Rol                   | Metodo |
| ------------------------- | ------------------------------------------------------- | --------------------- | ------ |
| /duda/dudaAll             | Permite ver todas las consultas de los ususarios        | INVITED, USER y ADMIN | Get    |
| /duda/dudaByIdDto/{id}    | Permite ver las consiltas filtradas por id              | INVITED, USER y ADMIN | Get    |
| /newDuda/newD             | Permite crear una consulta                              | USER y ADMIN          | Post   |
| /newD/actualizarDuda/{id} | Permite actualizar o cambiar los valores de la consulta | USER y ADMIN          | Put    |
| /newD/deletDuda/{id}      | Permite borrat la consulta                              | USER y ADMIN          | Delete |
| /usuarios/crearUsuario    | Permite crear un nuevo usuario por                      | INVITED y ADMIN       | Post   |
