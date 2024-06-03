# Marshalling y unmarshalling

El **marshalling** y **unmarshalling** son procesos utilizados en programación, particularmente en Java, para convertir objetos entre diferentes formatos de datos (como JSON o XML) y su representación en memoria (es decir, instancias de objetos en la memoria del ordenador).

Recuerda que tanto XML como JSON son formatos muy utilizados para el intercambio de información, especialmente en arquitecturas cliente-servidor.

## Marshalling

**Marshalling** es el proceso de convertir un objeto en memoria en un formato que puede ser almacenado o transmitido, como JSON, XML o un flujo de bytes. Este proceso es útil para la serialización de objetos cuando se necesita:

1. Guardar el estado de un objeto en un archivo.
2. Enviar un objeto a través de una red.
3. Guardar un objeto en una base de datos.

En Java, hay varias bibliotecas que permiten realizar el marshalling, entre ellas Jackson para JSON y JAXB para XML.

## Unmarshalling

**Unmarshalling** es el proceso inverso al marshalling. Consiste en convertir datos almacenados o transmitidos en un formato específico (como JSON, XML, o un flujo de bytes) de nuevo en un objeto en memoria. Este proceso es útil para la deserialización cuando se necesita:

1. Leer el estado de un objeto desde un archivo.
2. Recibir un objeto desde una red.
3. Leer un objeto desde una base de datos.

Al igual que con el marshalling, en Java existen varias bibliotecas que permiten realizar el unmarshalling, como Jackson y JAXB.

## Anotando clases

Las anotaciones del paquete `javax.xml.bind.annotation` (JAXB) son esenciales para controlar cómo los objetos Java se convierten en XML y viceversa. Veamos un ejemplo que muestra cómo usar varias de las anotaciones más importantes de `javax.xml.bind.annotation` para controlar la serialización y deserialización de un objeto Java a XML y viceversa:

### 1. `@XmlRootElement`

- **Descripción:** Define el elemento raíz del documento XML.
- **Uso:** Se coloca en la clase que se desea convertir en XML.
  
  ```java
  import javax.xml.bind.annotation.XmlRootElement;

  @XmlRootElement(name = "usuario")
  public class Usuario {
      // campos, constructores, getters y setters
  }
  ```

### 2. `@XmlElement`

- **Descripción:** Especifica el nombre del elemento XML que se asocia con un campo o propiedad de la clase.
- **Uso:** Se coloca en los campos o métodos getter.
  
  ```java
  import javax.xml.bind.annotation.XmlElement;

  public class Usuario {
      private String nombre;

      @XmlElement(name = "nombre")
      public String getNombre() {
          return nombre;
      }

      public void setNombre(String nombre) {
          this.nombre = nombre;
      }
  }
  ```

### 3. `@XmlAttribute`

- **Descripción:** Define que un campo o propiedad se debe mapear a un atributo XML.
- **Uso:** Se coloca en los campos o métodos getter.
  
  ```java
  import javax.xml.bind.annotation.XmlAttribute;

  public class Usuario {
      private String id;

      @XmlAttribute(name = "id")
      public String getId() {
          return id;
      }

      public void setId(String id) {
          this.id = id;
      }
  }
  ```

### 4. `@XmlTransient`

- **Descripción:** Excluye un campo o propiedad de la serialización a XML.
- **Uso:** Se coloca en los campos o métodos getter que no se desean incluir en el XML.
  
  ```java
  import javax.xml.bind.annotation.XmlTransient;

  public class Usuario {
      private String password;

      @XmlTransient
      public String getPassword() {
          return password;
      }

      public void setPassword(String password) {
          this.password = password;
      }
  }
  ```

### 5. `@XmlAccessorType`

- **Descripción:** Define el tipo de acceso predeterminado para la serialización y deserialización de los campos y propiedades de una clase.
- **Uso:** Se coloca en la clase y puede tomar valores como `XmlAccessType.FIELD`, `XmlAccessType.PROPERTY`, `XmlAccessType.PUBLIC_MEMBER`, y `XmlAccessType.NONE`.
  
  ```java
  import javax.xml.bind.annotation.XmlAccessorType;
  import javax.xml.bind.annotation.XmlAccessType;

  @XmlAccessorType(XmlAccessType.FIELD)
  public class Usuario {
      private String nombre;
      private String apellidos;
      // getters y setters
  }
  ```

### 6. `@XmlType`

- **Descripción:** Controla el orden de los elementos XML generados.
- **Uso:** Se coloca en la clase y permite especificar el nombre y el orden de los campos.

  ```java
  import javax.xml.bind.annotation.XmlType;

  @XmlType(propOrder = { "nombre", "apellidos" })
  public class Usuario {
      private String nombre;
      private String apellidos;

      // getters y setters
  }
  ```

### 7. `@XmlEnum` y `@XmlEnumValue`

- **Descripción:** `@XmlEnum` se usa para mapear una enumeración Java a XML, y `@XmlEnumValue` se usa para mapear un valor específico de la enumeración a un valor XML.
- **Uso:** Se coloca en una clase de enumeración y en los valores de la enumeración respectivamente.
  
  ```java
  import javax.xml.bind.annotation.XmlEnum;
  import javax.xml.bind.annotation.XmlEnumValue;

  @XmlEnum
  public enum Estado {
      @XmlEnumValue("activo")
      ACTIVO,
      @XmlEnumValue("inactivo")
      INACTIVO;
  }
  ```

### 8. `@XmlElementWrapper`

