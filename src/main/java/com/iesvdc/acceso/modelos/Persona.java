package com.iesvdc.acceso.modelos;

import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

 
@XmlRootElement(name = "persona")
@XmlAccessorType (XmlAccessType.FIELD)
public class Persona{

    private String nombre;
    private String apellido1;
    private String apellido2;
    private String dni;
    private Sexo sexo;
    private Localidad localidad;
    private String email;
    

    public Persona() {
    }

    public Persona(
        String nombre, 
        String apellido1, 
        String apellido2, 
        String dni, 
        Sexo sexo, 
        Localidad localidad,
        String email) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.dni = dni;
        this.sexo = sexo;
        this.localidad = localidad;
        this.email = email;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return this.apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return this.apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getDni() {
        return this.dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Sexo getSexo() {
        return this.sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Localidad getLocalidad() {
        return this.localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    public Persona nombre(String nombre) {
        setNombre(nombre);
        return this;
    }

    public Persona apellido1(String apellido1) {
        setApellido1(apellido1);
        return this;
    }

    public Persona apellido2(String apellido2) {
        setApellido2(apellido2);
        return this;
    }

    public Persona dni(String dni) {
        setDni(dni);
        return this;
    }

    public Persona sexo(Sexo sexo) {
        setSexo(sexo);
        return this;
    }

    public Persona localidad(Localidad localidad) {
        setLocalidad(localidad);
        return this;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Persona)) {
            return false;
        }
        Persona persona = (Persona) o;
        return Objects.equals(nombre, persona.nombre) && Objects.equals(apellido1, persona.apellido1) && Objects.equals(apellido2, persona.apellido2) && Objects.equals(dni, persona.dni) && Objects.equals(sexo, persona.sexo) && Objects.equals(localidad, persona.localidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido1, apellido2, dni, sexo, localidad);
    }

    @Override
    public String toString() {
        return "\n{" +
            " nombre:'" + getNombre() + "'" +
            ", apellido1:'" + getApellido1() + "'" +
            ", apellido2:'" + getApellido2() + "'" +
            ", dni:'" + getDni() + "'" +
            ", sexo:'" + getSexo() + "'" +
            ", localidad:'" + getLocalidad() + "'" +
            "}";
    }
    

}