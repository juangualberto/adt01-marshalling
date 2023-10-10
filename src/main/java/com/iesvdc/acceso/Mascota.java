package com.iesvdc.acceso;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

class Mascota implements Serializable {
    private String nombre;
    private String nombreDueño;
    private String tipoAnimal;
    private LocalDate fechaNacimiento;


    public Mascota() {
    }

    public Mascota(String nombre, String nombreDueño, String tipoAnimal, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.nombreDueño = nombreDueño;
        this.tipoAnimal = tipoAnimal;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreDueño() {
        return this.nombreDueño;
    }

    public void setNombreDueño(String nombreDueño) {
        this.nombreDueño = nombreDueño;
    }

    public String getTipoAnimal() {
        return this.tipoAnimal;
    }

    public void setTipoAnimal(String tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public LocalDate getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Mascota nombre(String nombre) {
        setNombre(nombre);
        return this;
    }

    public Mascota nombreDueño(String nombreDueño) {
        setNombreDueño(nombreDueño);
        return this;
    }

    public Mascota tipoAnimal(String tipoAnimal) {
        setTipoAnimal(tipoAnimal);
        return this;
    }

    public Mascota fechaNacimiento(LocalDate fechaNacimiento) {
        setFechaNacimiento(fechaNacimiento);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Mascota)) {
            return false;
        }
        Mascota mascota = (Mascota) o;
        return Objects.equals(nombre, mascota.nombre) && Objects.equals(nombreDueño, mascota.nombreDueño) && Objects.equals(tipoAnimal, mascota.tipoAnimal) && Objects.equals(fechaNacimiento, mascota.fechaNacimiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, nombreDueño, tipoAnimal, fechaNacimiento);
    }

    @Override
    public String toString() {
        return "{" +
            " nombre='" + getNombre() + "'" +
            ", nombreDueño='" + getNombreDueño() + "'" +
            ", tipoAnimal='" + getTipoAnimal() + "'" +
            ", fechaNacimiento='" + getFechaNacimiento() + "'" +
            "}";
    }
    
}
