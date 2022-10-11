package com.iesvdc.acceso.modelos;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class PersonasGenerator extends Personas {
    
    private Localidades locs;
    private List<String> apellidos;
    private List<String> nombresHombre;
    private List<String> nombresMujer;
    private Dominios dominios;
    
    public PersonasGenerator(){
        super();
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
		this.locs.load();
        this.dominios = new Dominios();
        this.dominios.load();
        this.apellidos = loadFileinArray(apellidosFilename);
        this.nombresMujer = loadFileinArray(nombresMujerFilename);
        this.nombresHombre = loadFileinArray(nombresHombreFilename);
    }

    public void load(){
        load("apellidos.txt","nombre_hombres.txt", "nombre_mujeres.txt");
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
                break;
            case MUJER:
                salida = this.nombresMujer.get(
                    dado(this.nombresMujer.size()));
                break;
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
        Sexo[] sexos = Sexo.values();
        int num = dado(sexos.length);
        return sexos[num];
    }

    private String getRandDominio(){
        return this.dominios.getDominios().get(
            dado(this.dominios.getDominios().size()));
    }

    private String generateEmail(String nombre, String ap1, String ap2){
        String salida = ""; 
        salida = nombre.substring(0, 1) + 
            ap1.substring(0,3) +
            ap2.substring(0,3) + "@" +
            this.getRandDominio();
        return (salida.replaceAll("\\s+", "").toLowerCase());
    }

    public void generate(int cuantos){
        if (this.apellidos==null || 
            this.nombresHombre==null || 
            this.nombresMujer == null) {
                this.load();
            }
        for (int i=0; i<cuantos; i++){
            Sexo sexo = this.getRandSexo();
            String nombre = this.getRandNombre(sexo);
            String apellido1 = this.getRandApellido();
            String apellido2 = this.getRandApellido();
            this.add(                
                new Persona(
                    nombre, 
                    apellido1, 
                    apellido2, 
                    this.getRandDni(), 
                    sexo, 
                    this.locs.getRandomLocalidad(),
                    generateEmail(nombre, apellido1, apellido2))
            );
        }
    }

}