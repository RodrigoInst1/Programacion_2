import java.util.Random;

public class App {
    public static void main(String[] args) {
        System.out.println("*******RODRIGO CATUNTA SIRPA*******");
        // Crear un arreglo para cinco figuras
        Figura[] figuras = new Figura[5];
        Random aleatorio = new Random();

        // Llenar el arreglo con Cuadrados o Círculos aleatorios
        for (int i = 0; i < figuras.length; i++) {
            int tipoFigura = aleatorio.nextInt(2) + 1; // Genera 1 (Cuadrado) o 2 (Círculo)
            double medida = 1 + aleatorio.nextDouble() * 9; // Genera un tamaño entre 1.0 y 10.0

            if (tipoFigura == 1) {
                figuras[i] = new Cuadrado(medida);
                System.out.printf("Creando un Cuadrado de lado %.2f%n", medida);
            } else {
                figuras[i] = new Circulo(medida);
                System.out.printf("Creando un Círculo de radio %.2f%n", medida);
            }
        }

        System.out.println("\n--- Procesando Figuras ---");

        for (Figura fig : figuras) {
            System.out.println("----------------------------------------");
            System.out.println("Figura: " + fig.getClass().getSimpleName());
            System.out.printf("Área: %.2f%n", fig.area());
            System.out.printf("Perímetro: %.2f%n", fig.perimetro());

            //verificar si el objeto es "coloreable"
            if (fig instanceof Coloreado) {
                //Si es una instancia de Coloreado, podemos llamar a su método.
                //Hacemos un "casting" para convertir la referencia de Figura a Coloreado.
                Coloreado objColoreado = (Coloreado) fig;
                System.out.println("Instrucción: " + objColoreado.comoColorear());
            }
        }
        System.out.println("----------------------------------------");
    }
}