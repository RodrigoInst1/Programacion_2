import java.io.File;

public class Main {

    public static void main(String[] args) {
        //Abrir carpeta
        File carpetaMedicos = new File("archivosMedicos");
        File carpetaConsultas = new File("archivosConsulta");
        
        if(!carpetaMedicos.exists()) carpetaMedicos.mkdir();
        if(!carpetaConsultas.exists()) carpetaConsultas.mkdir();

        Consultorio clinica = new Consultorio("archivosConsulta", "archivosMedicos");

        //crear y dar alta a 3 medicos
        System.out.println(">>> REGISTRANDO MEDICOS...");
        
        // Medico(id, nombre, apellido, añosExperiencia)
        Medico m1 = new Medico(101, "Rodrigo", "Catunta", 15);
        Medico m2 = new Medico(102, "Marco", "Poma", 8);
        Medico m3 = new Medico(103, "Angel", "Tarqui", 5);

        clinica.agregarMedico(m1);
        clinica.agregarMedico(m2);
        clinica.agregarMedico(m3);

        //Crear y dar alta a 9 consultas
        System.out.println("\n>>> REGISTRANDO CONSULTAS...");

        //El 'idMed' en la consulta debe coincidir con el ID del médico de arriba
        //Consulta(ciPaciente, nombre, apellido, idMedico, dia, mes, anio)
        // --- 3 Pacientes para el Dr. Catunta (ID 101) ---
        Consulta c1 = new Consulta(48501, "Carlos", "Perez", 101, 12, "Septiembre", 2025);
        Consulta c2 = new Consulta(48502, "Ana", "Lopez",    101, 13, "Septiembre", 2025);
        Consulta c3 = new Consulta(48503, "Luis", "Diaz",    101, 14, "Septiembre", 2025);

        // --- 3 Pacientes para la Dra. Poma (ID 102) ---
        Consulta c4 = new Consulta(48504, "Maria", "Roca",   102, 12, "Octubre", 2025);
        Consulta c5 = new Consulta(48505, "Jose", "Mamani",  102, 15, "Octubre", 2025);
        Consulta c6 = new Consulta(48506, "Sofia", "Ali",    102, 16, "Octubre", 2025);

        // --- 3 Pacientes para el Dr. Tarqui (ID 103) ---
        Consulta c7 = new Consulta(48507, "Pedro", "Gomez",  103, 10, "Noviembre", 2025);
        Consulta c8 = new Consulta(48508, "Laura", "Soria",  103, 11, "Noviembre", 2025);
        Consulta c9 = new Consulta(48509, "Kevin", "Condori",103, 12, "Noviembre", 2025);

        //Agregamos
        clinica.agregarConsulta(c1);
        clinica.agregarConsulta(c2);
        clinica.agregarConsulta(c3);
        clinica.agregarConsulta(c4);
        clinica.agregarConsulta(c5);
        clinica.agregarConsulta(c6);
        clinica.agregarConsulta(c7);
        clinica.agregarConsulta(c8);
        clinica.agregarConsulta(c9);

        //Mostrar datos guardados en archivos
        System.out.println("VERIFICANDO DATOS GUARDADOS EN ARCHIVOS");
        
        //Lee
        clinica.mostrarMedicos();
        System.out.println("");
        clinica.mostrarConsultas();

        //Ejercicio B: Dar de baja a un medico por Nombre y Apellido
        System.out.println("\n\n=== EJERCICIO B: DAR DE BAJA MEDICO POR NOMBRE Y APELLIDO ===");
        System.out.println("Dar de baja al medico Rodrigo Catunta y sus consultas asociadas.");
        System.out.println("\n\n>>> EJECUTANDO BAJA DE MEDICO...");
        
        //Nombre y Apellido exactos
        clinica.darBajaMedico("Rodrigo", "Catunta");

        clinica.mostrarMedicos();
        System.out.println("");
        clinica.mostrarConsultas();

        //EJERCICIO C: Reprogramar citas en días festivos
        System.out.println("\n\n=== EJERCICIO C: REPROGRAMAR CITAS EN DÍAS FESTIVOS ===");
        
        // Cita en Navidad
        Consulta cFestiva1 = new Consulta(99901, "Noel", "Claus", 102, 25, "Diciembre", 2025);
        // Cita en Año Nuevo
        Consulta cFestiva2 = new Consulta(99902, "Grinch", "Verde", 102, 1, "Enero", 2026);
        
        clinica.agregarConsulta(cFestiva1);
        clinica.agregarConsulta(cFestiva2);

        System.out.println("\n--- ANTES DEL CAMBIO ---");
        clinica.mostrarConsultas();

        System.out.println("\n>>> EJECUTANDO REPROGRAMACION DE FIESTAS...");
        clinica.reprogramarFiestas();

        System.out.println("\n--- DESPUES DEL CAMBIO ---");
        clinica.mostrarConsultas();
    }
}