public class Main extends Thread{
        public static void main(String[] args) {
            //Indica el numero de jardines y de jardineros
            final int NUM_JARDINEROS = 3;
            final int NUM_JARDINES = 10;

            //Una clase para añadir los jardineros
            ThreadJardinero[] jardineros = new ThreadJardinero[NUM_JARDINEROS];
            GestorJardines gestorJardines;
            gestorJardines = new GestorJardines(NUM_JARDINES);

            Thread[] hilos = new Thread[NUM_JARDINEROS];
            long start = System.nanoTime();
            for (int i = 0; i<NUM_JARDINEROS;i++) {
                String j = String.valueOf(i+1);
                jardineros[i] = new ThreadJardinero(gestorJardines, j);
                hilos[i] = new Thread(jardineros[i]);
                hilos[i].start();
            }
            System.out.println(System.nanoTime()-start);
        }
}