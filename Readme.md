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
    - `entity`: Define las entidades del dominio. Las entidades representan los objetos de negocio principales y contienen la lógica de negocio relacionada con esos objetos.
    - `useCase`: Contienen la lógica de aplicación específica que orquesta las operaciones entre las entidades y otras partes del sistema. Los casos de uso definen las acciones que se pueden realizar en el sistema y encapsulan las reglas de negocio.
    - `repository`: Define las interfaces que la capa de datos debe implementar para la persistencia de datos. Estas interfaces permiten que la lógica de negocio se mantenga independiente de la implementación de la capa de datos.
    - `dto`: Define los objetos de transferencia de datos.
      - `dto/request`: Contiene las clases que representan las solicitudes de datos que se reciben desde la capa de presentación o desde otras fuentes externas. Estas clases debe incluir validaciones y anotaciones para asegurar que los datos recibidos sean correctos.
      - `dto/response`: Contiene las clases que representan las respuestas de datos que se envían desde la capa de dominio hacia la capa de presentación o hacia otras fuentes externas. Estas clases deben estructurar los datos de manera que sean fácilmente consumibles por los clientes.


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

Es aceptable el uso de una capa transversal siempre y cuando:

- **No violente la separación de responsabilidades:** Las utilidades deben ser herramientas generales que no estén directamente ligadas a una capa específica de la arquitectura, como funciones de formato, validaciones comunes o herramientas de logging. Deben ser utilidades que no introduzcan dependencias directas entre las capas del sistema. 
- **Permitan la reutilización y no violen las reglas de la arquitectura:** Las utilidades deben estar desacopladas de la lógica de negocio y de la infraestructura. Si las utilidades se usan en las capas de dominio o aplicación, deben estar en una ubicación centralizada y bien definida, sin crear dependencias entre las capas de la arquitectura.
- **No contaminen el dominio:** En Clean Architecture, el dominio debe ser el núcleo del sistema y no debe depender de implementaciones externas (como bases de datos, interfaces de usuario, o servicios). Las utilidades transversales, en este caso, deberían evitar depender del dominio o la infraestructura, garantizando que la lógica de negocio no se vea afectada por ellas.

## Reglas de Comunicación entre Capas

En la arquitectura limpia, las reglas de comunicación entre capas son fundamentales para mantener la separación de responsabilidades y la independencia de las capas. Las reglas son las siguientes:

- **Dominio se comunica con Datos:** La capa de dominio puede comunicarse con la capa de datos a través de interfaces definidas en la capa de dominio.
- **Datos se comunica con Dominio:** La capa de datos implementa las interfaces definidas en la capa de dominio y puede comunicarse con la capa de dominio.
- **Dominio se comunica con Presentación:** La capa de dominio puede comunicarse con la capa de presentación a través de interfaces definidas en la capa de dominio.
- **Presentación se comunica con Dominio:** La capa de presentación puede comunicarse con la capa de dominio a través de interfaces definidas en la capa de dominio.
- **Presentación nunca se comunica con Datos:** La capa de presentación no debe comunicarse directamente con la capa de datos. Toda la comunicación debe pasar a través de la capa de dominio.

En resumen, se puede usar capas transversales, pero debe estar cuidadosamente diseñada para ser independiente de las capas más críticas (como el dominio) y no introducir dependencias que rompan el aislamiento de las capas.

## Reglas de Negocio y Lógica de Negocio

### Regla de Negocio

Una **regla de negocio** es una declaración que define o restringe algún aspecto del negocio. Describe las operaciones, definiciones y restricciones que se aplican a una organización con el propósito de alcanzar sus objetivos. Las reglas de negocio son específicas del dominio y son independientes de cualquier implementación técnica.

#### Características de las Reglas de Negocio:
- **Específicas del Dominio:** Reflejan las políticas, procedimientos y regulaciones de la organización.
- **Declarativas:** Definen lo que debe ser verdadero o falso, permitiendo o restringiendo ciertas acciones.
- **Independientes de la Tecnología:** No dependen de la tecnología o la implementación.

#### Ejemplos de Reglas de Negocio:
- Un cliente no puede tener más de una cuenta activa.
- Un pedido debe ser enviado dentro de los 3 días hábiles posteriores a su confirmación.

### Lógica de Negocio

La **lógica de negocio** es el conjunto de procesos, reglas y operaciones que se implementan en el software para cumplir con las reglas de negocio. La lógica de negocio toma las reglas de negocio y las convierte en código ejecutable que realiza las operaciones necesarias para cumplir con los requisitos del negocio.

#### Características de la Lógica de Negocio:
- **Implementación Técnica:** Es la implementación técnica de las reglas de negocio en el software.
- **Operacional:** Incluye las operaciones y procesos que manipulan los datos y ejecutan las reglas de negocio.
- **Dependiente del Contexto:** Puede variar según el contexto y la implementación específica del sistema.

#### Ejemplos de Lógica de Negocio:
- Un método que calcula el descuento aplicado a un producto y asegura que no exceda el 20%.


## Notas: 

> [ Entidades (Entities)]
> 
> Las entidades representan los objetos de negocio principales y contienen la lógica de negocio relacionada con esos objetos. Las entidades deben ser independientes de cualquier infraestructura o detalles de implementación. La lógica de negocio que se coloca en las entidades es aquella que es intrínseca al objeto mismo.


> [Casos de Uso (Use Cases)]
> 
> Los casos de uso (o interactores) contienen la lógica de aplicación específica que orquesta las operaciones entre las entidades y otras partes del sistema. Los casos de uso definen las acciones que se pueden realizar en el sistema y encapsulan las reglas de negocio. Los casos de uso son responsables de coordinar la interacción entre las entidades y los repositorios.

> [Repositorios (Repositories)]
>
> Los repositorios son responsables de la persistencia de datos y las interacciones con la base de datos. Los repositorios deben implementar interfaces definidas en la capa de dominio, pero no deben contener lógica de negocio. La lógica de negocio debe estar en las entidades y en los casos de uso.
> Ejemplo: Llamados o consumo de por cliente feing a un tercero, consultas a archivos de s3 para traer data, persistencias a DBS

## Requisitos

- Java 17 o superior
- Gradle 6.8 o superior

## Cómo ejecutar el proyecto

1. Clona el repositorio:
    ```sh
    git clone <URL_DEL_REPOSITORIO>
    ```
2. Navega al directorio del proyecto:
    ```sh
    cd clean-architecture-spring-boot-gradle
    ```
3. Compila el proyecto:
    ```sh
    ./gradlew build
    ```
4. Ejecuta la aplicación:
    ```sh
    ./gradlew bootRun
    ```

## Contribuciones

Las contribuciones son bienvenidas. Por favor, abre un issue o envía un pull request para discutir cualquier cambio que desees realizar.

## Enlace al Grupo de GitLab

Puedes encontrar más información y colaborar en el proyecto en nuestro [grupo de GitLab](https://gitlab.com/aws-developer).

## Autor

Este proyecto fue desarrollado por **Fredy Mauricio Garcia Moná**.

## Licencia

Este proyecto está licenciado bajo la Licencia MIT. Consulta el archivo `LICENSE` para más detalles.