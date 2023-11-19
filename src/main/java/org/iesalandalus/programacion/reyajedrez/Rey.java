package org.iesalandalus.programacion.reyajedrez;

import javax.naming.OperationNotSupportedException;

public class Rey {

    private Color color;
    private Posicion posicion;
    private int totalMovimientos;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {

        if (color != Color.BLANCO || color != Color.NEGRO) {

            throw new IllegalArgumentException("ERROR: Color no válido.");
        } else {
            this.color = color;
        }

    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {

        if (posicion == null) {

            throw new NullPointerException();
        } else {
            this.posicion = posicion;
        }
    }

    public int getTotalMovimientos() {
        return totalMovimientos;
    }

    public void setTotalMovimientos(int totalMovimientos) {
        this.totalMovimientos = totalMovimientos;
    }

    //Constructor por defecto
    private Rey (){

        setColor(Color.BLANCO);
        setPosicion(new Posicion(1,'e'));
    }

    //Constructor parámetros

    private Rey (Color color) {

        if (color.equals(Color.BLANCO)) {

            setPosicion(new Posicion(1,'e'));
        } else {

            setPosicion(new Posicion(8,'e'));
        }
    }

    // Método mover

    public void mover (Direccion direccion) throws OperationNotSupportedException {

        int nuevaFila=posicion.getFila();
        char nuevaColumna= posicion.getColumna();
        totalMovimientos=0;

        if (direccion == null) {

            throw new NullPointerException("ERROR: se sale del tablero.");
        }

        switch (direccion) {

            case NORTE:

                nuevaFila++;
                break;

            case NORESTE:

                nuevaFila++;
                nuevaColumna++;
                break;

            case ESTE:
                nuevaColumna++;
                break;

            case SURESTE:
                nuevaFila--;
                nuevaColumna++;
                break;

            case SUR:
                nuevaFila--;

            case SUROESTE:
                nuevaFila--;
                nuevaColumna--;
                break;

            case OESTE:
                nuevaColumna--;
                break;

            case NOROESTE:
                nuevaFila++;
                nuevaColumna--;
                break;

            case ENROQUE_CORTO:
                if (totalMovimientos>0) {

                throw new NullPointerException("ERROR: movimiento no válido. ");

                } else {

                    nuevaColumna++;
                    nuevaColumna++;

                } break;

            case ENROQUE_LARGO:
                if (totalMovimientos>0) {

                    throw new NullPointerException("ERROR: movimiento no válido.");
                } else {

                    nuevaColumna--;
                    nuevaColumna--;
                }

            default: setPosicion(new Posicion (nuevaFila, nuevaColumna));

        }
    }

    @Override
    public String toString() {
        return "Rey{" +
                "color=" + color +
                ", posicion=" + posicion +
                '}';
    }
}
