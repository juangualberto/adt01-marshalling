package com.iesvdc.acceso.modelos;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Personas {
    
    private List<Persona> personas;
    private Localidades locs;
    private List<String> apellidos;
    private List<String> nombresHombre;
    private List<String> nombresMujer;
    
    public Personas() {
        this.personas = new ArrayList<Persona>();
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

    List<String> loadFileinArray(String filename) {
        List<String> array = null;
        Path fichero = Paths.get(filename);
        try {
            array = Files.readAllLines(fichero);
        } catch (Exception e) {
            System.out.println("::PERSONAS::loadFielinArray(): Error al cargar fichero: " +
                filename + "::" +
                e.getMessage());
        }
        return array;
    }

    public void load(String apellidosFilename, 
        String nombresHombreFilename, String nombresMujerFilename) {
        this.locs = new Localidades();
		locs.load();
        this.apellidos = loadFileinArray(apellidosFilename);
        this.nombresMujer = loadFileinArray(nombresMujerFilename);
        this.nombresHombre = loadFileinArray(nombresHombreFilename);
    }

    public void load(){
        load("apellidos.txt","nombre_hombres.txt", "nombre_mujeres.txt");
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

    private int dado(int tam){
        return ( (int) Math.round(Math.random()*(tam-1)));
    }
    
    private String getRandApellido(){
        return this.apellidos.get(dado(this.apellidos.size()));
    }

    private static char calcularLetra(int dni){
        String caracteres="TRWAGMYFPDXBNJZSQVHLCKE";
        int resto = dni%23;
        return caracteres.charAt(resto);
   }

    private String getRandDni(){
        int num = dado(100000000);
        return Integer.toString(num)+calcularLetra(num);
    }

    private String getRandNombre(Sexo sexo) {
        String salida="John Doe";
        switch (sexo){
            case HOMBRE:
                salida = this.nombresHombre.get(
                    dado(this.nombresHombre.size()));
            case MUJER:
                salida = this.nombresMujer.get(
                    dado(this.nombresMujer.size()));
            case X:
                if (dado(10)>5){
                    salida = this.nombresHombre.get(
                        dado(this.nombresHombre.size()));
                } else {
                    salida = this.nombresMujer.get(
                        dado(this.nombresMujer.size()));
                }
        }
        return salida;
    }

    private Sexo getRandSexo(){
        int num = dado(3);
        Sexo[] sexos = Sexo.values();
        return sexos[num];
    }

    public void generate(int cuantos){
        if (this.apellidos==null || 
            this.nombresHombre==null || 
            this.nombresMujer == null) {
                this.load();
            }
        for (int i=0; i<cuantos; i++){
            Sexo sexo = this.getRandSexo();
            this.personas.add(
                new Persona(
                    this.getRandNombre(sexo), 
                    this.getRandApellido(), 
                    this.getRandApellido(), 
                    this.getRandDni(), 
                    sexo, 
                    this.locs.getRandomLocalidad())
            );
        }
    }

}