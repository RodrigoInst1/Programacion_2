import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Medico {
    private int idMed;
    private String nombreMed;
    private String apellidoMed;
    private int aniosExperiencia;

    public Medico(int idMed, String nombreMed, String apellidoMed, int aniosExperiencia) {
        this.idMed = idMed;
        this.nombreMed = nombreMed;
        this.apellidoMed = apellidoMed;
        this.aniosExperiencia = aniosExperiencia;
    }

    public Medico() {
        this.idMed = -1;
        this.nombreMed = "";
        this.apellidoMed = "";
        this.aniosExperiencia = -1;
    }

    public void alta() {
        String ruta = "archivosMedicos/medico" + this.idMed + ".txt";

        try {
            FileWriter w = new FileWriter(ruta);
            BufferedWriter escritor = new BufferedWriter(w);

            escritor.write(this.idMed + "\n");
            escritor.write(this.nombreMed + "\n");
            escritor.write(this.apellidoMed + "\n");
            escritor.write(this.aniosExperiencia + "");

            escritor.close();
            w.close();
            System.out.println("\t\t---ALTA DE MEDICO CORRECTA---");

        } catch (Exception e) {
            System.out.println("ERROR EN ALTA DE MEDICO\n\n" + e);
        }
    }

    public void cargar(String ruta) {
        try {
            FileReader r = new FileReader(ruta);
            BufferedReader lector = new BufferedReader(r);

            this.idMed = Integer.parseInt(lector.readLine());
            this.nombreMed = lector.readLine();
            this.apellidoMed = lector.readLine();
            this.aniosExperiencia = Integer.parseInt(lector.readLine());

            lector.close();
            r.close();

        } catch (Exception e) {
            System.out.println("ERROR EN CARGA DE MEDICO\n\n" + e);
        }
    }

    public void baja() {
        String ruta = "archivosMedicos/medico" + this.idMed + ".txt";
        File archivo = new File(ruta);

        if (archivo.delete()) {
            System.out.println("SE HA ELIMINADO CORRECTAMENTE EL MEDICO " + archivo.getPath());
        } else {
            System.out.println("ERROR EN LA ELIMINACION DEL MEDICO " + archivo.getPath());
        }
    }
    
    // Getters necesarios para la lógica del consultorio
    public int getIdMed() { return idMed; }
    
    @Override
    public String toString() {
        return "Medico{" + "idMed=" + idMed + ", nombre=" + nombreMed + " " + apellidoMed + ", exp=" + aniosExperiencia + '}';
    }

    public void setIdMed(int idMed) {
        this.idMed = idMed;
    }

    public String getNombreMed() {
        return this.nombreMed;
    }

    public void setNombreMed(String nombreMed) {
        this.nombreMed = nombreMed;
    }

    public String getApellidoMed() {
        return this.apellidoMed;
    }

    public void setApellidoMed(String apellidoMed) {
        this.apellidoMed = apellidoMed;
    }

    public int getAniosExperiencia() {
        return this.aniosExperiencia;
    }

    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }

}