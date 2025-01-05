public class Mapa {
    private char[][] tablero;
    private  Posicion posTesoro;
    Posicion posJugador;
   private  Enemigo[] listadoEnemigo;
    private Posicion[] posicionTrampas;
    private enemigoInteligente EnemigoInteligente;



    public Mapa() {
        tablero = new char[6][20];
        posicionTrampas = new Posicion[3];
        listadoEnemigo = new Enemigo[3];
        posTesoro = new Posicion((int) (Math.random() * 6), (int) (Math.random() * 20));
        posJugador = new Posicion((int) (Math.random() * 6), (int) (Math.random() * 20));
        EnemigoInteligente = new enemigoInteligente(new Posicion((int) (Math.random() * 6), (int) (Math.random() * 20)));
        for (int i = 0; i < listadoEnemigo.length; i++) {
            listadoEnemigo[i] = new Enemigo(new Posicion((int) (Math.random() * 6), (int) (Math.random() * 20)));
        }
        for (int i = 0; i < posicionTrampas.length; i++) {
            posicionTrampas[i] = new Posicion((int) (Math.random() * 6), (int) (Math.random() * 20));
        }
        mostrarMapa();
    }

    public void mostrarMapa() {
        EnemigoInteligente.enemigoInteligenteMoverse(posJugador,posicionTrampas,listadoEnemigo);

        // LIMPIAR EL TABLERO
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 20; j++) {
                tablero[i][j] = ' ';
            }
        }
        // METER ENEMIGOS , JUGADOR, TRAMPAS, TESORO
        tablero[posJugador.getCoordenadaFila()][posJugador.getCoordenadaCol()] = 'J';
        tablero[posTesoro.getCoordenadaFila()][posTesoro.getCoordenadaCol()] = ' ';
        tablero[EnemigoInteligente.getPosicion().getCoordenadaFila()][EnemigoInteligente.getPosicion().getCoordenadaCol()] = '*';


        for (int i = 0; i < listadoEnemigo.length; i++) {
            Enemigo enemigo = listadoEnemigo[i];
            Posicion pEmemigos = enemigo.getPosicionActual();
            tablero[pEmemigos.getCoordenadaFila()][pEmemigos.getCoordenadaCol()] ='E';
        }
        for (int i = 0; i < posicionTrampas.length; i++) {
            Posicion trampa = posicionTrampas[i];
            tablero[trampa.getCoordenadaFila()][trampa.getCoordenadaCol()] = 'T';
        }


        // SI TE ATRAPA EL ENEMIGO INTELIGENTE SE TERMINA EL JUEGO
        if (posJugador.getCoordenadaCol() == EnemigoInteligente.getPosicion().getCoordenadaCol() &&
        posJugador.getCoordenadaFila() == EnemigoInteligente.getPosicion().getCoordenadaFila()){
            System.out.println("Has sido atrapado por el enemigo inteligente!");
            return;
        }

        // SI CAES EN UNA TRAMPA SE TERMINA EL JUEGO
        for (int i = 0; i < posicionTrampas.length; i++) {
            Posicion posiciontrampas = posicionTrampas[i];
            if (posJugador.getCoordenadaCol() == posiciontrampas.getCoordenadaCol() &&
              posJugador.getCoordenadaFila() == posiciontrampas.getCoordenadaFila()){
                System.out.println("Has caido en una Trampa !  El juego a terminado");
                return;
            }
        }

        // SI CAES EN ENEMIGOS SE TERMINA EL JUEGO

        for (int i = 0; i < listadoEnemigo.length; i++) {
            Posicion pEnemigo = listadoEnemigo[i].getPosicionActual();
            if (posJugador.getCoordenadaCol() == pEnemigo.getCoordenadaCol() &&
            posJugador.getCoordenadaFila() == pEnemigo.getCoordenadaFila()){
                System.out.println("Has sido atrapado por un Enemigo");
                return;
            }
            
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
            if (i<5) {
                for (int fil = 0; fil < 39; fil++) {
                    System.out.print("-");
                }
                System.out.println();
            }
        }
    }

    public char[][] getTablero() {
        return tablero;
    }

    public Posicion getPosTesoro() {

        return posTesoro;
    }

}

