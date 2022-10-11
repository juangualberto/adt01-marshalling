package com.iesvdc.acceso.modelos;
import java.util.Objects;

public class Libro {
    private String isbn;
    private String titulo;
    Persona autor;
    int edicion;
    int anio;
    String editorial;
    

    public Libro() {
    }

    public Libro(String isbn, String titulo, Persona autor, int edicion, int anio, String editorial) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.edicion = edicion;
        this.anio = anio;
        this.editorial = editorial;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Persona getAutor() {
        return this.autor;
    }

    public void setAutor(Persona autor) {
        this.autor = autor;
    }

    public int getEdicion() {
        return this.edicion;
    }

    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }

    public int getAnio() {
        return this.anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getEditorial() {
        return this.editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Libro isbn(String isbn) {
        setIsbn(isbn);
        return this;
    }

    public Libro titulo(String titulo) {
        setTitulo(titulo);
        return this;
    }

    public Libro autor(Persona autor) {
        setAutor(autor);
        return this;
    }

    public Libro edicion(int edicion) {
        setEdicion(edicion);
        return this;
    }

    public Libro anio(int anio) {
        setAnio(anio);
        return this;
    }

    public Libro editorial(String editorial) {
        setEditorial(editorial);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Libro)) {
            return false;
        }
        Libro libro = (Libro) o;
        return Objects.equals(isbn, libro.isbn) && Objects.equals(titulo, libro.titulo) && Objects.equals(autor, libro.autor) && edicion == libro.edicion && anio == libro.anio && Objects.equals(editorial, libro.editorial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, titulo, autor, edicion, anio, editorial);
    }

    @Override
    public String toString() {
        return "{" +
            " isbn='" + getIsbn() + "'" +
            ", titulo='" + getTitulo() + "'" +
            ", autor='" + getAutor() + "'" +
            ", edicion='" + getEdicion() + "'" +
            ", anio='" + getAnio() + "'" +
            ", editorial='" + getEditorial() + "'" +
            "}";
    }
    
}
