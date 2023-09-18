package com.iesvdc.acceso;

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

