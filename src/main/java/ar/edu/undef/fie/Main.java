package ar.edu.undef.fie;

// A continuación tienen el enunciado del ejercicio a realizar. Deben crear el repositorio dentro del Classroom de GitHub.
//
// Diseña un sistema de gestión de inventario de una librería en Java. Utiliza HashMap para almacenar los libros disponibles y sus cantidades, y listas para registrar los pedidos realizados por los clientes.
//
// Implementa clases para representar libros, librerías y clientes, y desarrolla métodos para:
//
//   - Añadir libros al inventario con la información del título, autor y género. Añade al menos 5 libros con sus cantidades iniciales.
//
//   - Realizar pedidos de libros: Implementa una función que permita a un cliente realizar un pedido de uno o más libros. Asegúrate de actualizar la cantidad disponible de cada libro pedido.
//
//   - Mostrar libros disponibles: Desarrolla una función que imprima todos los libros disponibles en el inventario, junto con su cantidad actual.
//
//   - Mostrar pedidos de un cliente: Implementa una función que permita ver los pedidos realizados por un cliente específico. Cada cliente debe tener una lista que almacene sus pedidos.
//
//   - Actualizar el inventario: Crea una función que permita añadir o retirar libros del inventario, actualizando la cantidad disponible.
//
// Notas:
//
// Asegúrate de manejar correctamente la disponibilidad de los libros.
// Incluye un menú interactivo para que el usuario pueda realizar operaciones como añadir libros, realizar pedidos, ver libros disponibles y ver pedidos de clientes.

import ar.edu.undef.fie.domain.Cliente;
import ar.edu.undef.fie.domain.Libreria;
import ar.edu.undef.fie.domain.Libro;

public class Main {
    public static void main(String[] args) {
        // Creo una libreria
        Libreria libreria = new Libreria();

        Libro libro1 = (new Libro("El principito", "Antoine", "Ficción", 10));
        Libro libro2 = (new Libro("La granja de Zenon", "Juancito", "Infantil", 5));
        Libro libro3 = (new Libro("Star Wars", "Lucas", "Ciencia Ficcion", 7));
        Libro libro4 = (new Libro("1985", "Matias", "Distopía", 2));
        Libro libro5 = (new Libro("Guia de Programacion en JAVA", "Gosling", "Aprendizaje", 1));

        // Agregar libros al inventario
        libreria.agregarLibro(libro1);
        libreria.agregarLibro(libro2);
        libreria.agregarLibro(libro3);
        libreria.agregarLibro(libro4);
        libreria.agregarLibro(libro5);

        // Crear un cliente
        Cliente cliente = new Cliente("Agustin Palacios");

        // Agrego lista a mi lista de pedidos
        cliente.agregarAlPedido(libro2);
        cliente.agregarAlPedido(libro5);

        // El cliente realiza un pedido a la libreria
        cliente.realizarPedido(libreria);

        // Mostrar libros disponibles
        System.out.println("\nLista de libros disponibles:\n");
        libreria.mostrarLibrosDisponibles();

        // Mostrar pedidos del cliente
        cliente.mostrarPedidosClinte();

        // Actualizar inventario
        libreria.actualizarInventario("Guia de Programacion en JAVA", 5);

        libreria.mostrarLibrosDisponibles(); // Para corroborar que se actualice la cantidad
    }
}