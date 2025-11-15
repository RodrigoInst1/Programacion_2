import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//C)
class Autor {
    private String nombre;
    private String nacionalidad;

    public Autor(String nombre, String nacionalidad) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    public void mostrarInfo() {
        System.out.println("  Autor: " + nombre + " (" + nacionalidad + ")");
    }

    public String getNombre() {
        return nombre;
    }
}
//D)
class Estudiante {
    private String codigoEstudiante;
    private String nombre;

    public Estudiante(String codigo, String nombre) {
        this.codigoEstudiante = codigo;
        this.nombre = nombre;
    }

    public void mostrarInfo() {
        System.out.println("  Estudiante: " + nombre + " (Código: " + codigoEstudiante + ")");
    }

    public String getNombre() {
        return nombre;
    }
}
//B)
class Libro {
    private String titulo;
    private String ISBN;
    private List<Pagina> paginas; 

    private class Pagina {
        private int numeroPagina;
        private String contenido;

        public Pagina(int numero, String contenido) {
            this.numeroPagina = numero;
            this.contenido = contenido;
        }

        public void mostrarPagina() {
            System.out.println("--- Página " + numeroPagina + " ---");
            System.out.println(contenido);
            System.out.println("--------------------");
        }
    }

    public Libro(String titulo, String ISBN, List<String> contenidoPaginas) {
        this.titulo = titulo;
        this.ISBN = ISBN;
        this.paginas = new ArrayList<>();

        int num = 1;
        for (String contenido : contenidoPaginas) {
            this.paginas.add(new Pagina(num++, contenido));
        }
    }

