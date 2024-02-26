package ar.edu.undef.fie.domain;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nombre;
    private List<Libro> librosPedidos;

    // Entiendo que una cosa es el pedido del cliente y otra
    // los libros que realmente la libreria le puede ofrecer
    // Además segun el enunciado me limito a tener estas 3 clases
    // Se podria hacer una clase Pedido para gestionar estas acciones
    private ArrayList<Libro> librosEnPoder;

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.librosPedidos = new ArrayList<>();
        this.librosEnPoder = new ArrayList<>();
    }

    // Realizar pedidos de libros: Implementa una función que permita a un cliente realizar
    // un pedido de uno o más libros. Asegúrate de actualizar la cantidad disponible de cada libro pedido.

    public void realizarPedido(Libreria libreria) {
        for (Libro libro : librosPedidos ){
            if (libreria.libroDisponible(libro)) {
                libreria.prestarLibro(libro.getTitulo());
                System.out.println("Se presta el libro " + libro.getTitulo() + " a el cliente " + this.nombre);
                librosEnPoder.add(libro);
            } else {
                System.out.println("Los libros pedidos no estan disponibles");
            }
        }
    }

    // Funcion para agregar libros al pedido
    public void agregarAlPedido(Libro libro) {
        this.librosPedidos.add(libro);
    }

    // Mostrar pedidos de un cliente: Implementa una función que permita ver los pedidos
    // realizados por un cliente específico. Cada cliente debe tener una lista que almacene sus pedidos.

    public void mostrarPedidosClinte(){
        System.out.println("Estos son los pedidos del cliente " + this.nombre);
        for (Libro libro : this.librosPedidos){
            System.out.println(libro);
        }
        System.out.println("Estos son los libros que tiene en su poder:");
        for (Libro libro : this.librosEnPoder){
            System.out.println(libro);
        }
    }

    // Se podria hacer una funcion para devolver esos libros
}
