package com.iesvdc.acceso;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.io.IOException;

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
