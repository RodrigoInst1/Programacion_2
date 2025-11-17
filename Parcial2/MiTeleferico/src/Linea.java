import java.util.ArrayList;

public class Linea {
    private String color;
    private ArrayList<Persona> filaPersonas;
    private ArrayList<Cabina> cabinas;

    public Linea(String color, int cantidadCabinas) {
        this.color = color;
        this.filaPersonas = new ArrayList<>();
        this.cabinas = new ArrayList<>();

        // Crear las cabinas
        for (int i = 1; i <= cantidadCabinas; i++) {
            cabinas.add(new Cabina(i));
        }
    }

    public void agregarPersonaAFila(Persona p) {
        filaPersonas.add(p);
    }

    // Asignar la primera persona de la fila a una cabina
    public void asignarPersonaACabina(int nroCabina) {
        if (!filaPersonas.isEmpty()) {
            Persona persona = filaPersonas.remove(0);
            Cabina cabina = cabinas.get(nroCabina - 1);

            if (cabina.getPersonasAbordo().size() < 10 && calcularPesoTotal(cabina) + persona.getPeso() <= 850) {
                cabina.agregarPersona(persona); // Agregando a la cabina
                System.out.println("Persona " + persona.getNombre() + " abordó la cabina " + nroCabina);
            } else {
                System.out.println("No se puede agregar a la cabina " + nroCabina + ". Se excede el límite de personas o peso.");
                filaPersonas.add(0, persona); // devolver si es falso
            }
        } else {
            System.out.println("No hay personas en la fila para asignar.");
        }
    }

    // Para el pesaje
    private float calcularPesoTotal(Cabina cabina) {
        float pesoTotal = 0;
        for (Persona persona : cabina.getPersonasAbordo()) {
            pesoTotal += persona.getPeso();
        }
        return pesoTotal;
    }

    public String getColor() {
        return color;
    }

    public ArrayList<Persona> getFilaPersonas() {
        return filaPersonas;
    }

    public ArrayList<Cabina> getCabinas() {
        return cabinas;
    }
}