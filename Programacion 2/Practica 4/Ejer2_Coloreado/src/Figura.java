public abstract class Figura {
    private String color;

    // Métodos no abstractos (concretos)
    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

    @Override
    public String toString() {
        return "Figura de color " + (color != null ? color : "no definido");
    }

    // Métodos abstractos (obligatorios para las clases hijas)
    public abstract double area();
    public abstract double perimetro();
}