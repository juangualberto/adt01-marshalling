package com.iesvdc.acceso;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.iesvdc.acceso.modelos.Personas;

/**
 * Ejemplo de unmarshaller de personas. 
 * Versión XML.
 */
public class UnMarshallerXML 
{
    public static void main( String[] args )
    {
        Personas lista = new Personas();
        JAXBContext jaxbContext;

        try {
            
            jaxbContext = JAXBContext.newInstance(lista.getClass());
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Object objeto = jaxbUnmarshaller.unmarshal(new File("personas.xml"));
            lista = (Personas) objeto;
            System.out.println(lista.toString());

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        
    }
}
