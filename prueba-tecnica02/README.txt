Palindrome Microservice
DESCRIPCIÓN:
Este proyecto es un microservicio desarrollado en Spring Boot que recibe una cadena de texto en formato JSON,
evalúa si es un palíndromo, calcula la longitud total de la cadena y la cantidad de caracteres especiales presentes.
La API está documentada utilizando Springdoc OpenAPI para Swagger UI.

REQUISITOS:
Java 17
Maven 3.6+
IDE con soporte para SpringBoot (IntelliJ IDEA, Eclipse, etc.)

EJECUCIÓN DEL PROYECTO
Para ejecutar el proyecto localmente:

Clona el repositorio o descarga el proyecto.

Asegúrate de tener Java y Maven instalados en tu máquina.

Abre una terminal y ejecuta el siguiente comando para iniciar la aplicación:

mvn spring-boot:run

La aplicación se ejecutará en http://localhost:8080.

Puedes acceder a la documentación de la API mediante Swagger en la siguiente URL:

http://localhost:8080/swagger-ui/index.html

ENDPOINTS
POST /api/palindrome
Descripción: Recibe una cadena y devuelve información sobre si es un palíndromo, su longitud y la cantidad de caracteres especiales.
Entrada:

json:

{
  "palindromo": "anita lava la tina"
}

Salida:

json:

{
  "lengthCadena": 18,
  "isPalindromo": 1,
  "lengthCaracteresEspeciales": 0
}