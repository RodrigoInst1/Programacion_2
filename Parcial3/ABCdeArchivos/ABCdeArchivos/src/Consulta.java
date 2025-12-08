import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Consulta {
    private int ci;
    private String nombrePaciente;
    private String apellidoPaciente;
    private int idMed;
    private int dia;
    private String mes;
    private int anio;

    public Consulta(int ci, String nombrePaciente, String apellidoPaciente, int idMed, int dia, String mes, int anio) {
        this.ci = ci;
        this.nombrePaciente = nombrePaciente;
        this.apellidoPaciente = apellidoPaciente;
        this.idMed = idMed;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    public Consulta() {
        this.ci=-1;
        this.nombrePaciente="";
        this.apellidoPaciente = "";
        this.idMed = -1;
        this.dia = -1;
        this.mes = "";
        this.anio = -1;
    }

    public void alta() {
        // Se recomienda usar una carpeta específica
        String ruta = "archivosConsulta/consulta" + this.ci + ".txt"; 

        try {
            FileWriter w = new FileWriter(ruta);
            BufferedWriter escritor = new BufferedWriter(w);

            // Escribimos cada atributo en una linea
            escritor.write(this.ci + "\n");
            escritor.write(this.nombrePaciente + "\n");
            escritor.write(this.apellidoPaciente + "\n");
            escritor.write(this.idMed + "\n");
            escritor.write(this.dia + "\n");
            escritor.write(this.mes + "\n");
            escritor.write(this.anio + ""); // El último no lleva salto de linea obligatoriamente, pero ayuda

            escritor.close();
            w.close();
            System.out.println("\t\t---ALTA DE CONSULTA CORRECTA---");

        } catch (Exception e) {
            System.out.println("ERROR EN ALTA DE CONSULTA\n\n" + e);
        }
    }

    // Carga: Lee el archivo y reconstruye el objeto
    public void cargar(String ruta){
        try {
            FileReader r = new FileReader(ruta);
            BufferedReader lector = new BufferedReader(r);

            this.ci = Integer.parseInt(lector.readLine());
            this.nombrePaciente = lector.readLine();
            this.apellidoPaciente = lector.readLine();
            this.idMed = Integer.parseInt(lector.readLine());
            this.dia = Integer.parseInt(lector.readLine());
            this.mes = lector.readLine();
            this.anio = Integer.parseInt(lector.readLine());

            lector.close();
            r.close();
            // System.out.println("\t\t---CARGA DE CONSULTA CORRECTA---"); // Opcional

        } catch (Exception e) {
            System.out.println("ERROR EN CARGA DE CONSULTA\n\n" + e);
        }
    }

    // Baja: Elimina el archivo
    public void baja(){
        String ruta = "archivosConsulta/consulta" + this.ci + ".txt"; 
        File archivo = new File(ruta);

        if(archivo.delete()){
            System.out.println("SE ELIMINO CORRECTAMENTE EL ARCHIVO " + archivo.getPath());
        } else {
            System.out.println("ERROR EN ELIMINACION DEL ARCHIVO " + archivo.getPath());
        }
    }


    @Override
    public String toString() {
        return "Consulta{" + "ci=" + ci + ", nombre=" + nombrePaciente + " " + apellidoPaciente + 
               ", idMed=" + idMed + ", fecha=" + dia + "/" + mes + "/" + anio + '}';
    }


    public int getCi() {
         return this.ci; }
    public void setCi(int ci) {
         this.ci = ci; }

    public String getNombrePaciente() { return this.nombrePaciente; }
    public void setNombrePaciente(String nombrePaciente) { this.nombrePaciente = nombrePaciente; }

    public String getApellidoPaciente() { return this.apellidoPaciente; }
    public void setApellidoPaciente(String apellidoPaciente) { this.apellidoPaciente = apellidoPaciente; }

    public int getIdMed() { return this.idMed; }
    public void setIdMed(int idMed) { this.idMed = idMed; }

    public int getDia() { return this.dia; }
    public void setDia(int dia) { this.dia = dia; }

    public String getMes() { return this.mes; }
    public void setMes(String mes) { this.mes = mes; }

    public int getAnio() { return this.anio; }
    public void setAnio(int anio) { this.anio = anio; }
}