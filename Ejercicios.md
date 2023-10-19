# Ejercicios propuestos

A continuación proponemos una batería de ejercicios para que puedas practicar de cara al examen.

## Ejercicio 1

Crear un programa Java que lea una lista de nombres desde un archivo llamado "nombres.txt", lo almacene en una estructura de datos y luego muestre estos nombres por pantalla.

**SOLUCIÓN:**

```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LecturaNombres {
    public static void main(String[] args) {
        String nombreArchivo = "nombres.txt"; // Nombre del archivo que contiene la lista de nombres
        List<String> listaNombres = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            System.out.println("Lista de nombres:");

            while ((linea = br.readLine()) != null) {
                listaNombres.add(linea); // Agregar el nombre a la lista
            }

            // Mostrar la lista de nombres
            for (String nombre : listaNombres) {
                System.out.println(nombre);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
```

En este programa, utilizamos un objeto `BufferedReader` para leer las líneas del archivo "nombres.txt". Cada línea se imprime en la consola, lo que muestra la lista de nombres.

Asegúrate de tener un archivo "nombres.txt" con una lista de nombres en el mismo directorio que este programa antes de ejecutarlo.

Como puedes ver, tenemos una lista llamada `listaNombres` para almacenar temporalmente los nombres leídos del archivo. Cada vez que leemos una línea del archivo, agregamos el nombre a esta lista con `listaNombres.add(linea)`.

Luego, después de leer todos los nombres del archivo, recorremos la lista de nombres y los mostramos por pantalla.

De esta manera, puedes acceder y manipular la lista de nombres en la memoria de tu programa si necesitas realizar operaciones adicionales con estos datos.

Por supuesto, aquí tienes un ejercicio que implica leer un archivo CSV con información de nombre, apellido y correo electrónico, y almacenar estos datos en una estructura de datos para su posterior manipulación. Asegúrate de tener un archivo CSV válido en el mismo directorio que el código Java para este ejercicio.

## Ejercicio 2

Crear un programa Java que lea un archivo CSV llamado "contactos.csv" que contiene información de nombre, apellido y correo electrónico, y almacene estos datos en una estructura de datos para su posterior manipulación.

**SOLUCION:**

```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LecturaContactosCSV {
    public static void main(String[] args) {
        String nombreArchivo = "contactos.csv"; // Nombre del archivo CSV

        List<Contacto> listaContactos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            System.out.println("Lista de contactos:");

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 3) {
                    String nombre = datos[0].trim();
                    String apellido = datos[1].trim();
                    String email = datos[2].trim();
                    Contacto contacto = new Contacto(nombre, apellido, email);
                    listaContactos.add(contacto);
                }
            }

            // Mostrar la lista de contactos
            for (Contacto contacto : listaContactos) {
                System.out.println(contacto);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}

class Contacto {
    private String nombre;
    private String apellido;
    private String email;

    public Contacto(String nombre, String apellido, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Apellido: " + apellido + ", Email: " + email;
    }
}
```

En este programa, hemos creado una clase `Contacto` para representar los datos de cada contacto, incluyendo nombre, apellido y correo electrónico. El programa lee el archivo CSV "contactos.csv", divide cada línea en partes usando `split(",")` y luego crea instancias de `Contacto` con esos datos para almacenarlos en la lista `listaContactos`. Finalmente, muestra la lista de contactos por pantalla.

Asegúrate de que el archivo "contactos.csv" contenga datos separados por comas en el siguiente formato: "Nombre, Apellido, Email". Puedes ajustar el programa según el formato de tu archivo CSV.


## Ejercicio 3

Crear un programa Java que serialice una lista de contactos en un archivo y luego deserialice y muestre estos contactos desde ese archivo. Crea una lista de al menos tres contactos y guárdala en un archivo llamado "contactos.dat".

**Solución:**

```java
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializacionContactos {
    public static void main(String[] args) {
        List<Contacto> listaContactos = new ArrayList<>();

        // Crear una lista de al menos tres contactos
        listaContactos.add(new Contacto("Alice", "Johnson", "alice@example.com"));
        listaContactos.add(new Contacto("Bob", "Smith", "bob@example.com"));
        listaContactos.add(new Contacto("Charlie", "Brown", "charlie@example.com"));

        // Serializar la lista de contactos en un archivo
        serializarContactos("contactos.dat", listaContactos);

        // Deserializar y mostrar la lista de contactos desde el archivo
        List<Contacto> contactosDeserializados = deserializarContactos("contactos.dat");

        System.out.println("Lista de contactos deserializados:");
        for (Contacto contacto : contactosDeserializados) {
            System.out.println(contacto);
        }
    }

    private static void serializarContactos(String nombreArchivo, List<Contacto> contactos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(contactos);
            System.out.println("Contactos serializados y guardados en " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al serializar contactos: " + e.getMessage());
        }
    }

    private static List<Contacto> deserializarContactos(String nombreArchivo) {
        List<Contacto> contactos = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            contactos = (List<Contacto>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al deserializar contactos: " + e.getMessage());
        }
        return contactos;
    }
}

class Contacto implements Serializable {
    private String nombre;
    private String apellido;
    private String email;

    public Contacto(String nombre, String apellido, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Apellido: " + apellido + ", Email: " + email;
    }
}
```

