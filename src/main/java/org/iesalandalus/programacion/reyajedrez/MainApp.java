package org.iesalandalus.programacion.reyajedrez;

import javax.naming.OperationNotSupportedException;

public class MainApp {
    public static void main(String[] args) {
        int opcion;

        do {
            Consola.mostrarMenu();
            opcion=Consola.elegirOpcionMenu();
            ejecutarOpcion(opcion);
            mostrarRey();
            System.out.println("=================");
        }while (opcion!=4);


    }

    private static Rey rey;



    private static void ejecutarOpcion (int opcion) {

        switch (opcion) {

            case 1:
                crearReyDefecto();
                break;

            case 2:
                crearReyColor();
                break;

            case 3:
                mover();
                break;

            case 4:
                Consola.despedirse();
                break;

        }
    }

    private static void crearReyDefecto() {

        rey = new Rey();
    }

    private static void crearReyColor () {
        rey = new Rey(Consola.elegirColor());
    }

    private static void mover() {

        Direccion direccion = null;

        Consola.mostrarDirecciones();

        System.out.println("¿Que dirección quieres tomar?");
        direccion = Consola.elegirDireccion();


        try {
            rey.mover(direccion);
        }
        catch (OperationNotSupportedException e) {

            System.out.println(e.getMessage());
        }

    }

    private static void mostrarRey ()  {
        System.out.println(rey.toString());
    }



}

