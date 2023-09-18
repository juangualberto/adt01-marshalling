package com.iesvdc.acceso;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.eclipse.persistence.jaxb.UnmarshallerProperties;

import com.iesvdc.acceso.modelos.Personas;

/**
 * Ejemplo de generador de personas.
 *
 */
public class UnMarshallerJSON {
    public static void main(String[] args) {
        Personas lista = new Personas();
        /*
         * PersonasGenerator pg = new PersonasGenerator();
         * pg.generate(10);
         * 
         * lista = new Personas(pg.getPersonas());
         */
        JAXBContext jaxbContext;

        try {
            System.setProperty("javax.xml.bind.JAXBContextFactory", "org.eclipse.persistence.jaxb.JAXBContextFactory");
            /*
             * jaxbContext = JAXBContext.newInstance(lista.getClass());
             * Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
             * jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
             * jaxbMarshaller.marshal(lista, new File("personas.xml"));
             */

            jaxbContext = JAXBContext.newInstance(lista.getClass());

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            // Para JSON
            jaxbUnmarshaller.setProperty(UnmarshallerProperties.MEDIA_TYPE, "application/json");
            jaxbUnmarshaller.setProperty(UnmarshallerProperties.JSON_INCLUDE_ROOT, true);

            Object objeto = jaxbUnmarshaller.unmarshal(new File("personas.json"));
            lista = (Personas) objeto;
            System.out.println(lista.toString());

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
