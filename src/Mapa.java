public class Mapa {
    private char[][] tablero;
    private Posicion posTesoro;
    Posicion posJugador;
    private Enemigo[] listadoEnemigo;
    private Posicion[] posicionTrampas;
    private enemigoInteligente EnemigoInteligente;
    private static final String ANSI_ROJO = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";


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

        EnemigoInteligente.enemigoInteligenteMoverse(posJugador, posicionTrampas, listadoEnemigo);

        // MOVIMIENTO DE ENEMIGOS
        for (int i = 0; i < listadoEnemigo.length; i++) {
            Enemigo enemigo = listadoEnemigo[i];
            Posicion anteriorPosicion = enemigo.getPosicionActual();
            int direccion = (int) (Math.random() * 4) + 1;
            enemigo.moverse(direccion);

            int nuevaC = enemigo.getPosicionActual().getCoordenadaCol();
            int nuevaF = enemigo.getPosicionActual().getCoordenadaFila();


            // VER SI ESTA OCUPADO POR UNA TRAMPA O POR OTRO ENEMIGO
            boolean ocupado = false;

            for (int j = 0; j < posicionTrampas.length; j++) {
                if (posicionTrampas[i].getCoordenadaFila() == nuevaF && posicionTrampas[j].getCoordenadaCol() == nuevaC) {
                    ocupado = true;
                    break;
                }
            }
            if (!ocupado) {
                for (int j = 0; j < listadoEnemigo.length; j++) {
                    if (listadoEnemigo[j] != enemigo && listadoEnemigo[j].getPosicionActual().getCoordenadaFila() == nuevaF
                            && listadoEnemigo[j].getPosicionActual().getCoordenadaCol() == nuevaC) {
                        ocupado = true;
                        break;
                    }
                }
            }
            if (ocupado) {
                enemigo.setPosicionActual(anteriorPosicion);
            }
        }


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
            tablero[pEmemigos.getCoordenadaFila()][pEmemigos.getCoordenadaCol()] = 'E';
        }
        for (int i = 0; i < posicionTrampas.length; i++) {
            Posicion trampa = posicionTrampas[i];
            tablero[trampa.getCoordenadaFila()][trampa.getCoordenadaCol()] = 'T';
        }


        // GANA SI CAE EN EL TESORO
        if (posJugador.getCoordenadaCol() == posTesoro.getCoordenadaCol() && posJugador.getCoordenadaFila() ==
                posTesoro.getCoordenadaFila()){
            System.out.println("HAS GAANADO EL TESORO!");
            return;
        }


        // SI TE ATRAPA EL ENEMIGO INTELIGENTE SE TERMINA EL JUEGO
        if (posJugador.getCoordenadaCol() == EnemigoInteligente.getPosicion().getCoordenadaCol() &&
                posJugador.getCoordenadaFila() == EnemigoInteligente.getPosicion().getCoordenadaFila()) {
            System.out.println("Has sido atrapado por el enemigo inteligente!");
            return;
        }

        // SI CAES EN UNA TRAMPA SE TERMINA EL JUEGO
        for (int i = 0; i < posicionTrampas.length; i++) {
            Posicion posiciontrampas = posicionTrampas[i];
            if (posJugador.getCoordenadaCol() == posiciontrampas.getCoordenadaCol() &&
                    posJugador.getCoordenadaFila() == posiciontrampas.getCoordenadaFila()) {
                System.out.println("Has caido en una Trampa !  El juego a terminado");
                return;
            }
        }

        // SI CAES EN ENEMIGOS SE TERMINA EL JUEGO

        for (int i = 0; i < listadoEnemigo.length; i++) {
            Posicion pEnemigo = listadoEnemigo[i].getPosicionActual();
            if (posJugador.getCoordenadaCol() == pEnemigo.getCoordenadaCol() &&
                    posJugador.getCoordenadaFila() == pEnemigo.getCoordenadaFila()) {
                System.out.println("Has sido atrapado por un Enemigo");
                return;
            }

        }

        // FORMA DEL MAPA
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 20; j++) {
                if (i == EnemigoInteligente.getPosicion().getCoordenadaFila() && j == EnemigoInteligente.getPosicion().getCoordenadaCol()) {
                    System.out.print(ANSI_ROJO + "*" + ANSI_RESET);
                } else {
                    System.out.print(tablero[i][j]);
                }
                if (j < 19) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < 5) {
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

