# Clases asociadas a las operaciones de gestión de ficheros y directorios: creación, borrado, copia, movimiento, recorrido

La entrada y salida en Java sigue el mismo modelo que en Unix (basada en flujos). Así, la E/S en Java se basa en clases como `FileInputStream`, `FileOutputStream`, `BufferedReader`, `BufferedWriter`, `Scanner`, entre otras.

Java siempre está evolucionando y mejorando, y en cada versión se van introducido características nuevas o bibliotecas adicionales para simplificar la E/S de archivos. Por lo tanto, siempre es recomendable verificar la documentación oficial de la versión específica de Java que estés utilizando para obtener información sobre las últimas características y mejores prácticas en cuanto a E/S de archivos.

Nosotros en clase haremos lo siguiente:

**1. Utilizaremos las clases del paquete `java.nio.file`**: A partir de Java 7, se introdujo el paquete `java.nio.file` que proporciona clases como `Path`, `Files`, y `FileSystems` que ofrecen una API más moderna y versátil para trabajar con archivos y directorios.

**2. Usaremos try-with-resources**: Para garantizar que los recursos se cierren adecuadamente después de su uso, utiliza la declaración `try-with-resources` al trabajar con objetos que implementan la interfaz `AutoCloseable`. Esto garantiza que los flujos de E/S se cierren automáticamente al salir del bloque `try`, lo que hace que el código sea más limpio y seguro.

```java
try (BufferedReader reader = new BufferedReader(new FileReader("archivo.txt"))) {
    // Operaciones de lectura aquí
} catch (IOException e) {
    // Manejo de excepciones
}
```

**3. Utilizamos las clases `Buffered`**: Al realizar operaciones de E/S, es a menudo más eficiente utilizar clases que implementan el almacenamiento en búfer, como `BufferedReader` y `BufferedWriter`, para reducir el número de operaciones de E/S físicas. Cuando uses un búfer o caché recuerda que los datos se quedan temporalmente en memoria, por lo que habrá que asegurarse de volcar y/o cerrar el flujo de datos para no perder información. Un fallo muy común es no cerrar un archivo y al acabar el programa no se escriben todos los datos y, por tanto, perdemos información.

**4. Usamos `Files` para operaciones avanzadas**: La clase `Files` del paquete `java.nio.file` proporciona métodos muy cómodos para realizar operaciones avanzadas en archivos, como copiar, mover, eliminar y más.

**5. Utilizamos `java.util.Scanner` para entrada de texto**: La clase `Scanner` es útil para la lectura de datos formateados desde un archivo, ya que permite leer y analizar diferentes tipos de datos (enteros, flotantes, cadenas, etc.) de manera sencilla.

**6. Manejaremos adecuadamente las excepciones**: Siempre maneja las excepciones de E/S de archivos de manera adecuada, ya que pueden ocurrir errores durante la lectura o escritura. Considera usar bloques `try-catch` para capturar y manejar estas excepciones de manera adecuada.

Estas simplemente son algunas buenas prácticas para realizar E/S de archivos en Java. Éstas no son la úna opción posible, la elección de la clase y el patrón o metodología específica dependerá de las necesidades particulares y del tipo de E/S que estés realizando en nuestro proyecto. 

## Guardando información en un archivo

Vamos a ponernos manos a la masa. Veamos un ejemplo de cómo crear un archivo en Java. Lee atentamente el código e intenta averiguar qué hace:

```java
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GuardarEnArchivo {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java GuardarEnArchivo <nombre_del_archivo>");
            System.exit(1);
        }

        String nombreArchivo = args[0];

        try {
            // Abre un archivo para escritura
            BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo));

            System.out.println("Escribe el contenido a guardar en el archivo (Ctrl+D para finalizar en Linux/Mac o Ctrl+Z en Windows):");

            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                writer.write(linea);
                writer.newLine();
            }

            // Cierra el archivo
            writer.close();
            System.out.println("Contenido guardado en el archivo '" + nombreArchivo + "'.");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}

```

Efectivamente, como habrás podido averiguar, este programa toma un argumento de línea de comandos que debe ser el nombre del archivo en el que deseas guardar el contenido de la entrada estándar. Luego, utiliza un bucle while para leer líneas de la entrada estándar y escribirlas en el archivo. El programa termina cuando se alcanza el final de la entrada estándar (por ejemplo, cuando se presiona Ctrl+D en Linux/Mac o Ctrl+Z en Windows).

## Listando archivos y carpetas

Ahora vamos a complicarlo un poco más. Vamos a ver un ejemplo que, haciendo uso de recursividad, recorre todas las carpetas y subcarpetas de la carpeta que se pasa como parámetro:

```java
package com.iesvdc.acceso;

import java.io.File;

public class ListarContenidoRecursivo {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java ListarContenidoRecursivo <ruta_de_la_carpeta>");
            System.exit(1);
        }

        String rutaCarpeta = args[0];
        listarContenidoRecursivo(new File(rutaCarpeta));
    }

    public static void listarContenidoRecursivo(File carpeta) {
        if (carpeta.isDirectory()) {
            System.out.println("Carpeta: " + carpeta.getAbsolutePath());

            File[] archivos = carpeta.listFiles();
            if (archivos != null) {
                for (File archivo : archivos) {
                    listarContenidoRecursivo(archivo);
                }
            }
        } else if (carpeta.isFile()) {
            System.out.println("Archivo: " + carpeta.getAbsolutePath());
        }
    }
}
```

**Ejercicio de clase:** Intenta modificar el comando anterior para que produzca una salida similar al comando *tree* de Linux (ese comando va metiendo tabuladores o espacios en las subcarpetas de manera que se ve el listado como un árbol, de ahí el nombre del comando).


## Borrando archivos

Vamos a complicarlo un poco más, ahora vamos a modificar el programa anterior para que ahora tome dos parámetros: la ruta de la carpeta desde la cual se debe buscar y el nombre del archivo que se debe encontrar y eliminar si existe. Este programa utilizará la API de Java para trabajar con archivos y directorios. Aquí tienes el código:

```java
import java.io.File;

public class EliminarArchivo {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Uso: java EliminarArchivo <ruta_de_la_carpeta> <nombre_del_archivo>");
            System.exit(1);
        }

        String rutaCarpeta = args[0];
        String nombreArchivo = args[1];

        File carpeta = new File(rutaCarpeta);

        if (!carpeta.isDirectory()) {
            System.err.println("La ruta especificada no es una carpeta válida.");
            System.exit(1);
        }

        File archivo = new File(carpeta, nombreArchivo);

        if (archivo.exists() && archivo.isFile()) {
            if (archivo.delete()) {
                System.out.println("El archivo '" + nombreArchivo + "' ha sido eliminado con éxito.");
            } else {
                System.err.println("No se pudo eliminar el archivo '" + nombreArchivo + "'.");
            }
        } else {
            System.err.println("El archivo '" + nombreArchivo + "' no existe en la carpeta especificada.");
        }
    }
}
```

Este programa toma dos argumentos de línea de comandos: la ruta de la carpeta (`<ruta_de_la_carpeta>`) y el nombre del archivo que se debe eliminar (`<nombre_del_archivo>`). A continuación, verifica si la ruta especificada es una carpeta válida, luego intenta eliminar el archivo especificado si existe.

Asegúrate de proporcionar la ruta de la carpeta y el nombre del archivo correctamente en la línea de comandos al ejecutar el programa.

\pagebreak
