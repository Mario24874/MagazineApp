## MagazineApp - Reto 1: Verificador de Reportes con JavaFX

Este proyecto es una solución al Reto 1, que consiste en verificar si un texto (`report`) puede escribirse utilizando únicamente los caracteres disponibles en otro texto (`magazine`). La aplicación utiliza una interfaz gráfica construida con JavaFX y está gestionada con Maven.

## Descripción

La aplicación permite al usuario ingresar dos textos:
- **Report**: El texto que se desea escribir.
- **Magazine**: El texto fuente que proporciona los caracteres.
Al hacer clic en "Check", se verifica si el `report` puede formarse con los caracteres del `magazine`, mostrando el resultado en la interfaz.

### Ejemplo
- **Report**: "hello"
- **Magazine**: "helloworld"
- **Resultado**: `Can write report: true` (porque "helloworld" tiene suficientes h:1, e:1, l:2, o:1 para formar "hello").
- **Report**: "hellod"
- **Magazine**: "helloworl"
- **Resultado**: `Can write report: false` (porque "helloworl" no tiene una 'd').

## Requisitos

- **Java**: JDK 17 (recomendado: Eclipse Adoptium OpenJDK 17.0.14).
- **Maven**: Versión 3.8.6 o superior (probado con 3.9.9).
- **Sistema operativo**: Windows 10 (compatible con otros sistemas con ajustes menores).
- **IDE**: Visual Studio Code (opcional, con la extensión "Java Extension Pack").

## Instalación

### Configurar el entorno
1. Asegúrate de tener JDK 17 instalado y configurado en `JAVA_HOME`:
JAVA_HOME=C:\Program Files\Eclipse Adoptium\jdk-17.0.14.7-hotspot
2. Agrega `JAVA_HOME\bin` al `Path`.
3. Instala Maven y agrega su directorio `bin` al `Path` (ejemplo: `E:\apache-maven-3.9.9\bin`).
4. **Clonar el repositorio**:
Desde tu terminal escribe: 
git clone https://github.com/Mario24874/MagazineApp.git
cd MagazineApp
5. Compilar el proyecto.
Desde tu terminal escribe:
mvn clean install

## Ejecución

### Ejecutar la aplicación
1. Corre el siguiente comando:
mvn javafx:run
Esto abrirá una ventana con la interfaz gráfica.

### Uso
- Ingresa el texto del report en el primer campo.
- Ingresa el texto del magazine en el segundo campo.
- Haz clic en "Check" para verificar el resultado.

## Estructura principal del proyecto

MagazineApp/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── example/
│   │               └── MagazineApp.java  # Código principal 
│   └── test/           # Carpeta de pruebas
├── target/             # Directorio creado por Maven al compilar
├── pom.xml             # Configuración de Maven y dependencias
└── README.md           # Este archivo

## Dependencias

- JavaFX: org.openjfx:javafx-controls:17 y org.openjfx:javafx-fxml:17 para la interfaz gráfica.
- Maven Compiler Plugin: Compila el código con Java 17.
- JavaFX Maven Plugin: Ejecuta la aplicación JavaFX.

## Lógica del algoritmo

El método canWriteReport en la clase MagazineReport verifica si report puede formarse con los caracteres de magazine:

- Crea un arreglo de conteo (charCount) para los 128 caracteres ASCII.
- Cuenta los caracteres disponibles en magazine.
- Resta los caracteres requeridos por report.
- Si un carácter no está disponible (conteo = 0), retorna false.
- Si todos los caracteres se pueden usar, retorna true.

## Referencia investigada

La solución en Java se basa en un problema clásico de algoritmos conocido como "Ransom Note" (nota de rescate). Este problema consiste en determinar si podemos formar una cadena (el informe) usando los caracteres de otra cadena (la revista), verificando que todos los caracteres del informe estén disponibles en la revista en la cantidad necesaria. La implementación utiliza un arreglo de conteo para optimizar la verificación, con una complejidad de O(n + m), donde n es la longitud de magazine y m es la longitud de report. Esta técnica es común en problemas de comparación de frecuencias de caracteres.

## Notas

- El proyecto se desarrolló en Windows 10 con CMD, ya que PowerShell presentó problemas al interpretar el comando mvn archetype:generate. Se recomienda usar CMD para ejecutar comandos Maven en este entorno.
- La interfaz gráfica usa JavaFX para proporcionar una experiencia interactiva al usuario.
