# QuizzSpringBootApi

Esta es una API de Quizzes desarrollada con Spring Boot y MySQL. Proporciona endpoints para crear, obtener y administrar preguntas y respuestas para diferentes cuestionarios.

## Tecnologías utilizadas

- Spring Boot
- MySQL
- Maven

## Configuración

1. Clona el repositorio.

2. Configura la base de datos MySQL:
   - Crea una base de datos llamada `quizzes`.
   - Actualiza las configuraciones de la base de datos en el archivo `application.properties` ubicado en `src/main/resources`.

3. Ejecuta la aplicación:
mvn spring-boot:run

markdown
Copy code

4. La API estará disponible en `http://localhost:8081/api/quizz`.

## Endpoints

### Crear una pregunta

- URL: `POST /api/quizzes/questions`
- Cuerpo de la solicitud: JSON que contiene la pregunta y el ID del cuestionario al que pertenece.
- Respuesta exitosa: Retorna la pregunta creada con su ID asignado.

### Obtener una pregunta

- URL: `GET /api/quizzes/questions/{questionId}`
- Parámetro de ruta: `questionId` (ID de la pregunta).
- Respuesta exitosa: Retorna la pregunta correspondiente al ID proporcionado.

### Crear una respuesta para una pregunta

- URL: `POST /api/quizzes/questions/{questionId}/answers`
- Parámetro de ruta: `questionId` (ID de la pregunta).
- Cuerpo de la solicitud: JSON que contiene la respuesta y si es correcta o no.
- Respuesta exitosa: Retorna la respuesta creada con su ID asignado.

### Obtener respuestas para una pregunta

- URL: `GET /api/quizzes/questions/{questionId}/answers`
- Parámetro de ruta: `questionId` (ID de la pregunta).
- Respuesta exitosa: Retorna todas las respuestas asociadas a la pregunta correspondiente al ID proporcionado.

### Obtener una pregunta con respuestas

- URL: `GET /api/quizzes/questions/{questionId}/details`
- Parámetro de ruta: `questionId` (ID de la pregunta).
- Respuesta exitosa: Retorna la pregunta y todas las respuestas asociadas a ella.

## Contribución

Si quieres contribuir a este proyecto, siéntete libre de realizar un fork y enviar tus pull requests..

¡Disfruta usando la API de Quizzes!
