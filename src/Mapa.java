public class Mapa {
    char [][] tablero;
    Posicion posTesoro;
    Posicion posJugador;
    Enemigo [] listadoEnemigo;
    Posicion [] posicionTrampas;

    public Mapa() {
        tablero = new char[6][20];
    }

    public char[][] getTablero() {
        return tablero;
    }

    public Posicion getPosTesoro() {
        return posTesoro;
    }
}
