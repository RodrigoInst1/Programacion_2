import java.util.Scanner;
import java.util.Random;

class JuegoAdivinaNumero extends Juego {
    protected int numeroAAdivinar;
    protected Random random;
    protected Scanner scanner;

    public JuegoAdivinaNumero(int numeroDeVidas) {
        super(numeroDeVidas);
        random = new Random();
        scanner = new Scanner(System.in);
    }

    protected int generaNumeroAleatorio() {
        return random.nextInt(11); //0..10
    }

    public boolean validaNumero(int numero) {
        return numero >= 0 && numero <= 10;
    }

    public void juega() {
        reiniciaPartida();
        numeroAAdivinar = generaNumeroAleatorio();
        int intentos = 0;

        System.out.println("Adivina un número entre 0 y 10.");

        while (true) {
            System.out.print("Tu intento: ");
            int intento = scanner.nextInt();

            if (!validaNumero(intento)) {
                System.out.println("Número inválido. Debe estar entre 0 y 10.");
                continue;
            }

            intentos++;

            if (intento == numeroAAdivinar) {
                System.out.println("¡Acertaste!");
                actualizaRecord(intentos);
                break;
            } else {
                if (quitaVida()) {
                    if (intento < numeroAAdivinar) {
                        System.out.println("El número a adivinar es mayor. Te quedan " + numeroDeVidas + " vidas.");
                    } else {
                        System.out.println("El número a adivinar es menor. Te quedan " + numeroDeVidas + " vidas.");
                    }
                } else {
                    System.out.println("¡Has perdido! El número era " + numeroAAdivinar);
                    break;
                }
            }
        }
    }
}