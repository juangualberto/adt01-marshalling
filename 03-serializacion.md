
## Serialización/deserialización de objetos.

Definimos la **serialización** de objetos como el proceso de copiar y almacenar un objeto de memoria volátil (memoria RAM) a memoria persistente (disco). El proceso de **deserialización** es lo contrario, tenemos un objeto almacenado en memoria persistente (un archivo, una base de datos...) y queremos copiarlo a memoria RAM.

A continuación vamos a ver cómo crear un programa en Java que cree varias mascotas y las almacene en un archivo binario. Para esto, primero necesitaremos definir una clase `Mascota` y luego usar `ObjectOutputStream` para escribir objetos de esta clase en un archivo binario:

```java

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.io.IOException;

class Mascota implements Serializable {
    private String nombre;
    private String nombreDueño;
    private String tipoAnimal;
    private LocalDate fechaNacimiento;

    public Mascota(String nombre, String nombreDueño, String tipoAnimal, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.nombreDueño = nombreDueño;
        this.tipoAnimal = tipoAnimal;
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nDueño: " + nombreDueño + "\nTipo de Animal: " + tipoAnimal + "\nFecha de Nacimiento: " + fechaNacimiento;
    }
}

public class AlmacenarMascotas {
    public static void main(String[] args) {
        try (FileOutputStream fileOutput = new FileOutputStream("mascotas.dat");
             ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput)) {

            // Crear tres objetos de mascota
            Mascota mascota1 = new Mascota("Whiskers", "ObiJuan", "Gato", LocalDate.of(2020, 5, 10));
            Mascota mascota2 = new Mascota("Rex", "Maria", "Perro", LocalDate.of(2018, 7, 15));
            Mascota mascota3 = new Mascota("Tweety", "Pedro", "Pájaro", LocalDate.of(2019, 2, 28));
            Mascota mascota4 = new Mascota("Yogi", "Mateo", "Oso Pardo", LocalDate.of(2019, 2, 28));

            // Escribir las mascotas en el archivo binario
            objectOutput.writeObject(mascota1);
            objectOutput.writeObject(mascota2);
            objectOutput.writeObject(mascota3);
            objectOutput.writeObject(mascota4);

            System.out.println("Las mascotas han sido almacenadas en el archivo mascotas.dat.");

        } catch (IOException e) {
            System.err.println("Error al almacenar las mascotas: " + e.getMessage());
        }
    }
}

```

En este programa, creamos una clase `Mascota` que implementa `Serializable`. Esto permite que las instancias de la clase se serialicen y deserialicen automáticamente cuando las escribimos en un archivo binario y las leemos de nuevo.

Luego, en el método `main`, creamos varios objetos `Mascota` y los escribimos en un archivo llamado "mascotas.dat" usando `ObjectOutputStream`. Ten en cuenta que hemos usado `try-with-resources` para asegurarnos de que los recursos se cierren correctamente. Fíjate que hemos usado LocalDate en vez de Date que está deprecada.

Después de ejecutar el programa, encontrarás el archivo "mascotas.dat" en el directorio de tu proyecto, y contendrá las tres mascotas serializadas en formato binario. Intenta probarlo en tu ordenador. 

Ahora vamos a ver el proceso inverso, vamos a leer un archivo binario que contiene objetos `Mascota` serializados y los muestramos. Utilizaremos `ObjectInputStream` para deserializar los objetos y mostrar la información de las mascotas almacenadas. Aquí tienes el programa:

```java

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

public class LeerMascotas {
    public static void main(String[] args) {
        try (FileInputStream fileInput = new FileInputStream("mascotas.dat");
            ObjectInputStream objectInput = new ObjectInputStream(fileInput)) {

            while (true) {
                try {
                    // Leer y deserializar la siguiente mascota
                    Mascota mascota = (Mascota) objectInput.readObject();
                    System.out.println("\nInformación de la mascota:");
                    System.out.println(mascota.toString());                
                }catch (EOFException e) {
                    System.err.println("Alcanzado el final del archivo");
                    break; // Se alcanzó el final del archivo
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al leer el archivo mascotas.dat: " + e.getMessage());
        }
    }
}

```

Este programa utiliza `ObjectInputStream` para leer y deserializar objetos `Mascota` del archivo binario "mascotas.dat". Utiliza un bucle infinito que se detiene cuando se alcanza el final del archivo. Cada objeto `Mascota` se imprime en la consola con su información. El programa leerá el archivo "mascotas.dat" que generamos anteriormente y mostrará la información de todas las mascotas almacenadas en ese archivo. Asegúrate de que el archivo "mascotas.dat" exista en el mismo directorio donde se encuentra el programa.

\pagebreak
