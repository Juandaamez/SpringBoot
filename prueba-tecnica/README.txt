Prueba Técnica - Backend Junior

DESCRIPCION:
Este proyecto es una prueba técnica que consiste en consumir una API externa usando Spring Boot,
exponer un nuevo endpoint, manejar errores, implementar un sistema de caché y realizar pruebas unitarias.
Además, la API está documentada utilizando Springdoc OpenAPI para Swagger UI.

REQUISITOS:
- Java 17
- Maven 3.6+
- IDE con soporte para SpringBoot

PLUGIN LOOMBOK (INTELLIJ IDEA)
Es necesario instalar el plugin de Lombok para que las anotaciones de Lombok funcionen correctamente
en tu entorno de desarrollo.

Pasos para instalar el plugin de Lombok en IntelliJ IDEA:
1. Ve a `File > Settings > Plugins`.
2. En la barra de búsqueda, escribe `Lombok`.
3. Selecciona el plugin de Lombok y haz clic en `Install`.
4. Reinicia IntelliJ IDEA.
5. Asegúrate de que `Lombok` está habilitado en la configuración del proyecto:
    - Ve a `File > Settings > Build, Execution, Deployment > Compiler > Annotation Processors`.
    - Marca la opción `Enable annotation processing`.


INSTALACIÓN
1. Clona este repositorio:

    git clone https://github.com/Juandaamez/SpringBoot/tree/5b8288d4aa299ec7383ebec1210aaa48d0845a75/prueba-tecnica

2. Accede al directorio del proyecto:

    cd prueba-tecnica

3. Compila el proyecto y descarga las dependencias con Maven:

    mvn clean install

4. Verifica que el plugin de Lombok esté correctamente configurado en tu IDE (ver la sección "Plugin de Lombok").

EJECUCION DEL PROYECTO
Para ejecutar el proyecto localmente:

1. Ejecuta el siguiente comando para iniciar la aplicación:

    mvn spring-boot:run

2. La aplicación se ejecutará en [http://localhost:8080]

3. Puedes acceder a la documentación del API mediante Swagger en:

    http://localhost:8080/swagger-ui/index.html

ENDPOINTS
- URL: `/api/users`
- Método: `GET`
- Descripción: Obtiene una lista de usuarios desde la API externa JSONPlaceholder.
- Respuesta: JSON con la lista de usuarios.

SISTEMA DE CACHE
El sistema de caché está implementado para almacenar la respuesta de la API durante 5 minutos, lo que reduce las solicitudes repetidas a la API externa. Puedes modificar la configuración del caché en el archivo `application.properties`:

spring.cache.type=simple

PRUEBAS
Este proyecto incluye pruebas unitarias para el servicio de usuarios utilizando JUnit 5 y Mockito.

Para ejecutar las pruebas unitarias, usa el siguiente comando:

mvn test

Los resultados de las pruebas se mostrarán en la consola




