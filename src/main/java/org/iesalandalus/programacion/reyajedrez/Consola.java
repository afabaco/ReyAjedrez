package org.iesalandalus.programacion.reyajedrez;

import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

    private Consola () {


    }

    public static void mostrarMenu() {

        System.out.println("Menú:");
        System.out.println("1. Crear rey por defecto.");
        System.out.println("2. Crear rey eligiendo color");
        System.out.println("3. Mover");
        System.out.println("4. Salir");

    }

    public static void elegirOpcionMenu() {

        int opcion;

        do {
            System.out.println("Elija una opción (1-4): ");
            opcion= Entrada.entero();

        } while (opcion<1 || opcion>4);


        }
    }


}