Este programa crea una lista de contactos, los serializa en un archivo llamado "contactos.dat" y luego los deserializa y muestra en la consola. La clase `Contacto` implementa la interfaz `Serializable` para permitir la serialización de objetos de esta clase.

Asegúrate de ejecutar este programa en el mismo directorio en el que quieres crear el archivo "contactos.dat". También, asegúrate de que el archivo no exista previamente o que no contenga datos serializados de otra ejecución, ya que podría causar errores al deserializar.

## Ejercicio 4

**Enunciado del ejercicio: Generador de Contactos Aleatorios**

Crea un programa Java que genere una lista de 10 contactos aleatorios utilizando listas predefinidas de nombres, apellidos y dominios de correo electrónico. Cada contacto debe tener la siguiente estructura:

- Nombre: Se elige aleatoriamente de una lista de nombres.
- Apellido: Se elige aleatoriamente de una lista de apellidos.
- Email: Se construye utilizando la primera letra del nombre, seguida del apellido en minúsculas, y un dominio de correo aleatorio.

El programa debe mostrar los contactos generados en la consola.


**SOLUCION:**

```java
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class GeneradorContactosAleatorios {
    public static void main(String[] args) {
        List<String> nombres = new ArrayList<>();
        List<String> apellidos = new ArrayList<>();
        List<String> dominiosCorreo = new ArrayList<>();

        // Agregar nombres, apellidos y dominios a las listas
        agregarNombres(nombres);
        agregarApellidos(apellidos);
        agregarDominiosCorreo(dominiosCorreo);

        List<Contacto> contactosAleatorios = generarContactosAleatorios(nombres, apellidos, dominiosCorreo);

        // Mostrar los contactos generados
        for (Contacto contacto : contactosAleatorios) {
            System.out.println(contacto);
        }
    }

    private static void agregarNombres(List<String> nombres) {
        nombres.add("Alice");
        nombres.add("Bob");
        nombres.add("Charlie");
        // Agregar más nombres aquí
    }

    private static void agregarApellidos(List<String> apellidos) {
        apellidos.add("Johnson");
        apellidos.add("Smith");
        apellidos.add("Brown");
        // Agregar más apellidos aquí
    }

    private static void agregarDominiosCorreo(List<String> dominiosCorreo) {
        dominiosCorreo.add("example.com");
        dominiosCorreo.add("gmail.com");
        dominiosCorreo.add("yahoo.com");
        // Agregar más dominios de correo aquí
    }

    private static List<Contacto> generarContactosAleatorios(List<String> nombres, List<String> apellidos, List<String> dominiosCorreo) {
        List<Contacto> contactosAleatorios = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            String nombre = nombres.get(rand.nextInt(nombres.size()));
            String apellido = apellidos.get(rand.nextInt(apellidos.size()));
            String dominio = dominiosCorreo.get(rand.nextInt(dominiosCorreo.size()));
            String email = nombre.substring(0, 1).toLowerCase() + apellido.toLowerCase() + "@" + dominio;

            Contacto contacto = new Contacto(nombre, apellido, email);
            contactosAleatorios.add(contacto);
        }

        return contactosAleatorios;
    }
}

class Contacto {
    private String nombre;
    private String apellido;
    private String email;

    public Contacto(String nombre, String apellido, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Apellido: " + apellido + ", Email: " + email;
    }
}
```

Este programa genera 10 contactos aleatorios utilizando listas de nombres, apellidos y dominios de correo electrónico. La dirección de correo se crea a partir de la primera letra del nombre, concatenada con el apellido y un dominio de correo electrónico aleatorio. Los contactos generados se almacenan en una lista y se muestran en la consola. Puedes modificar las listas de nombres, apellidos y dominios de correo según tus preferencias.

## Ejercicio 5

Crear un programa Java que utilice la API JAXB para convertir una lista de contactos en formato XML y luego deserialice (unmarshal) los contactos desde el archivo XML. Crea una lista de al menos tres contactos y guárdala en un archivo XML llamado "contactos.xml" utilizando JAXB.

Recuerda utilizar la API JAXB para realizar el marshaling y unmarshaling de la lista de contactos. La clase `Contacto` debe tener un constructor sin argumentos y proporcionar anotaciones JAXB, aunque también se puede usar un archivo de mapeo XML para definir las relaciones entre las clases y los elementos XML. 
