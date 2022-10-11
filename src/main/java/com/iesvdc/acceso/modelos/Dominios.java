package com.iesvdc.acceso.modelos;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public class Dominios {
    private List<String> dominios;
    

    public Dominios() {
    }

    public Dominios(List<String> dominios) {
        this.dominios = dominios;
    }

    public List<String> getDominios() {
        return this.dominios;
    }

    public void setDominios(List<String> dominios) {
        this.dominios = dominios;
    }

    public Dominios dominios(List<String> dominios) {
        setDominios(dominios);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Dominios)) {
            return false;
        }
        Dominios dominios = (Dominios) o;
        return Objects.equals(dominios, dominios.dominios);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(dominios);
    }

    @Override
    public String toString() {
        return "{" +
            " dominios='" + getDominios() + "'" +
            "}";
    }
 
    public void load(){
        Path path = Paths.get("all_email.txt");
        try {
            this.dominios = Files.readAllLines(path);
        } catch (IOException e) {
            System.out.println("::DOMINIOS:: Error al cargar el fichero.");
        }
    }
}
