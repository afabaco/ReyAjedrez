package org.iesalandalus.programacion.reyajedrez;

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




}
