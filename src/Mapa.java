public class Mapa {
    char[][] tablero;
    Posicion posTesoro;
    Posicion posJugador;
    Enemigo[] listadoEnemigo;
    Posicion[] posicionTrampas;

    public Mapa() {
        tablero = new char[6][20];
        mostrarMapa();
        posicionTrampas = new Posicion[3];
        listadoEnemigo = new Enemigo[3];
        posTesoro = getPosTesoro();

    }
    public void mostrarMapa() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 20; j++) {
                System.out.print(tablero[i][j]);
            }
            System.out.println();
            for (int fil = 0; fil < 20 * 2- 1; fil++) {
                System.out.print("-");
                
            }
            System.out.println();
        }
    }
    public char[][] getTablero() {
        return tablero;
    }

    public Posicion getPosTesoro() {
        return  new Posicion((int) (Math.random()*6 ),(int ) (Math.random()*20));

    }

}

