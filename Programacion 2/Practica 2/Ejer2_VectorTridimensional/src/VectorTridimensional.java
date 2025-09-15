public class VectorTridimensional {
    private double x;
    private double y;
    private double z;

    //RODRIGO CATUNTA SIRPA
    public VectorTridimensional(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    //Método para la suma de vectores (a + b)
    public VectorTridimensional sumar(VectorTridimensional otroVector) {
        return new VectorTridimensional(
            this.x + otroVector.x,
            this.y + otroVector.y,
            this.z + otroVector.z
        );
    }

    //Método para la resta de vectores (a - b)
    public VectorTridimensional restar(VectorTridimensional otroVector) {
        return new VectorTridimensional(
            this.x - otroVector.x,
            this.y - otroVector.y,
            this.z - otroVector.z
        );
    }

    //Método para la multiplicación por un escalar (r * a)
    public VectorTridimensional multiplicarPorEscalar(double r) {
        return new VectorTridimensional(
            r * this.x,
            r * this.y,
            r * this.z
        );
    }

    //Método para la longitud de un vector |a|
    public double longitud() {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2));
    }

    //Método para el vector normal (a / |a|)
    public VectorTridimensional normal() {
        double longitud = longitud();
        if (longitud == 0) {
            return new VectorTridimensional(0, 0, 0);
        }
        return new VectorTridimensional(
            this.x / longitud,
            this.y / longitud,
            this.z / longitud
        );
    }

    //Método para el producto escalar (a · b)
    public double productoEscalar(VectorTridimensional otroVector) {
        return (this.x * otroVector.x) + (this.y * otroVector.y) + (this.z * otroVector.z);
    }

    //Método para el producto vectorial (a x b)
    public VectorTridimensional productoVectorial(VectorTridimensional otroVector) {
        double nuevoX = (this.y * otroVector.z) - (this.z * otroVector.y);
        double nuevoY = (this.z * otroVector.x) - (this.x * otroVector.z);
        double nuevoZ = (this.x * otroVector.y) - (this.y * otroVector.x);
        return new VectorTridimensional(nuevoX, nuevoY, nuevoZ);
    }

    @Override
    public String toString() {
        return String.format("<%.2f, %.2f, %.2f>", x, y, z);
    }
}