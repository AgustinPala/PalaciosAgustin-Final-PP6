package ar.edu.undef.fie.domain;

// Mi calse Libreria tendra


import java.util.ArrayList;
import java.util.HashMap;

public class Libreria {

    private HashMap<String, Libro> inventario;

    private ArrayList<Libro> librosPrestados;

    public Libreria() {
        inventario = new HashMap<>();
        librosPrestados = new ArrayList<>();
    }

    public HashMap<String, Libro> getInventario() {
        return inventario;
    }

    // Añadir libros al inventario con la información del título, autor y género.
    // Utiliza HashMap para almacenar los libros disponibles y sus cantidades
    // Mi key va a ser el titulo, para obtenerl a cantidad disponible tengo mi value (Libro)

    public void agregarLibro(Libro libro) {
        if (this.inventario.containsKey(libro.getTitulo())) {
            System.out.println("El libro que intenta agregar ya existe: " + libro.getTitulo());
        } else {
            inventario.put(libro.getTitulo(), libro);
        }
    }

    // Prestar un libro (reducir la cantidad disponible).
    public void prestarLibro(String titulo) {
        if (this.inventario.containsKey(titulo)) {
            Libro libro = inventario.get(titulo);
            if (libro.getCantidadDisponible() > 0) {
                libro.setCantidadDisponible(libro.getCantidadDisponible() - 1);
                librosPrestados.add(libro);
                System.out.println("Se presta el libro " + libro.getTitulo());
            } else {
                System.out.println("No hay suficientes libros " + libro.getTitulo());
            }
        } else {
            System.out.println("El libro que quiere prestar no existe");
        }
    }

    public boolean libroDisponible(Libro libro){
        return this.inventario.containsKey(libro.getTitulo());
    }

    // Mostrar libros disponibles: Desarrolla una función que imprima
    // todos los libros disponibles en el inventario, junto con su cantidad actual.
    public void mostrarLibrosDisponibles() {
        for (Libro libro : this.inventario.values()) {
            if (libro.getCantidadDisponible() > 0) {
                System.out.println("Titulo: " + libro.getTitulo());
                System.out.println("Autor: " + libro.getAutor());
                System.out.println("Genero: " + libro.getGenero());
                System.out.println("Cantidad: " + libro.getCantidadDisponible());
                System.out.println();
            }
        }
    }

    // Actualizar el inventario: Crea una función que permita añadir
    // o retirar libros del inventario, actualizando la cantidad disponible.

    public void actualizarInventario(String titulo, int cantidad) {
        if (this.inventario.containsKey(titulo)) {
            Libro libroInventario = this.inventario.get(titulo);
            libroInventario.setCantidadDisponible(libroInventario.getCantidadDisponible() + cantidad);
        } else {
            System.out.println("El libro " + titulo + " no se encuentra en el inventario.");
        }
    }
}