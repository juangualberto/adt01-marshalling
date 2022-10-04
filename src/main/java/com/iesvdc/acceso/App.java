package com.iesvdc.acceso;

import com.iesvdc.acceso.modelos.Personas;

/**
 * Ejemplo de generador de personas.
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Personas ps = new Personas();
        ps.generate(10);
        System.out.println(ps.toString());
    }
}
