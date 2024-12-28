public class Explorador {
    String nombre;
    Posicion posicionActual;

    public Explorador(String nombre) {
        this.nombre = nombre;
        this.posicionActual = new Posicion(0, (int) (Math.random() * 6));
    }

    public String getNombre() {
        return nombre;
    }

    public Posicion getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(Posicion posicionActual) {
        this.posicionActual = posicionActual;

    }

    public void Moverse(int direccion) {
        int fila = posicionActual.getCoordenadaFila();
        int columna = posicionActual.getCoordenadaCol();
        switch (direccion){
            case 1:
                if (fila >0)fila--;
                break;
            case 2:
                if (fila< 5) fila++;
            case 3:
                if (columna <19)columna++;
                break;
            case 4:
                if (columna >0)columna--;
                break;
            default:
                System.out.println("Direccion no disponible");
        }
        posicionActual.setCoordenadaCol(columna);
        posicionActual.setCoordenadaFila(fila);
    }
}
