package ar.edu.undef.fie.domain;

//   - Añadir libros al inventario con la información del
//   título, autor y género. Añade al menos 5 libros con sus cantidades iniciales.

// Crear una clase Libro con atributos como idLibro, titulo, autor.

import com.sun.tools.attach.AgentInitializationException;

public class Libro {
    private String titulo;
    private String autor;
    private String genero;
    private int cantidadDisponible;

    public Libro(String titulo, String autor, String genero, int cantidadDisponible) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.cantidadDisponible = cantidadDisponible;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }
    public String getGenero() {
        return genero;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    @Override
    public String toString() {
        return "Titulo: " + titulo + '\n' +
                "Autor: " + autor + '\n';
    }
}