package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Objects;

@Entity
public class Palabra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String palabra;
    private String definicion;

    // Getters y setters

    // Constructor vacío y constructor con parámetros

    public Palabra() {
    }

    public Palabra(Long id, String palabra, String definicion) {
        this.id = id;
        this.palabra = palabra;
        this.definicion = definicion;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPalabra() {
        return this.palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public String getDefinicion() {
        return this.definicion;
    }

    public void setDefinicion(String definicion) {
        this.definicion = definicion;
    }

    public Palabra id(Long id) {
        setId(id);
        return this;
    }

    public Palabra palabra(String palabra) {
        setPalabra(palabra);
        return this;
    }

    public Palabra definicion(String definicion) {
        setDefinicion(definicion);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Palabra)) {
            return false;
        }
        Palabra palabra = (Palabra) o;
        return Objects.equals(id, palabra.id) && Objects.equals(palabra, palabra.palabra)
                && Objects.equals(definicion, palabra.definicion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, palabra, definicion);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", palabra='" + getPalabra() + "'" +
                ", definicion='" + getDefinicion() + "'" +
                "}";
    }

}
