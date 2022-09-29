package com.iesvdc.acceso.modelos;

import java.util.Objects;

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
        return Objects.equals(ciudad, localidad.ciudad) && Objects.equals(cp, localidad.cp) && Objects.equals(provincia, localidad.provincia);
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
