# Clean Architecture Spring Boot Project

Este proyecto sigue una arquitectura de referencia de "Clean Architecture" o "Arquitectura Limpia". Esta arquitectura se centra en la separación de responsabilidades y la independencia de los detalles de implementación.

## Estructura central

- **Capa de Presentación:** Maneja la interacción con el usuario.
- **Capa de Dominio:** Contiene la lógica de negocio central.
- **Capa de Datos:** Maneja la persistencia de datos.
- **Capa de Utilidades:** Proporciona herramientas y utilidades comunes.

## Definicion y Responsabilidad de cada capa

### Capa de Presentación (Presentation Layer)
- **Responsabilidad:** Manejar la interacción con el usuario, recibir las solicitudes HTTP y devolver las respuestas HTTP.
- **Subcarpetas y Responsabilidades:**
    - `controller`: Contiene los controladores REST que manejan las solicitudes HTTP.
    - `exception`: Maneja las excepciones globales y proporciona respuestas de error consistentes.

### Capa de Dominio (Domain Layer)
- **Responsabilidad:** Contiene la lógica de negocio central y las reglas de negocio.
- **Subcarpetas y Responsabilidades:**
    - `entity`: Define las entidades del dominio.
    - `repository`: Define las interfaces de los repositorios que serán implementadas en la capa de datos.
    - `service`: Contiene las implementaciones de los servicios de negocio.
    - `request`: Define las clases que representan las solicitudes de datos.
    - `response`: Define las clases que representan las respuestas de datos.

### Capa de Datos (Data Layer)
- **Responsabilidad:** Manejar la persistencia de datos y las interacciones con la base de datos.
- **Subcarpetas y Responsabilidades:**
    - `repository`: Contiene las implementaciones de los repositorios que interactúan con la base de datos.
    - `config`: Contiene las configuraciones necesarias para la conexión con la base de datos y otros servicios.

### Capa de Utilidades (Utilities Layer)
- **Responsabilidad:** Proporcionar utilidades y herramientas comunes que pueden ser utilizadas por otras capas.
- **Subcarpetas y Responsabilidades:**
    - `utils`: Contiene clases de utilidad y generadores de respuestas.

## Arquitectura de Referencia

La arquitectura de referencia es la "Clean Architecture" propuesta por Robert C. Martin (Uncle Bob). Esta arquitectura se caracteriza por:

- **Independencia de Frameworks:** La arquitectura no depende de ningún framework específico, lo que facilita el cambio de frameworks en el futuro.
- **Testabilidad:** La lógica de negocio puede ser probada de manera independiente de los detalles de implementación.
- **Independencia de la UI:** La lógica de negocio no depende de la interfaz de usuario, lo que permite cambiar la UI sin afectar la lógica de negocio.
- **Independencia de la Base de Datos:** La lógica de negocio no depende de la base de datos, lo que permite cambiar la base de datos sin afectar la lógica de negocio.
- **Independencia de Agentes Externos:** La lógica de negocio no depende de agentes externos, lo que permite cambiar estos agentes sin afectar la lógica de negocio.


## Capas adicionales

En la arquitectura limpia (Clean Architecture), el enfoque principal es separar las preocupaciones en capas o componentes distintos, cada uno con responsabilidades claramente definidas. Esta separación ayuda a mantener la independencia de las dependencias, facilitando la prueba, el mantenimiento y la evolución del sistema, para la siguiente explicacion tomaremos como ejemplo la capa de utilidades.

En la aquitectura limpia es aceptable el uso de una capa transversal siempre y cuando:

- **No violente la separación de responsabilidades:** Las utilidades deben ser herramientas generales que no estén directamente ligadas a una capa específica de la arquitectura, como funciones de formato, validaciones comunes o herramientas de logging. Deben ser utilidades que no introduzcan dependencias directas entre las capas del sistema. 
- **Permitan la reutilización y no violen las reglas de la arquitectura:** Las utilidades deben estar desacopladas de la lógica de negocio y de la infraestructura. Si las utilidades se usan en las capas de dominio o aplicación, deben estar en una ubicación centralizada y bien definida, sin crear dependencias entre las capas de la arquitectura.
- **No contaminen el dominio:** En Clean Architecture, el dominio debe ser el núcleo del sistema y no debe depender de implementaciones externas (como bases de datos, interfaces de usuario, o servicios). Las utilidades transversales, en este caso, deberían evitar depender del dominio o la infraestructura, garantizando que la lógica de negocio no se vea afectada por ellas.

En resumen, se puede usar capas transversales, pero debe estar cuidadosamente diseñada para ser independiente de las capas más críticas (como el dominio) y no introducir dependencias que rompan el aislamiento de las capas.
