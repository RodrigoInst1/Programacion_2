public class Main {
    public static void main(String[] args) {
        Linea lineaRoja = new Linea("Rojo", 2);

        Persona p1 = new Persona("Juan", 25, 20f);
        Persona p2 = new Persona("Maria", 30, 20f);
        Persona p3 = new Persona("Carlos", 40, 20f);
        Persona p4 = new Persona("Ana", 35, 20f);
        Persona p5 = new Persona("Josep", 25, 700f);
        Persona p6 = new Persona("Marcos", 30, 20f);
        Persona p7 = new Persona("Carl", 40, 20f);
        Persona p8 = new Persona("Jana", 35, 20f);
        Persona p9 = new Persona("Rodrigo", 35, 20f);
        Persona p10 = new Persona("Roger", 35, 20f);
        Persona p11 = new Persona("Angel", 35, 20f);
        Persona p12 = new Persona("Angel", 35, 20f);

        lineaRoja.getCabinas().add(new Cabina(3));

        lineaRoja.agregarPersonaAFila(p1);
        lineaRoja.agregarPersonaAFila(p2);
        lineaRoja.agregarPersonaAFila(p3);
        lineaRoja.agregarPersonaAFila(p4);
        lineaRoja.agregarPersonaAFila(p5);
        lineaRoja.agregarPersonaAFila(p6);
        lineaRoja.agregarPersonaAFila(p7);
        lineaRoja.agregarPersonaAFila(p8);
        lineaRoja.agregarPersonaAFila(p9);
        lineaRoja.agregarPersonaAFila(p10);
        lineaRoja.agregarPersonaAFila(p11);
        lineaRoja.agregarPersonaAFila(p12);

        // Asignar personas a la cabina 1
        lineaRoja.asignarPersonaACabina(1);
        lineaRoja.asignarPersonaACabina(1);
        lineaRoja.asignarPersonaACabina(1);
        lineaRoja.asignarPersonaACabina(1);
        lineaRoja.asignarPersonaACabina(1);
        lineaRoja.asignarPersonaACabina(1);
        lineaRoja.asignarPersonaACabina(1);
        lineaRoja.asignarPersonaACabina(1);
        lineaRoja.asignarPersonaACabina(1);
        lineaRoja.asignarPersonaACabina(1);
        lineaRoja.asignarPersonaACabina(1);

        // Parcial 2 FIN
        System.out.println("-----MI TELEFERICO-----");
        System.out.println("LINEA ROJA");
        System.out.println("Personas en la cabina 1: " + lineaRoja.getCabinas().get(0).getPersonasAbordo().size());
        System.out.println("Personas en la cabina 2: " + lineaRoja.getCabinas().get(1).getPersonasAbordo().size());
        System.out.println("Personas en la fila: " + lineaRoja.getFilaPersonas().size());
        System.out.println("Asignando personas a la cabina 2:");
        lineaRoja.asignarPersonaACabina(2);
        
        System.out.println("Personas en la cabina 2: " + lineaRoja.getCabinas().get(1).getPersonasAbordo().size());
    }
}