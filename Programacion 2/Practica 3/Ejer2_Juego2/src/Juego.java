class Juego {
    protected int numeroDeVidas;
    protected int record;
    private int vidasIniciales;

    public Juego(int numeroDeVidas) {
        this.vidasIniciales = numeroDeVidas;
        reiniciaPartida();
        this.record = 0;
    }

    public void reiniciaPartida() {
        this.numeroDeVidas = this.vidasIniciales;
    }

    public void actualizaRecord(int intentosUsados) {
        if (record == 0 || intentosUsados < record) {
            record = intentosUsados;
            System.out.println("¡Nuevo récord: " + record + " intentos!");
        }
    }

    public boolean quitaVida() {
        numeroDeVidas--;
        return numeroDeVidas > 0;
    }
}