- **Descripción:** Envuelve una colección de elementos en un elemento contenedor.
- **Uso:** Se coloca en el método getter de una colección.
  
  ```java
  import javax.xml.bind.annotation.XmlElement;
  import javax.xml.bind.annotation.XmlElementWrapper;
  import java.util.List;

  public class Usuario {
      private List<String> roles;

      @XmlElementWrapper(name = "roles")
      @XmlElement(name = "rol")
      public List<String> getRoles() {
          return roles;
      }

      public void setRoles(List<String> roles) {
          this.roles = roles;
      }
  }
  ```

### Ejemplo Completo

```java
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

@XmlRootElement(name = "usuario")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "id", "nombre", "apellidos", "username", "roles" })
public class Usuario {
    
    @XmlAttribute(name = "id")
    private String id;

    @XmlElement(name = "nombre")
    private String nombre;

    @XmlElement(name = "apellidos")
    private String apellidos;

    @XmlElement(name = "username")
    private String username;

    @XmlTransient
    private String password;

    @XmlElementWrapper(name = "roles")
    @XmlElement(name = "rol")
    private List<String> roles;

    // Getters y setters
    
}
```

## Ejemplo de caso práctico

Para un proyecto Maven en Java que realice el marshalling (serialización) y unmarshalling (deserialización) de objetos hacia/desde JSON y XML, podemos utilizar las siguientes bibliotecas:

1. **Jackson** para trabajar con JSON.
2. **JAXB (Java Architecture for XML Binding)** para trabajar con XML (es el que usa el framework Spring).

### Paso 1: Crear un Proyecto Maven

Primero, crea un proyecto Maven y define las dependencias necesarias en tu archivo `pom.xml`.

### Dependencias en `pom.xml`

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" 
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 
                             http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.example</groupId>
    <artifactId>json-xml-marshalling</artifactId>
    <version>1.0-SNAPSHOT</version>

    <dependencies>
        <!-- Jackson dependencies -->
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.13.3</version>
        </dependency>
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-core</artifactId>
            <version>2.13.3</version>
        </dependency>
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-annotations</artifactId>
            <version>2.13.3</version>
        </dependency>
        <dependency>
            <groupId>com.fasterxml.jackson.dataformat</groupId>
            <artifactId>jackson-dataformat-xml</artifactId>
            <version>2.13.3</version>
        </dependency>

        <!-- JAXB dependencies -->
        <dependency>
            <groupId>javax.xml.bind</groupId>
            <artifactId>jaxb-api</artifactId>
            <version>2.3.1</version>
        </dependency>
        <dependency>
            <groupId>org.glassfish.jaxb</groupId>
            <artifactId>jaxb-runtime</artifactId>
            <version>2.3.2</version>
        </dependency>
        <dependency>
            <groupId>org.glassfish.jaxb</groupId>
            <artifactId>jaxb-core</artifactId>
            <version>2.3.0.1</version>
        </dependency>
    </dependencies>
</project>
```

### Paso 2: Crear la Clase Usuario

Define tu clase `Usuario` con las anotaciones necesarias para JAXB y Jackson.

```java
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "usuario")
public class Usuario {
    
    @JsonProperty("nombre")
    @JacksonXmlProperty(localName = "nombre")
    @XmlElement(name = "nombre")
    private String nombre;

    @JsonProperty("apellidos")
    @JacksonXmlProperty(localName = "apellidos")
    @XmlElement(name = "apellidos")
    private String apellidos;

    @JsonProperty("username")
    @JacksonXmlProperty(localName = "username")
    @XmlElement(name = "username")
    private String username;

    @JsonProperty("password")
    @JacksonXmlProperty(localName = "password")
    @XmlElement(name = "password")
    private String password;

    // Getters y Setters
    [...]
}
```

### Paso 3: Implementar la Serialización y Deserialización

Para este apartado nos hemos inspirado en los tutoriales de Beldung sobre Jackson. Cuando dispongas de un momento te recomendamos echarles un ojo en esta URL: <https://www.baeldung.com/jackson>.

#### Serialización y Deserialización JSON con Jackson

Usamos la clase **ObjectMapper** para esta tarea por la facilidad y simplicidad de uso. 

```java
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void serializeToJson(Usuario usuario, String filePath) throws IOException {
        objectMapper.writeValue(new File(filePath), usuario);
    }

    public static Usuario deserializeFromJson(String filePath) throws IOException {
        return objectMapper.readValue(new File(filePath), Usuario.class);
    }
}
```

#### Serialización y Deserialización XML con JAXB

Por defecto JAXB trabaja con XML, por lo que no necesitamos ninguna configuración adicional.

```java
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XmlUtil {
    public static void serializeToXml(Usuario usuario, String filePath) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Usuario.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(usuario, new File(filePath));
    }

    public static Usuario deserializeFromXml(String filePath) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Usuario.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (Usuario) unmarshaller.unmarshal(new File(filePath));
    }
}
```

### Paso 4: Ejemplo de Uso

Veamos cómo crear un objeto en Java y almacenarlo en JSON y XML respectivamente:

```java
public class Main {
    public static void main(String[] args) {
        Usuario usuario = new Usuario();
        usuario.setNombre("John");
        usuario.setApellidos("Doe");
        usuario.setUsername("jdoe");
        usuario.setPassword("password123");

        String jsonFilePath = "usuario.json";
        String xmlFilePath = "usuario.xml";

        try {
            // JSON
            JsonUtil.serializeToJson(usuario, jsonFilePath);
            Usuario usuarioFromJson = JsonUtil.deserializeFromJson(jsonFilePath);
            System.out.println("Usuario desde JSON: " + usuarioFromJson.getNombre());

            // XML
            XmlUtil.serializeToXml(usuario, xmlFilePath);
            Usuario usuarioFromXml = XmlUtil.deserializeFromXml(xmlFilePath);
            System.out.println("Usuario desde XML: " + usuarioFromXml.getNombre());

        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
    }
}
```

\pagebreak

