import java.util.Random;
import java.util.Scanner;

public class JuegoAdivinaNumero extends Juego {
    private int numeroAAdivinar;

    public JuegoAdivinaNumero(int numeroDeVidas) {
        super(numeroDeVidas);
    }

    @Override
    public void juega() {
        reiniciaPartida(3); // reinicia con 3 vidas
        numeroAAdivinar = new Random().nextInt(11); // número entre 0 y 10

        Scanner sc = new Scanner(System.in);
        System.out.println("***** Juego Adivina Número *****");
        System.out.println("Adivina un número entre 0 y 10.");

        while (true) {
            System.out.print("Tu intento: ");
            int intento = sc.nextInt();

            if (intento == numeroAAdivinar) {
                System.out.println("¡Acertaste!");
                actualizaRecord(numeroDeVidas);
                break;
            } else {
                if (!quitaVida()) {
                    System.out.println("¡Has perdido! El número era " + numeroAAdivinar);
                    break;
                } else {
                    if (intento < numeroAAdivinar) {
                        System.out.println("El número a adivinar es mayor. Te quedan " + numeroDeVidas + " vidas.");
                    } else {
                        System.out.println("El número a adivinar es menor. Te quedan " + numeroDeVidas + " vidas.");
                    }
                }
            }
        }
    }
}
