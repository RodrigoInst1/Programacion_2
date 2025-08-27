import java.util.Scanner;

public class EstadisticaV2 {
    private double a, b, c, d, e, f, g, h, i, j;

    public EstadisticaV2(double a, double b, double c, double d, double e,
                        double f, double g, double h, double i, double j) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
        this.j = j;
    }

    public double promedio() {
        double suma = a + b + c + d + e + f + g + h + i + j;
        return suma / 10.0;
    }

    public double desviacion() {
        double media = promedio();
        double suma = Math.pow(a - media, 2) + Math.pow(b - media, 2) +
                      Math.pow(c - media, 2) + Math.pow(d - media, 2) +
                      Math.pow(e - media, 2) + Math.pow(f - media, 2) +
                      Math.pow(g - media, 2) + Math.pow(h - media, 2) +
                      Math.pow(i - media, 2) + Math.pow(j - media, 2);
        return Math.sqrt(suma / 9);
    }

    // toString
    @Override
    public String toString() {
        return String.format("El promedio es %.2f%nLa desviacion estándar es %.5f",
                promedio(), desviacion());
    }

    // Programa de prueba
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese 10 numeros");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        double d = sc.nextDouble();
        double e = sc.nextDouble();
        double f = sc.nextDouble();
        double g = sc.nextDouble();
        double h = sc.nextDouble();
        double i = sc.nextDouble();
        double j = sc.nextDouble();

        EstadisticaV2 est = new EstadisticaV2(a, b, c, d, e, f, g, h, i, j);

        System.out.println(est);
    }
}
