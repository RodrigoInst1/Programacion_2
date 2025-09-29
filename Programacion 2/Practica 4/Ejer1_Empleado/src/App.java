import java.util.Scanner;
import java.util.Locale;

public class App {
    public static void main(String[] args) {
        System.out.println("*******RODRIGO CATUNTA SIRPA*******");
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        
        Empleado[] empleados = new Empleado[5];

        System.out.println("--- Ingrese los datos de 3 Empleados de Tiempo Completo ---");
        for (int i = 0; i < 3; i++) {
            System.out.println("\nEmpleado #" + (i + 1));
            System.out.print("Nombre: ");
            String nombre = scanner.next();
            System.out.print("Salario Anual: ");
            double salarioAnual = scanner.nextDouble();
            empleados[i] = new EmpleadoTiempoCompleto(nombre, salarioAnual);
        }

        System.out.println("\n--- Ingrese los datos de 2 Empleados de Tiempo Horario ---");
        for (int i = 0; i < 2; i++) {
            System.out.println("\nEmpleado #" + (i + 1));
            System.out.print("Nombre: ");
            String nombre = scanner.next();
            System.out.print("Horas Trabajadas: ");
            double horas = scanner.nextDouble();
            System.out.print("Tarifa por Hora: ");
            double tarifa = scanner.nextDouble();
            empleados[i + 3] = new EmpleadoTiempoHorario(nombre, horas, tarifa);
        }
        
        scanner.close();

        System.out.println("\n=============================================");
        System.out.println("   REPORTE DE SALARIOS MENSUALES");
        System.out.println("=============================================");
        
        for (Empleado emp : empleados) {
            System.out.printf("Empleado: %-15s | Salario Mensual: Bs: %.2f%n", 
                              emp.getNombre(), emp.CalcularSalarioMensual());
        }
        System.out.println("=============================================");
    }
}