    public void leer() {
        System.out.println("\nLeyendo el libro: '" + this.titulo + "'");
        for (Pagina p : paginas) {
            p.mostrarPagina();
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public String getISBN() {
        return ISBN;
    }
}
//E)
class Prestamo {
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private Estudiante estudiante; 
    private Libro libro;           

    public Prestamo(Estudiante estudiante, Libro libro) {
        this.estudiante = estudiante;
        this.libro = libro;
        this.fechaPrestamo = LocalDate.now();
        this.fechaDevolucion = this.fechaPrestamo.plusDays(14);
    }

    public void mostrarInfo() {
        System.out.println("  - Préstamo Activo:");
        System.out.println("    Libro: " + libro.getTitulo());
        System.out.println("    Estudiante: " + estudiante.getNombre());
        System.out.println("    Fecha de Préstamo: " + fechaPrestamo);
        System.out.println("    Fecha de Devolución: " + fechaDevolucion);
    }
}
//A)
class Biblioteca {
    private String nombre;
    private List<Libro> librosDisponibles;       
    private List<Autor> autoresRegistrados;      
    private List<Prestamo> prestamosActivos;     
    private Horario horarioAtencion;             

    private class Horario {
        private String diasApertura;
        private String horaApertura;
        private String horaCierre;

        public Horario(String dias, String hApertura, String hCierre) {
            this.diasApertura = dias;
            this.horaApertura = hApertura;
            this.horaCierre = hCierre;
        }

        public void mostrarHorario() {
            System.out.println("  Horario de Atención:");
            System.out.println("    Días: " + diasApertura);
            System.out.println("    Hora: " + horaApertura + " - " + horaCierre);
        }
    }

    public Biblioteca(String nombre, String dias, String hApertura, String hCierre) {
        this.nombre = nombre;
        this.horarioAtencion = new Horario(dias, hApertura, hCierre);
        
        this.librosDisponibles = new ArrayList<>();
        this.autoresRegistrados = new ArrayList<>();
        this.prestamosActivos = new ArrayList<>();
        System.out.println("¡Biblioteca '" + nombre + "' abierta!");
    }

    public void agregarLibro(Libro libro) {
        librosDisponibles.add(libro);
        System.out.println(">> Libro '" + libro.getTitulo() + "' agregado al catálogo.");
    }

    public void agregarAutor(Autor autor) {
        autoresRegistrados.add(autor);
        System.out.println(">> Autor '" + autor.getNombre() + "' registrado.");
    }

    public void prestarLibro(Estudiante estudiante, Libro libro) {
        if (librosDisponibles.contains(libro)) {
            librosDisponibles.remove(libro);
            Prestamo nuevoPrestamo = new Prestamo(estudiante, libro);
            prestamosActivos.add(nuevoPrestamo);
            System.out.println(">> Préstamo realizado: '" + libro.getTitulo() + "' a " + estudiante.getNombre());
        } else {
            System.out.println(">> Error: El libro '" + libro.getTitulo() + "' no está disponible.");
        }
    }

    public void mostrarEstado() {
        System.out.println("\n========= ESTADO DE LA BIBLIOTECA: " + nombre + " =========");
        
        horarioAtencion.mostrarHorario();

        System.out.println("\n  Autores Registrados (" + autoresRegistrados.size() + "):");
        if (autoresRegistrados.isEmpty()) {
            System.out.println("    (No hay autores registrados)");
        } else {
            for (Autor a : autoresRegistrados) {
                a.mostrarInfo();
            }
        }

        System.out.println("\n  Libros Disponibles (" + librosDisponibles.size() + "):");
        if (librosDisponibles.isEmpty()) {
            System.out.println("    (No hay libros disponibles)");
        } else {
            for (Libro b : librosDisponibles) {
                System.out.println("    - " + b.getTitulo() + " (ISBN: " + b.getISBN() + ")");
            }
        }
        
        System.out.println("\n  Préstamos Activos (" + prestamosActivos.size() + "):");
        if (prestamosActivos.isEmpty()) {
            System.out.println("    (No hay préstamos activos)");
        } else {
            for (Prestamo p : prestamosActivos) {
                p.mostrarInfo();
            }
        }
        System.out.println("====================================================\n");
    }
    
    public void cerrarBiblioteca(String mensaje) {
        System.out.println("\n!!! " + mensaje + " !!!");
        prestamosActivos.clear();
        System.out.println(">> Todos los préstamos han sido finalizados.");
    }
    
    @Override
    protected void finalize() {
        System.out.println("\n*** DESTRUYENDO LA BIBLIOTECA " + nombre + " ***");
        this.horarioAtencion = null;
        this.prestamosActivos.clear();
        System.out.println("*** Horario y préstamos destruidos. Libros y Autores siguen existiendo. ***");
    }
}

public class SistemaBiblioteca {
    public static void main(String[] args) {
        
        System.out.println("--- Creando Autores y Libros (existen independientemente) ---");
        Autor autor1 = new Autor("Gabriel Garcia Marquez", "Colombiano");
        Autor autor2 = new Autor("Isaac Asimov", "Ruso");

        Libro libro1 = new Libro("Cien años de soledad", "978-030735044X", 
            Arrays.asList("Muchos años después, frente al pelotón de fusilamiento...", "El mundo era tan reciente..."));
            
        Libro libro2 = new Libro("Fundación", "978-0553293357",
            Arrays.asList("Hari Seldon se enfrentaba a un imperio galáctico...", "La psicohistoria era su herramienta..."));

        Libro libro3 = new Libro("Yo, Robot", "978-0553382563",
            Arrays.asList("Las tres leyes de la robótica:", "1. Un robot no hará daño a un ser humano..."));
            
        Estudiante est1 = new Estudiante("20-12345", "Carla Rojas");
        Estudiante est2 = new Estudiante("21-54321", "Pedro Pascal");

        System.out.println("\n--- Creando la Biblioteca (Compone su Horario) ---");
        Biblioteca biblioCentral = new Biblioteca("Biblioteca Central UMSA", "Lunes a Viernes", "08:00", "18:00");
        
        System.out.println("\n--- Agregando Libros y Autores (Agregación) ---");
        biblioCentral.agregarAutor(autor1);
        biblioCentral.agregarAutor(autor2);
        
        biblioCentral.agregarLibro(libro1);
        biblioCentral.agregarLibro(libro2);
        biblioCentral.agregarLibro(libro3);

        biblioCentral.mostrarEstado();
        
        System.out.println("--- Realizando Préstamos (Asociación) ---");
        biblioCentral.prestarLibro(est1, libro2);
        biblioCentral.prestarLibro(est2, libro1);
        
        biblioCentral.mostrarEstado();
        
        System.out.println("--- Demostración de Agregación e Independencia ---");
        System.out.println("El objeto 'libro3' existe fuera de la biblioteca:");
        libro3.leer(); 
        
        System.out.println("--- Demostración de Composición (Destrucción) ---");
        biblioCentral = null;
        System.gc(); 

        try { Thread.sleep(100); } catch (InterruptedException e) {}

        System.out.println("\nFin del programa. Los objetos Autor y Libro todavía existen.");
        autor1.mostrarInfo();
    }
}