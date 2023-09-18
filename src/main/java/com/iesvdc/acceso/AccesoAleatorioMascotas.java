package com.iesvdc.acceso;

import java.io.*;

public class AccesoAleatorioMascotas {
    public static void main(String[] args) {
        try (RandomAccessFile file = new RandomAccessFile("mascotas.dat", "r")) {

            // Tamaño de cada registro (tamaño de la instancia de Mascota en bytes)
            int tamañoRegistro = (int) (file.length() / 3);

            // Posicionarse en el segundo registro (índice 1)
            file.seek(tamañoRegistro);

            // Leer y deserializar la segunda mascota
            byte[] buffer = new byte[tamañoRegistro];
            file.read(buffer);
            ByteArrayInputStream byteInput = new ByteArrayInputStream(buffer);
            ObjectInputStream objectInput = new ObjectInputStream(byteInput);
            Mascota segundaMascota = (Mascota) objectInput.readObject();

            System.out.println("Información de la segunda mascota:");
            System.out.println(segundaMascota.toString());

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al acceder al archivo mascotas.dat: " + e.getMessage());
        }
    }
}

