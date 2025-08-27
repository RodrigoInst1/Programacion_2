import java.util.Scanner;

public class EstadisticaV1 {
    //atributo privado
    private double[] datos;

    //constructor con argumento
    public EstadisticaV1(double[] datos) {
        this.datos = datos;
    }

    //Promedio
    public double promedio() {
        double suma = 0;
        for (double num : datos) {
            suma += num;
        }
        return suma / datos.length;
    }

    //desviacion
    public double desviacion() {
        double media = promedio();
        double suma = 0;
        for (double num : datos) {
            suma += Math.pow(num - media, 2);
        }
        return Math.sqrt(suma / (datos.length - 1));
    }

    public String toString() {
        return String.format("El promedio es %.2f%nLa desviacion estandar es %.5f",
                promedio(), desviacion());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //creando el objeto valores
        double[] valores = new double[10];

        System.out.println("Ingrese 10 numeros separados por espacio:");
        for (int i = 0; i < 10; i++) {
            valores[i] = sc.nextDouble();
        }

        //creando el objeto est
        EstadisticaV1 est = new EstadisticaV1(valores);

        System.out.println(est);
    }
}
