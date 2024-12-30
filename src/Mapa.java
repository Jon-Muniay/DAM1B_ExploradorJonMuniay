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
        tablero = new char[6][20];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 20; j++) {
                tablero[i][j] = ' ';
            }
        }
    }

    public void mostrarMapa() {
        System.out.print(" ");
        for (int j = 0; j < 20; j++) {
            System.out.print("----");
        }
        System.out.println("-");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 20; j++) {
                System.out.print("|" + tablero[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println(" ");
        for (int j = 0; j < 20; j++) {
            System.out.print("----");
        }
        System.out.println("-");
    }
    public char[][] getTablero() {
        return tablero;
    }

    public Posicion getPosTesoro() {
        return posTesoro;
    }
}

