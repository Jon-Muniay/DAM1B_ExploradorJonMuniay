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
        posTesoro = getPosTesoro();
        posJugador = new Posicion((int) (Math.random() * 6), (int) (Math.random() * 20));
        for (int i = 0; i < listadoEnemigo.length; i++) {
            listadoEnemigo[i] = new Enemigo(new Posicion((int) (Math.random() * 6), (int) (Math.random() * 20)));
        }
        for (int i = 0; i < posicionTrampas.length; i++) {
            posicionTrampas[i] = new Posicion((int) (Math.random() * 6), (int) (Math.random() * 20));
        }
        mostrarMapa();
    }

    public void mostrarMapa() {

        // LIMPIAR EL TABLERO
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 20; j++) {
                tablero[i][j] = ' ';
            }
        }
        // METER ENEMIGOS , JUGADOR, TRAMPAS, TESORO
        tablero[posJugador.getCoordenadaFila()][posJugador.getCoordenadaCol()] = 'J';
        tablero[posTesoro.getCoordenadaFila()][posTesoro.getCoordenadaCol()] = ' ';

        for (int i = 0; i < listadoEnemigo.length; i++) {
            Enemigo enemigo = listadoEnemigo[i];
            Posicion pEmemigos = enemigo.getPosicionActual();
            tablero[pEmemigos.getCoordenadaFila()][pEmemigos.getCoordenadaCol()] ='E';
        }
        for (int i = 0; i < posicionTrampas.length; i++) {
            Posicion trampa = posicionTrampas[i];
            tablero[trampa.getCoordenadaCol()][trampa.getCoordenadaFila()] = 'T';
        }
        // FORMA DEL MAPA
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 20; j++) {
                System.out.print(tablero[i][j]);
                if (j < 19) {
                    System.out.print("|");
                }
            }
            System.out.println();
            for (int fil = 0; fil < 39; fil++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public char[][] getTablero() {
        return tablero;
    }

    public Posicion getPosTesoro() {

        return posTesoro;
    }

}

