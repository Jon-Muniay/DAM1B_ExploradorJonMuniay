//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("********************************");
        System.out.println("Bienvenido al juego del explorador");
        System.out.println("********************************");
        Mapa mapa = new Mapa();
        Explorador explorador = new Explorador("Jon");
        mapa.mostrarMapa();


    }

}
