import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("***** RODRIGO CATUNTA SIRPA *****");

        // Crear los vectores de ejemplo
        VectorTridimensional a = new VectorTridimensional(1, 2, 3);
        VectorTridimensional b = new VectorTridimensional(4, 5, 6);

        System.out.println("Vector a: " + a);
        System.out.println("Vector b: " + b);

        // Operaciones
        VectorTridimensional suma = a.sumar(b);
        System.out.println("Suma (a + b): " + suma);

        double escalar = 2.0;
        VectorTridimensional multEscalar = a.multiplicarPorEscalar(escalar);
        System.out.println("Multiplicación por escalar (" + escalar + " * a): " + multEscalar);

        System.out.println("Longitud de a: " + a.longitud());

        VectorTridimensional normal = a.normal();
        System.out.println("Normal de a: " + normal);

        double productoEscalar = a.productoEscalar(b);
        System.out.println("Producto escalar (a · b): " + productoEscalar);

        VectorTridimensional productoVectorial = a.productoVectorial(b);
        System.out.println("Producto vectorial (a x b): " + productoVectorial);

        sc.close();
    }
}