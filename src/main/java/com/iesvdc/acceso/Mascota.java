package com.iesvdc.acceso;

import java.io.Serializable;
import java.time.LocalDate;

class Mascota implements Serializable {
    private String nombre;
    private String nombreDueño;
    private String tipoAnimal;
    private LocalDate fechaNacimiento;

    public Mascota(String nombre, String nombreDueño, String tipoAnimal, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.nombreDueño = nombreDueño;
        this.tipoAnimal = tipoAnimal;
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nDueño: " + nombreDueño + "\nTipo de Animal: " + tipoAnimal + "\nFecha de Nacimiento: " + fechaNacimiento;
    }
}
