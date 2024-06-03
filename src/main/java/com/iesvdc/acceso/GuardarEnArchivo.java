package com.iesvdc.acceso;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GuardarEnArchivo {
    public static void main(String[] args) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("salida.txt")); 
            Scanner scanner = new Scanner(System.in)) {            
            
            String leido ="";
            do {
                leido = scanner.nextLine();
                bw.write(leido);
                bw.newLine();
            } while (leido.compareTo("exit")!=0);
            
        } catch (IOException e) {            
            e.printStackTrace();
        }    
    }
}
