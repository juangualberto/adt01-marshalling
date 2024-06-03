
# Clases para gestión de flujos de datos desde/hacia ficheros. Flujos de bytes y de caracteres. 

## Copiando archivos byte a byte.

Para poder copiar el contenido de un archivo en otro byte a byte, utilizaremos las clases `FileInputStream` y `FileOutputStream` para leer y escribir bytes individualmente:

```java
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopiarArchivoByteAByte {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Uso: java CopiarArchivoByteAByte <archivo_origen> <archivo_destino>");
            System.exit(1);
        }

        String archivoOrigen = args[0];
        String archivoDestino = args[1];

        try (FileInputStream input = new FileInputStream(archivoOrigen);
             FileOutputStream output = new FileOutputStream(archivoDestino)) {

            int byteLeido;
            while ((byteLeido = input.read()) != -1) {
                output.write(byteLeido);
            }

            System.out.println("El archivo se copió correctamente.");

        } catch (IOException e) {
            System.err.println("Error al copiar el archivo: " + e.getMessage());
        }
    }
}
```

Este programa toma dos argumentos de línea de comandos: el nombre del archivo de origen (`<archivo_origen>`) y el nombre del archivo de destino (`<archivo_destino>`). Luego, utiliza `FileInputStream` para leer bytes del archivo de origen y `FileOutputStream` para escribir esos bytes en el archivo de destino uno por uno. Asegúrate de proporcionar los nombres de los archivos correctamente en la línea de comandos al ejecutar el programa. El programa copiará el archivo de origen en el archivo de destino byte a byte.

## Operaciones sobre ficheros secuenciales y aleatorios. 

El problema de los archivos de texto es que ocupan mucho espacio y, por ejemplo en dispositivos móviles, esto es crítico (no queremos que se llene el almacenamiento de nuestros móviles). En este caso podemos recurrir a archivos binarios.

\pagebreak
