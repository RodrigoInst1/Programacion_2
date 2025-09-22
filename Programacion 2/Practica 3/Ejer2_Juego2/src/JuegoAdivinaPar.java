class JuegoAdivinaPar extends JuegoAdivinaNumero {

    public JuegoAdivinaPar(int numeroDeVidas) {
        super(numeroDeVidas);
    }

    @Override
    protected int generaNumeroAleatorio() {
        return random.nextInt(6) * 2; // Genera 0,2,4,6,8,10
    }

    @Override
    public boolean validaNumero(int numero) {
        if (numero < 0 || numero > 10) return false;
        if (numero % 2 == 0) return true;
        System.out.println("Número inválido: Debe ser par.");
        return false;
    }
}