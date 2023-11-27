package org.iesalandalus.programacion.reyajedrez;

import javax.naming.OperationNotSupportedException;

public class Rey {

    private Color color;
    private Posicion posicion;
    private int totalMovimientos = 0;

    public Rey() {
        setColor(Color.BLANCO);
        setPosicion(new Posicion(1, 'e'));
    }

    public Rey(Color color) {

        if (color==null) {
            throw new NullPointerException("ERROR: color no válido.");
        }

        setColor(color);

        if (color.equals(color.BLANCO)) {
            setPosicion(new Posicion(1, 'e'));
        } else {
            setPosicion(new Posicion(8, 'e'));
        }

    }


    public Color getColor() {

        return color;
    }

    public void setColor(Color color) {
        if (color == null) {
            throw new NullPointerException("El color no es correcto");
        } else {
            this.color = color;
        }

    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        if (posicion == null) {

            throw new NullPointerException("La posicion no es valida");
        }


        this.posicion = posicion;
    }

    public int getTotalMovimientos() {
        return totalMovimientos;
    }

    public void setTotalMovimientos(int totalMovimientos) {
        this.totalMovimientos = totalMovimientos;
    }

    public void mover(Direccion direccion) throws OperationNotSupportedException {

        int nuevaFila = posicion.getFila();
        char nuevaColumna = posicion.getColumna();


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
            case SUROESTE:
                nuevaFila--;
                nuevaColumna--;
                break;
            case SUR:
                nuevaFila--;
                break;
            case OESTE:
                nuevaColumna--;
                break;
            case NOROESTE:
                nuevaFila++;
                nuevaColumna--;
                break;
            case ENROQUE_CORTO:
                nuevaColumna++;
                nuevaColumna++;

                comprobarEnroque();


                break;
            case ENROQUE_LARGO:
                nuevaColumna--;
                nuevaColumna--;

                comprobarEnroque();
                break;


            default:
                throw new NullPointerException("Error:El movimiento no puede ser nulo.");

        }
        if ((nuevaFila < 1 || nuevaFila > 8) && (nuevaColumna < 'A' || nuevaColumna > 'H')) {
            throw new OperationNotSupportedException("ERROR: El Rey se sale del tablero.");
        } else {
            setPosicion(new Posicion(nuevaFila, nuevaColumna));
            totalMovimientos++;
        }


    }

    private void comprobarEnroque() throws OperationNotSupportedException {



        Rey reyBlanco=new Rey();



        reyBlanco.setPosicion(new Posicion(1,'e'));

        Rey reyNegro=new Rey();


        reyNegro.setPosicion(new Posicion(8,'e'));

        if (getColor().equals(Color.BLANCO) && (getPosicion().equals(reyBlanco.getPosicion()) && (getTotalMovimientos()==0))) {


        } else if (getColor().equals(Color.NEGRO) && (getPosicion().equals(reyNegro.getPosicion()) && (getTotalMovimientos()==0))){

        } else {
            throw new OperationNotSupportedException("ERROR: movimiento no válido.");
        }

    }


    @Override
    public String toString() {
        return "El rey es de color: " + color +
                ". " + posicion +
                "El total de movimientos es:" + totalMovimientos + ".";
    }

}
