# 📂 Gestor de Archivos XML en Java

Este proyecto implementa un sistema en Java que permite **leer y escribir archivos XML**. Es una herramienta sencilla pero útil para gestionar información estructurada como películas, actores y usuarios.

## 🔧 Características

- ✅ Escritura de archivos XML desde objetos Java (`Película`, `Usuario`, `Actor`, etc.)
- ✅ Lectura de archivos XML y reconstrucción de los objetos en memoria.
- ✅ Estructura modular: clases separadas por modelo y lógica XML.
- ✅ Uso de `DocumentBuilder` para crear árboles DOM y `Transformer` para escribir archivos XML.
- ✅ Manejo de excepciones comunes como `IOException`, `SAXException` y `ParserConfigurationException`.


## 🚀 Cómo usar

1. Clona el repositorio.
2. Abre el proyecto en tu IDE favorito (recomendado: IntelliJ IDEA).
3. Ejecuta los métodos `lecturaXML()` y `escrituraXML()` desde la clase `OperacionesXML`.
4. Verifica que los archivos `peliculas.xml` y `usuarios.xml` se crean correctamente con los datos.

## 📌 Requisitos

- Java 8 o superior.
- No se requiere ninguna librería externa (solo APIs estándar de Java).

## 📷 Ejemplo de salida

Ejemplo de archivo `peliculas.xml` generado:

xml
<peliculas>
    <pelicula>
        <titulo>Matrix</titulo>
        <anio>1999</anio>
        <actores>
            <actor>
                <nombre>Keanu</nombre>
                <apellido>Reeves</apellido>
            </actor>
        </actores>
    </pelicula>
</peliculas>

📜 Licencia

Este proyecto se distribuye bajo la licencia MIT. Puedes usarlo, modificarlo y distribuirlo libremente citando la fuente.

