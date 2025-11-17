import java.util.ArrayList;

public class MiTeleferico {
    private ArrayList<Linea> lineas;
    private float cantidadIngresos;

    public MiTeleferico() {
        this.lineas = new ArrayList<>();
        this.cantidadIngresos = 0;

        lineas.add(new Linea("Rojo", 5));
        lineas.add(new Linea("Amarillo", 4));
        lineas.add(new Linea("Verde", 6));
    }

    public ArrayList<Linea> getLineas() {
        return lineas;
    }

    //Metodo para agregarPeronaFila(Personas p,String linea), tarifa regular 3, y tarifa preferencial 1.5 para personas menores a 25 o mayores de 60
    public void agregarPersonaFila(Persona p, String colorLinea) {
        for (Linea linea : lineas) {
            if (linea.getColor().equalsIgnoreCase(colorLinea)) {
                linea.agregarPersonaAFila(p);
                // Calcular tarifa
                if (p.getEdad() < 25 || p.getEdad() > 60) {
                    cantidadIngresos += 1.5;
                } else {
                    cantidadIngresos += 3.0;
                }
                break;
            }
        }
    }

    //Metodo para agregar cabina a la linea agregarCabina(String linea)
    public void agregarCabina(String colorLinea) {
        for (Linea linea : lineas) {
            if (linea.getColor().equalsIgnoreCase(colorLinea)) {
                int nuevoNroCabina = linea.getCabinas().size() + 1;
                linea.getCabinas().add(new Cabina(nuevoNroCabina));
                break;
            }
        }
    }

    public void incrementarIngresos(float monto) {
        this.cantidadIngresos += monto;
    }

    public float getCantidadIngresos() {
        return cantidadIngresos;
    }
    
}