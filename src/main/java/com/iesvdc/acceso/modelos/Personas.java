package com.iesvdc.acceso.modelos;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement(name = "personas")
@XmlAccessorType (XmlAccessType.FIELD)
public class Personas {
    
    @XmlElement(name="persona")
    private List<Persona> personas;
    
    public Personas() {
        this.personas = new ArrayList<Persona>();
    }

    public Personas(List<Persona> personas) {
        this.personas = personas;
    }

    public void add(Persona p) {
        if (p!=null) 
            this.personas.add(p);
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
        Personas pers = (Personas) o;
        return Objects.equals(personas, pers.personas);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(personas);
    }

    @Override
    public String toString() {
        return "{" +
            " personas:'" + getPersonas() + "'" +
            "}";
    }

    
}