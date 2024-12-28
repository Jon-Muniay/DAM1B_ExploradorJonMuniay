public class Mapa {
    char[][] tablero;
    Posicion posTesoro;
    Posicion posJugador;
    Enemigo[] listadoEnemigo;
    Posicion[] posicionTrampas;

    public Mapa() {
        tablero = new char[6][20];
        posicionTrampas = new Posicion[3];
        listadoEnemigo = new Enemigo[3];
    }

    public void mapa() {
        for (int i = 0; i <6; i++) {
            for (int j = 0; j < 20; j++) {
                tablero[i][j] = ' ';
            }
        }
        int trampas = (int) (Math.random());
        for (int i = 0; i <3;i++){
            int fila;
            int columna;

    }


        public char[][] getTablero () {
            return tablero;
        }

        public Posicion getPosTesoro () {
            return posTesoro;
        }
        public void mostrar () {


        }
    }
}
