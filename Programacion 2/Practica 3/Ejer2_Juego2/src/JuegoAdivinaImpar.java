class JuegoAdivinaImpar extends JuegoAdivinaNumero {

    public JuegoAdivinaImpar(int numeroDeVidas) {
        super(numeroDeVidas);
    }

    @Override
    protected int generaNumeroAleatorio() {
        return random.nextInt(5) * 2 + 1; // Genera 1,3,5,7,9
    }

    @Override
    public boolean validaNumero(int numero) {
        if (numero < 0 || numero > 10) return false;
        if (numero % 2 != 0) return true;
        System.out.println("Número inválido: Debe ser impar.");
        return false;
    }
}