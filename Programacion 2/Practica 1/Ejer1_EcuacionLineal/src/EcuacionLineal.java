import java.util.Scanner;
//RODRIGO CATUNTA SIRPA
//Imagenes del UML y las 2 pruebas de terminal en la carpeta lib 

public class EcuacionLineal {

    //inciso a atributos privados adcdef
    private double a;
    private double b;
    private double c;
    private double d;
    private double e;
    private double f;

    //inciso b Constructor
    public EcuacionLineal(double a, double b, double c, double d, double e, double f){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    //true si no es cero
    public boolean tieneSolucion(){
        return (a * d - b * c) != 0;
    }

    //calcula x
    public double getX(){
        return (e * d - b * f) / (a * d - b * c);
    }

    //calcula y
    public double getY(){
        return (a * f - e * c) / (a * d - b * c);
    }

    //si es 0 no hay solucion
    public String toString(){
        if (tieneSolucion()) {
            return String.format("Ecuacion Lineal: (%.1f)x + (%.1f)y = %.1f, (%.1f)x + (%.1f)y = %.1f \nSolución: x = %.2f, y = %.2f",
                                  a, b, e, c, d, f, getX(), getY());
        } else {
            return String.format("Ecuacion Lineal: (%.1f)x + (%.1f)y = %.1f, (%.1f)x + (%.1f)y = %.1f\nLa ecuación no tiene solución",
                                  a, b, e, c, d, f);
        }
    }

    public static void main(String[] args){
        //ingresando datos abcdef
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese a, b, c, d, e, f: ");
        
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        double d = sc.nextDouble();
        double e = sc.nextDouble();
        double f = sc.nextDouble();

        //Creando la ecuacionlineal
        EcuacionLineal eq1 = new EcuacionLineal(a, b, c, d, e, f);
        System.out.println("***** Solución *****");
        System.out.println(eq1);
        //Imagenes del UML y las 2 pruebas de terminal en la carpeta lib 
    }
}