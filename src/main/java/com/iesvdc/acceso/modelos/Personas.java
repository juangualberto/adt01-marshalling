package com.iesvdc.acceso.modelos;
import java.util.List;
import java.util.Objects;

public class Personas {
    
    private List<Persona> personas;
    
    public Personas() {
    }

    public Personas(List<Persona> personas) {
        this.personas = personas;
    }

    public void add(Persona p) {
        if (p!=null) 
            this.add(p);
    }

    public boolean remove(Persona p) {
        return this.personas.remove(p);
    }

    public Persona get(int index){
        return this.personas.get(index);
    }

    public List<Persona> getPersonas() {
        return this.personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public Personas personas(List<Persona> personas) {
        setPersonas(personas);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Personas)) {
            return false;
        }
        Personas personas = (Personas) o;
        return Objects.equals(personas, personas.personas);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(personas);
    }

    @Override
    public String toString() {
        return "{" +
            " personas='" + getPersonas() + "'" +
            "}";
    }

}