package ar.edu.undef.fie;

import ar.edu.undef.fie.domain.Cliente;
import ar.edu.undef.fie.domain.Libreria;
import ar.edu.undef.fie.domain.Libro;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // FLUJO PRINCIPAL DEL ENUNCIADO

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

        // ACA TERMINA LA DEMOSTRACION



        // Menu interactivo

        // operaciones como añadir libros, realizar pedidos,
        // ver libros disponibles y ver pedidos de clientes.

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu interactivo de la libreria: ");
            System.out.println("1) Anadir libros");
            System.out.println("2) Realizar pedidos");
            System.out.println("3) Ver libros disponibles");
            System.out.println("4) Ver pedidos de cliente");
            System.out.println("5) EXIT");

            System.out.print("Ingresa el numero de accion: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Ingresa en titulo del libro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Ingresa el auto del libro: ");
                    String autor = scanner.nextLine();
                    System.out.print("Ingresa el genero del libro: ");
                    String genero = scanner.nextLine();
                    System.out.print("Ingresa la cantidad disponible: ");
                    String cantidadDisponible = scanner.nextLine();
                    var cantD = Integer.parseInt(cantidadDisponible);

                    Libro libroParaAgregar = (new Libro(titulo, autor, genero, cantD));
                    libreria.agregarLibro(libroParaAgregar);
                    break;

                case 2:
                    libreria.mostrarLibrosDisponibles();
                    System.out.print("Ingrese el titulo del libro que quiere pedir: ");
                    String tituloLibroPedido = scanner.nextLine();
                    cliente.agregarAlPedido(libreria.getInventario().get(tituloLibroPedido));
                    libreria.prestarLibro(tituloLibroPedido);
                    cliente.realizarPedido(libreria);
                    break;

                case 3:
                    System.out.println("\nLista de libros disponibles:\n");
                    libreria.mostrarLibrosDisponibles();
                    break;

                case 4:
                    System.out.println("Pedidos del cliente " + cliente.getNombre());
                    cliente.mostrarPedidosClinte();
                    break;

                case 5:
                    System.exit(0);
            }
        }
    }
}
