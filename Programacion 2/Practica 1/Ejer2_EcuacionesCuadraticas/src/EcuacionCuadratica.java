import java.util.Scanner;
//RODRIGO CATUNTA SIRPA
//IMAGENES DEL UML Y LAS PRUEBAS EN LA CARPETA lib

public class EcuacionCuadratica {
    //Inciso a
    private double a;
    private double b;
    private double c;

    //inciso b
    public EcuacionCuadratica(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    //inciso c discriminante
    public double getDiscriminante(){
        return Math.pow(b, 2) - 4 * a * c;
    }

    //inciso d Raiz1 y Raiz2
    public double getRaiz1(){
        return (-b + Math.sqrt(getDiscriminante())) / (2 * a);
    }

    public double getRaiz2(){
        return (-b - Math.sqrt(getDiscriminante())) / (2 * a);
    }

    //disc = discriminante
    public String toString(){
        double disc = getDiscriminante();
        if (disc > 0) {
            return String.format("La ecuacion tiene dos raices %.6f y %.6f", getRaiz1(), getRaiz2());
        } else if (disc == 0) {
            return String.format("La ecuacion tiene una raiz %.6f", getRaiz1());
        } else {
            return "La ecuacion no tiene raices reales";
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //primer ejemplo (ingresar 1,3,1)
        //segundo ejemplo (ingresar 1,2,1)
        //tercer ejemplo (ingresar 1,2,3)
        System.out.println("Ingrese a, b, c: ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        //Creando la ecuacion cuadratica
        EcuacionCuadratica eq1 = new EcuacionCuadratica(a, b, c);
        System.out.println(eq1);
        //IMAGENES DEL UML Y LAS PRUEBAS EN LA CARPETA lib 
    }
}
