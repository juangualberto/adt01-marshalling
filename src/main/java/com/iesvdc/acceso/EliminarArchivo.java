package com.iesvdc.acceso;

import java.io.File;

/**
 * Programa para eliminar un archivo con Java
 */
public class EliminarArchivo {
    /**
     * Elimina un archivo
     * @param args[0] el nombre del archivo a eliminar
     */
    public static void main(String[] args) {
        if (args.length!=1) {
            System.err.println("Uso del programa: \n"+
             "EliminarArchivo <nombre_archivo>");            
        } else {
            File archivo = new File(args[0]);
            if (archivo.exists() && archivo.isFile()){
                archivo.delete();
            } else {
                System.err.println("No puedo borrar el archivo porque no existe o es una carpeta");
            }
        }

    }
}
