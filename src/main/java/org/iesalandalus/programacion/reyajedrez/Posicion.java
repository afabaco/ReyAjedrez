package org.iesalandalus.programacion.reyajedrez;

import java.util.Objects;

public class Posicion {

    //Variables

    private int fila;
    private char columna;

    // Constructor parámetros
    public Posicion (int fila, char columna){

        setFila(fila);
        setColumna(columna);
    }

    //Constructor copia

    public Posicion (Posicion posicion){

        setFila(posicion.getFila());
        setColumna(posicion.getColumna());

    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {

        if (fila <1 || fila>8) {

            throw new IllegalArgumentException("ERROR: Fila no válida.");
        }
        this.fila = fila;
    }

    public char getColumna() {
        return columna;
    }

    public void setColumna(char columna) {

        if (columna <'a' || columna>'h') {

            throw new IllegalArgumentException("ERROR: Columa no válida.");
        }
        this.columna = columna;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Posicion posicion = (Posicion) o;
        return fila == posicion.fila && columna == posicion.columna;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fila, columna);
    }


}
