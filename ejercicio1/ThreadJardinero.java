public class ThreadJardinero implements Runnable{
    GestorJardines gestorJardines;
    String jardineros;
    int jardines;
    public ThreadJardinero (GestorJardines gestor, String jardineros) {
        this.gestorJardines = gestor;
        this.jardineros = jardineros;
    }
    @Override
    public void run() {
        for (int j = 1; j<=30; j++){
            jardines =  (int) (Math.random()*10);
            boolean jardinOcupado;
            jardinOcupado = this.gestorJardines.entrarJardin(jardines);
            if (jardinOcupado)  {
                entrar(jardines);
                this.gestorJardines.liberarJardin(jardines);
            }
        }
    }

    private void entrar(int jar) {
        System.out.println("El jardinero "+this.jardineros+" ha entrado en el jardin " +(jar+1));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("El jardinero "+this.jardineros+" ha salido del jardin "+(jar+1));
    }
}
