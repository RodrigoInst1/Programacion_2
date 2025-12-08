import java.io.File;
import java.util.ArrayList;

public class Consultorio {
    private String consultas; // Ruta de carpeta consultas
    private String medicos;   // Ruta de carpeta medicos

    public Consultorio(String consultas, String medicos) {
        this.consultas = consultas;
        this.medicos = medicos;
    }

    public void agregarConsulta(Consulta c){
        c.alta();
    }
    
    public void agregarMedico(Medico m){ 
        m.alta();
    }

    public void mostrarConsultas(){
        ArrayList<Consulta> lista = this.cargarConsultas();
        
        System.out.println("--- LISTA DE CONSULTAS ---");
        for(Consulta c: lista){
            System.out.println(c);
        }
    }
    
    public void mostrarMedicos(){
        ArrayList<Medico> lista = this.cargarMedicos();
        
        System.out.println("--- LISTA DE MEDICOS ---");
        for(Medico m: lista){
            System.out.println(m);
        }
    }

    // Método auxiliar para recuperar todos los médicos de los archivos
    public ArrayList<Medico> cargarMedicos(){
        ArrayList<Medico> lista = new ArrayList<Medico>();
        
        File carpeta = new File(this.medicos);
        // Verificar si existe la carpeta
        if(carpeta.exists() && carpeta.isDirectory()){
            File[] archivos = carpeta.listFiles();
            if(archivos != null){
                for(File f: archivos){
                    Medico nuevo = new Medico();
                    nuevo.cargar(f.getPath());
                    lista.add(nuevo);
                }
            }
        }
        return lista;
    }
    
    // Método auxiliar para recuperar todas las consultas
    public ArrayList<Consulta> cargarConsultas(){
        ArrayList<Consulta> lista = new ArrayList<Consulta>();
        
        File carpeta = new File(this.consultas);
        if(carpeta.exists() && carpeta.isDirectory()){
            File[] archivos = carpeta.listFiles();
            if(archivos != null){
                for(File f: archivos){
                    Consulta nuevo = new Consulta();
                    nuevo.cargar(f.getPath());
                    lista.add(nuevo);
                }
            }
        }
        return lista;
    }
    
    // EJERCICIO: Dar de baja médico por nombre y apellido y sus consultas
    public void darBajaMedico(String nombreX, String apellidoY) {
        ArrayList<Medico> listaMedicos = this.cargarMedicos();
        int idEliminar = -1;
        boolean encontrado = false;

        for (Medico m : listaMedicos) {
            if (m.getNombreMed().equals(nombreX) && m.getApellidoMed().equals(apellidoY)) {
                idEliminar = m.getIdMed(); 
                m.baja();
                encontrado = true;
                System.out.println("--- MEDICO ENCONTRADO Y ELIMINADO: " + nombreX + " " + apellidoY + " ---");
                break;
            }
        }

        if (encontrado) {
            ArrayList<Consulta> listaConsultas = this.cargarConsultas();
            int contador = 0;

            for (Consulta c : listaConsultas) {
                if (c.getIdMed() == idEliminar) {
                    c.baja();
                    contador++;
                }
            }
            System.out.println("--- SE ELIMINARON " + contador + " CONSULTAS ASOCIADAS ---");
        } else {
            System.out.println("--- ERROR: NO SE ENCONTRO AL MEDICO " + nombreX + " " + apellidoY + " ---");
        }
    }

    //EJERCICIO: Cambiar fecha de consultas de Navidad y Año Nuevo
    public void reprogramarFiestas() {
        ArrayList<Consulta> lista = this.cargarConsultas();
        int cambios = 0;

        for (Consulta c : lista) {
            if (c.getDia() == 25 && c.getMes().equalsIgnoreCase("Diciembre")) {
                
                System.out.println("-> Reprogramando cita de Navidad de: " + c.getNombrePaciente());
                c.setDia(26);
                c.alta();
                cambios++;
            }
            else if (c.getDia() == 1 && c.getMes().equalsIgnoreCase("Enero")) {
                
                System.out.println("-> Reprogramando cita de Año Nuevo de: " + c.getNombrePaciente());
                c.setDia(2);
                c.alta();
                cambios++;
            }
        }

        if (cambios > 0) {
            System.out.println("--- SE REPROGRAMARON " + cambios + " CITAS DE FIESTAS ---");
        } else {
            System.out.println("--- NO SE ENCONTRARON CITAS EN FESTIVOS ---");
        }
    }


    public String getConsultas() {
        return this.consultas;
    }

    public void setConsultas(String consultas) {
        this.consultas = consultas;
    }

    public String getMedicos() {
        return this.medicos;
    }

    public void setMedicos(String medicos) {
        this.medicos = medicos;
    }

}