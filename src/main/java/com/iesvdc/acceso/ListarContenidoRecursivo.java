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
