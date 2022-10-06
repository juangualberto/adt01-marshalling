package com.iesvdc.acceso.modelos;

import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement(name = "localidad")
@XmlAccessorType (XmlAccessType.FIELD)
public class Localidad {
    private String ciudad;
    private Integer cp;
    private String provincia;


    public Localidad() {
    }

    public Localidad(String ciudad, Integer cp, String provincia) {
        this.ciudad = ciudad;
        this.cp = cp;
        this.provincia = provincia;
    }

    public String getCiudad() {
        return this.ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Integer getCp() {
        return this.cp;
    }

    public void setCp(Integer cp) {
        this.cp = cp;
    }

    public String getProvincia() {
        return this.provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public Localidad ciudad(String ciudad) {
        setCiudad(ciudad);
        return this;
    }

    public Localidad cp(Integer cp) {
        setCp(cp);
        return this;
    }

    public Localidad provincia(String provincia) {
        setProvincia(provincia);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Localidad)) {
            return false;
        }
        Localidad localidad = (Localidad) o;
        return Objects.equals(ciudad, localidad.ciudad) && 
            Objects.equals(cp, localidad.cp) && 
            Objects.equals(provincia, localidad.provincia);
        /*
        // alternativa al return de encima (son equivalentes)
        boolean salida = true;
        if (this.ciudad.compareTo(localidad.getCiudad())!=0) salida = false;
        if (this.provincia.compareTo(localidad.getProvincia())!=0) salida = false;
        if (this.cp != localidad.getCp()) salida = false;
        return salida;
        */
    }

    @Override
    public int hashCode() {
        return Objects.hash(ciudad, cp, provincia);
    }

    @Override
    public String toString() {
        return "{" +
            " ciudad='" + getCiudad() + "'" +
            ", cp='" + getCp() + "'" +
            ", provincia='" + getProvincia() + "'" +
            "}";
    }

}
