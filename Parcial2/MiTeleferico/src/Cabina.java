import java.util.ArrayList;

public class Cabina {
    private int nroCabina;
    private ArrayList<Persona> personasAbordo;

    public Cabina(int nroCabina) {
        this.nroCabina = nroCabina;
        this.personasAbordo = new ArrayList<>();
    }

    public void agregarPersona(Persona p) {
        personasAbordo.add(p);
    }

    public int getNroCabina() {
        return nroCabina;
    }

    public ArrayList<Persona> getPersonasAbordo() {
        return personasAbordo;
    }
}