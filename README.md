Backend de heroes
=================
Para iniciar el proyecto, los datos de la base de datos se encuentran dentro de la carpeta database, hay se encuentra el 
archivo docker-compose.yml con la configuración contenedor que descarga una imagen Mysql 8 o última versión y la creación de la 
base de datos “héroes” con un usuario y contraseña, así como la contraseña del usuario root, también se debe cambiar la 
ruta de ***volumes*** para colocar la ruta local donde se almacena la Base de datos localmente y que pueda ser accedida por el contenedor. 

El servidor local envía peticiones por el puerto 3308 y el contenedor responde por el 3306 que es el puerto default de MYSQL)

El archivo tablas_database_heroes.sql contiene las tablas necesarias para el funcionamiento de los servicios expuestos
los Archivos insert_* son los sql con data de prueba para la prueba de los servicios.

* docker-compose
* insert_family
* insert_heroe
* tablas_database_heroes

configuración de heroes backend
-------------------------------
<<<<<<< HEAD
los recursos de La aplicacion fueron inicialmente creado desde (https://spring.io/projects/spring-boot)  y la opción Spring Web Services
por lo tanto tiene incorporado un servidor tomcat que responde a la url "http://localhost:8081/", esta configuración se encuentra en el 
archivo src/main/resources/application.properties, donde se encuentran los datos de configuración de la Base de datos y el puerto por el cual responden los datos;
=======
los recursos de la aplicación fueron inicialmente creado desde (https://spring.io/projects/spring-boot)  y la opción Spring Web Services,
por lo tanto tiene incorporado un servidor Tomcat que responde a la url "http://localhost:8081/", esta configuración se encuentra en el 
archivo src/main/resources/application.properties, donde se encuentran los datos de configuración de la Base de datos y el puerto por el cual responden los servicios;
>>>>>>> ee131c0... se agrega mas contenido al archivo readme
también se agregaron las depencias:

* Spring web
* Spring Data Jpa 
* MySQL Driver

dentro del archivo pom.xml se cuentran las dependencias del proyecto por favor descargar y actualizarlas.

Una vez la aplicación sea funcional es posible visualizar los servicios y consumirlos mediante la vista del API Swagger2 Documentation 
con las URLs:

1. http://localhost:8081/swagger-ui.html para la vista y prueba de los servicios
2. http://localhost:8081/v2/api-docs para visualizar la estructura JSON de los servicios 

Si desea ver la parte funcional del proyecto en Front puede dirigirse al repositorio https://github.com/wtriana/heroesSpa

*****LISTO PARA TRABAJAR***** 


