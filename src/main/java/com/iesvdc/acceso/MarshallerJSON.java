package com.iesvdc.acceso;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.eclipse.persistence.jaxb.MarshallerProperties;

import com.iesvdc.acceso.modelos.Personas;
import com.iesvdc.acceso.modelos.PersonasGenerator;

/**
 * Ejemplo de generador de personas.
 *
 */
public class MarshallerJSON {
    public static void main(String[] args) {
        Personas lista = new Personas();
        PersonasGenerator pg = new PersonasGenerator();
        pg.generate(10);

        lista = new Personas(pg.getPersonas());
        JAXBContext jaxbContext;

        try {
            System.setProperty("javax.xml.bind.JAXBContextFactory", "org.eclipse.persistence.jaxb.JAXBContextFactory");

            jaxbContext = JAXBContext.newInstance(lista.getClass());

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Para JSON
            jaxbMarshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
            jaxbMarshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, true);

            jaxbMarshaller.marshal(lista, new File("personas.json"));

            /*
             * jaxbContext = JAXBContext.newInstance(lista.getClass());
             * Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
             * Object objeto = jaxbUnmarshaller.unmarshal(new File("personas.xml"));
             * lista = (Personas) objeto;
             * System.out.println(lista.toString());
             */

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
