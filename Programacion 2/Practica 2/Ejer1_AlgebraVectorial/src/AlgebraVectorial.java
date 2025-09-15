public class AlgebraVectorial {
    private double x, y, z;

    //RODRIGO CATUNTA SIRPA
    //Constructor para vectores 3D
    public AlgebraVectorial(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    //Constructor sobrecargado para vectores 2D
    public AlgebraVectorial(double x, double y) {
        this.x = x;
        this.y = y;
        this.z = 0;
    }

    //Calcula el producto punto de dos vectores
    public double productoPunto(AlgebraVectorial v2) {
        return (this.x * v2.x) + (this.y * v2.y) + (this.z * v2.z);
    }

    //Calcula la magnitud (norma) del vector
    public double magnitud() {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2));
    }

    //Perpendicularidad usando el producto punto (a · b = 0)
    public boolean perpendicular(AlgebraVectorial v2) {
        return Math.abs(this.productoPunto(v2)) < 1e-9;
    }

    //Perpendicularidad usando la fórmula de la magnitud (|a+b|^2 = |a|^2 + |b|^2)
    public boolean perpendicular(AlgebraVectorial v2, int formula) {
        double magnitudSuma = Math.pow(this.x + v2.x, 2) + Math.pow(this.y + v2.y, 2) + Math.pow(this.z + v2.z, 2);
        double sumaMagnitudesCuadradas = Math.pow(this.magnitud(), 2) + Math.pow(v2.magnitud(), 2);
        return Math.abs(magnitudSuma - sumaMagnitudesCuadradas) < 1e-9;
    }
    
    //Paralelismo usando la fórmula de la proporcionalidad (a = r*b)
    public boolean paralelo(AlgebraVectorial v2) {
        boolean xParalelo = (v2.x == 0) ? (this.x == 0) : Math.abs(this.x / v2.x - this.y / v2.y) < 1e-9 && Math.abs(this.x / v2.x - this.z / v2.z) < 1e-9;
        boolean yParalelo = (v2.y == 0) ? (this.y == 0) : Math.abs(this.y / v2.y - this.x / v2.x) < 1e-9 && Math.abs(this.y / v2.y - this.z / v2.z) < 1e-9;
        boolean zParalelo = (v2.z == 0) ? (this.z == 0) : Math.abs(this.z / v2.z - this.x / v2.x) < 1e-9 && Math.abs(this.z / v2.z - this.y / v2.y) < 1e-9;
        return xParalelo || yParalelo || zParalelo;
    }

    //Calcula el producto cruz de dos vectores
    public AlgebraVectorial productoCruz(AlgebraVectorial v2) {
        double i = this.y * v2.z - this.z * v2.y;
        double j = this.z * v2.x - this.x * v2.z;
        double k = this.x * v2.y - this.y * v2.x;
        return new AlgebraVectorial(i, j, k);
    }
    
    //Paralelismo usando la fórmula del producto cruz (a x b = 0)
    public boolean paralelo(AlgebraVectorial v2, boolean formula) {
        AlgebraVectorial productoCruz = this.productoCruz(v2);
        return Math.abs(productoCruz.x) < 1e-9 && Math.abs(productoCruz.y) < 1e-9 && Math.abs(productoCruz.z) < 1e-9;
    }
    
    //Proyección ortogonal de 'a' sobre 'b'
    public AlgebraVectorial proyeccion(AlgebraVectorial v2) {
        double factor = this.productoPunto(v2) / Math.pow(v2.magnitud(), 2);
        return new AlgebraVectorial(factor * v2.x, factor * v2.y, factor * v2.z);
    }

    //Componente de 'a' en la dirección de 'b'
    public double componente(AlgebraVectorial v2) {
        return this.productoPunto(v2) / v2.magnitud();
    }

    @Override
    public String toString() {
        return String.format("[%.2f, %.2f, %.2f]", x, y, z);
    }
}