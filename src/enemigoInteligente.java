public class enemigoInteligente {
    private Posicion posicion;

    public enemigoInteligente(Posicion posicion) {
        this.posicion = posicion;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public void enemigoInteligenteMoverse(Posicion posicionExplorador, Posicion[] trampas, Enemigo[] enemigos) {
        int Columna = posicion.getCoordenadaCol();
        int Fila = posicion.getCoordenadaFila();
        int filaExplorador = posicionExplorador.getCoordenadaFila();
        int columnaExploradr = posicionExplorador.getCoordenadaCol();

        boolean mover = false;

        if (Fila != filaExplorador) {
            if (Fila > filaExplorador && !pOcupada(Fila,Columna-1,trampas,enemigos)){
                Columna --;
            } else if (Columna < columnaExploradr && !pOcupada(Fila,Columna +1,trampas,enemigos)) {
                Columna ++;
                
            }
            mover = true;
        }
        if (!mover && Columna != columnaExploradr){
            if (Columna > columnaExploradr && !pOcupada(filaExplorador,Columna-1,trampas,enemigos)){
                Columna --;
            }else if (Columna < columnaExploradr && !pOcupada(Fila,Columna+1,trampas,enemigos)){
                Columna ++;
            }
        }
        posicion.setCoordenadaCol(Columna);
        posicion.setCoordenadaFila(Fila);
    }

    private boolean pOcupada(int Fila, int columna, Posicion[] trampas, Enemigo[] enemigos) {
        for (int i = 0; i < trampas.length; i++) {
            if (trampas[i].getCoordenadaFila() == Fila && trampas[i].getCoordenadaCol() == columna) {
                return true;
            }
        }
        for (int i = 0; i < enemigos.length; i++) {
            if (enemigos[i].getPosicionActual().getCoordenadaFila() == Fila
                    && enemigos[i].getPosicionActual().getCoordenadaCol() == columna) {
                return true;
            }
        }
        return false;
    }
}
