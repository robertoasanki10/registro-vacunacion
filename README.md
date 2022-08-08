# inventario-kg-web

Este proyecto fue generado con Spring Boot 2.7.2 (https://start.spring.io/) y utiliza Java en su versión número 11.

Está creado con el IDE de desarrollo Spring Tool Suite 4 Version: 4.15.1.RELEASE basado en Eclipse (https://spring.io/tools)
Se conecta a una base de datos local PostgreSQL version 14 (https://www.enterprisedb.com/downloads/postgres-postgresql-downloads)

## Development server
La aplicación corre en el puerto 8580 
Para cambiar las propiedades de la conexión con la base de datos se debe modificar el archivo applicattion.properties
Para ver el catálogo de servicios se puede visualizar en 'http://localhost:8580/swagger-ui/index.html#/'
Para abrir la aplicación es necesario descargra el proyecto de GitHub y descargar el ide de desarrollo e importarlo.
El IDE trae un servidor incluido que permite desplegar la aplicación mediante la interfaz gráfica o ejecutando el archivo mvnw.cmd en windows o mvnw en Linux.
El archivo applicattion.properties está con la propiedad spring.jpa.hibernate.ddl-auto=create-drop para que genere el modelo de datos cada vez que se suba el servidor, se puede actualizar a spring.jpa.hibernate.ddl-auto=update para que no se pierdan los datos de pruebas.
