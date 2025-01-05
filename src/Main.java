import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        boolean jugando = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("********************************");
        System.out.println("Bienvenido al juego del explorador");
        System.out.println("********************************");
        Mapa mapa = new Mapa();
        Explorador explorador = new Explorador("Jon");

        while (jugando){
            System.out.println("1 = Arriba" +" 2 = Abajo" +" 3 = Derecha"+ " 4 = izquierda");
            System.out.println("Que accion quiere realizar? ");
            int letra = scanner.nextInt();
            explorador.Moverse(letra);
            mapa.posJugador = explorador.getPosicionActual();
            mapa.mostrarMapa();

        }
        scanner.close();


    }

}
