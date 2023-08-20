# QuizzSpringBootApi

Esta es una API de Quizzes desarrollada con Spring Boot y MySQL. Proporciona endpoints para crear, obtener y administrar preguntas y respuestas para diferentes cuestionarios.

## Tecnologías utilizadas

- Spring Boot
- MySQL
- Maven

## Configuración

1. Clona el repositorio.

2. Configura la base de datos MySQL:
   - Crea una base de datos llamada `quizz`.
   - Actualiza las configuraciones de la base de datos en el archivo `application.properties` ubicado en `src/main/resources`.

3. Ejecuta la aplicación:
mvn spring-boot:run

markdown
Copy code

4. La API estará disponible en `http://localhost:8081/api/quizz`.

### Crear una pregunta

Crea una nueva pregunta y la asocia al cuestionario especificado.

- URL: `POST /api/quizzes/questions`
- Cuerpo de la solicitud: JSON que contiene la pregunta y el ID del cuestionario al que pertenece.
- Respuesta exitosa: Retorna la pregunta creada con su ID asignado.

### Obtener una pregunta

Obtiene una pregunta específica según su ID.

- URL: `GET /api/quizzes/questions/{questionId}`
- Parámetro de ruta: `questionId` (ID de la pregunta).
- Respuesta exitosa: Retorna la pregunta correspondiente al ID proporcionado.

### Crear una respuesta para una pregunta

Crea una respuesta asociada a una pregunta específica.

- URL: `POST /api/quizzes/questions/{questionId}/answers`
- Parámetro de ruta: `questionId` (ID de la pregunta).
- Cuerpo de la solicitud: JSON que contiene la respuesta y si es correcta o no.
- Respuesta exitosa: Retorna la respuesta creada con su ID asignado.

### Obtener respuestas para una pregunta

Obtiene todas las respuestas asociadas a una pregunta específica.

- URL: `GET /api/quizzes/questions/{questionId}/answers`
- Parámetro de ruta: `questionId` (ID de la pregunta).
- Respuesta exitosa: Retorna todas las respuestas asociadas a la pregunta correspondiente al ID proporcionado.

### Obtener una pregunta con respuestas

Obtiene una pregunta junto con todas sus respuestas asociadas.

- URL: `GET /api/quizzes/questions/{questionId}/details`
- Parámetro de ruta: `questionId` (ID de la pregunta).
- Respuesta exitosa: Retorna la pregunta y todas las respuestas asociadas a ella.

### Obtener todos los cuestionarios

Obtiene una lista de todos los cuestionarios disponibles.

- URL: `GET /api/quizzes/quizzes`
- Respuesta exitosa: Retorna una lista de cuestionarios.

### Obtener preguntas aleatorias de un cuestionario

Obtiene una lista de preguntas aleatorias asociadas a un cuestionario específico.

- URL: `GET /api/quizzes/quizzes/{quizId}/random-questions`
- Parámetro de ruta: `quizId` (ID del cuestionario).
- Respuesta exitosa: Retorna una lista de preguntas con respuestas aleatorias.

### Obtener preguntas aleatorias con respuesta correcta de un cuestionario

Obtiene una lista de preguntas aleatorias asociadas a un cuestionario específico, junto con la respuesta correcta para cada pregunta.

- URL: `GET /api/quizzes/quizzes/{quizId}/random-questions-answers`
- Parámetro de ruta: `quizId` (ID del cuestionario).
- Respuesta exitosa: Retorna una lista de preguntas con respuestas aleatorias y la respuesta correcta para cada pregunta.

### Obtener preguntas aleatorias con todas las respuestas de un cuestionario

Obtiene una lista de preguntas aleatorias asociadas a un cuestionario específico, junto con todas sus respuestas.

- URL: `GET /api/quizzes/quizzes/{quizId}/random-questions-and-answers`
- Parámetro de ruta: `quizId` (ID del cuestionario).
- Respuesta exitosa: Retorna una lista de preguntas con todas las respuestas y la respuesta correcta para cada pregunta.


## Contribución

Si quieres contribuir a este proyecto, siéntete libre de realizar un fork y enviar tus pull requests..

API SpringBoot creada por @DogeDrake en GitHub y Twitter

¡Disfruta usando la API de Quizzes!
