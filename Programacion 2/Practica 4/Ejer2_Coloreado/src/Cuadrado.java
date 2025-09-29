public class Cuadrado extends Figura implements Coloreado {
    private double lado;

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    @Override
    public double area() {
        return lado * lado;
    }

    @Override
    public double perimetro() {
        return 4 * lado;
    }

    //Implementación obligatoria del método de la interfaz Coloreado
    @Override
    public String comoColorear() {
        return "Colorear los cuatro lados.";
    }
}