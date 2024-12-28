public class Enemigo {
    Posicion posicionActual;

    public Enemigo( String nombreExplorador) {
        this.posicionActual = new Posicion(0, (int) (Math.random() * 6));
    }

    public Posicion getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(Posicion posicionActual) {
        this.posicionActual = posicionActual;
    }
    public void moverse (){

    }
}
