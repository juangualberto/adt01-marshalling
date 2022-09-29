package com.iesvdc.acceso.modelos;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Localidades {
    private List<Localidad> localidades;


    public Localidades() {
    }

    public Localidades(List<Localidad> localidades) {
        this.localidades = localidades;
    }

    public List<Localidad> getLocalidades() {
        return this.localidades;
    }

    /**
     * Carga las localidades de un archivo
     */
    public void load(String filename){
        this.localidades = new ArrayList<Localidad>();
        Path fichero = Paths.get(filename);
        try (BufferedReader br = Files.newBufferedReader(fichero)) {
            String linea = br.readLine();
            // nos saltamos la primera línea que tiene las cabeceras
            if (linea!= null) br.readLine(); 
            while (linea!=null) {
                String datos[] = linea.split(";");
                // Lodalidad: String ciudad, Integer cp, String provincia
                // CSV: Provincia;Población;Código Postal
                this.localidades.add(
                    new Localidad(
                        datos[1], 
                        Integer.parseInt(datos[2]), 
                        datos[0]));
                linea = br.readLine();
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public void load(){
        this.load("ciudades.csv");
    }
    public void setLocalidades(List<Localidad> localidades) {
        this.localidades = localidades;
    }

    public Localidades localidades(List<Localidad> localidades) {
        setLocalidades(localidades);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Localidades)) {
            return false;
        }
        Localidades localidades = (Localidades) o;
        return Objects.equals(localidades, localidades.localidades);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(localidades);
    }

    @Override
    public String toString() {
        return "{" +
            " localidades='" + getLocalidades() + "'" +
            "}";
    }

    Localidad getRandomLocalidad(){        
        int tam = this.localidades.size();
        int donde = (int) Math.round(Math.random()*tam);
        return this.localidades.get(donde);
    }
}