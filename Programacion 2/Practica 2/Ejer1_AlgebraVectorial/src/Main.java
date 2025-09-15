import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("***** Rodrigo Catunta Sirpa *****");
        Scanner sc = new Scanner(System.in);
        try {
            
            System.out.println("Ingrese las componentes del Vector A (x, y, z):");
            double ax = sc.nextDouble();
            double ay = sc.nextDouble();
            double az = sc.nextDouble();
            AlgebraVectorial a = new AlgebraVectorial(ax, ay, az);

            System.out.println("Ingrese las componentes del Vector B (x, y, z):");
            double bx = sc.nextDouble();
            double by = sc.nextDouble();
            double bz = sc.nextDouble();
            AlgebraVectorial b = new AlgebraVectorial(bx, by, bz);

            System.out.println("\n***** Resultados *****");
            System.out.println("Vector A: " + a);
            System.out.println("Vector B: " + b);
            
            System.out.println("\n--- Perpendicularidad ---");
            System.out.println("Son perpendiculares (producto punto)= " + a.perpendicular(b));
            System.out.println("Son perpendiculares (fórmula de magnitud)= " + a.perpendicular(b, 1));
            
            System.out.println("\n--- Paralelismo ---");
            System.out.println("Son paralelos (fórmula de razones)= " + a.paralelo(b));
            System.out.println("Son paralelos (producto cruz)= " + a.paralelo(b, true));
            
            System.out.println("\n--- Proyección de A sobre B ---");
            AlgebraVectorial proyeccion = a.proyeccion(b);
            System.out.println("La proyección de A sobre B es: " + proyeccion);

            System.out.println("\n--- Componente de A en la dirección de B ---");
            double componente = a.componente(b);
            System.out.println("El componente de A en la dirección de B es: " + String.format("%.2f", componente));

        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, ingrese solo números.");
        } finally {
            sc.close();
        }
    }
}