public abstract class Empleado {
    protected String nombre;

    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract double CalcularSalarioMensual();

    @Override
    public String toString() {
        return "Nombre: " + nombre;
    }
}