public class Enemigo {
    private Posicion posicionActual;

    public Enemigo(Posicion nombreExplorador) {
        this.posicionActual = new Posicion(0, (int) (Math.random() * 6));
    }

    public Posicion getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(Posicion posicionActual) {
        this.posicionActual = posicionActual;
    }

    public void moverse(int direccion) {
        switch (direccion) {
            case 1:
                if (posicionActual.getCoordenadaFila() > 0) {
                    posicionActual.setCoordenadaFila(posicionActual.getCoordenadaFila() - 1);
                }
                break;
            case 2:
                if (posicionActual.getCoordenadaFila() < 5) {
                    posicionActual.setCoordenadaCol(posicionActual.getCoordenadaCol() + 1);
                }
            case 3:
                if (posicionActual.getCoordenadaCol() < 19) {
                    posicionActual.setCoordenadaCol(posicionActual.getCoordenadaCol() + 1);
                }
                break;
            case 4:
                if (posicionActual.getCoordenadaCol() > 0) {
                    posicionActual.setCoordenadaCol(posicionActual.getCoordenadaCol() - 1);
                }
                break;
        }


    }
}
