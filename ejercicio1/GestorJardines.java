public class GestorJardines {
    boolean[] jardinLibre;
    public GestorJardines(int numJardines) {
        jardinLibre = new boolean[numJardines];
        for (int i = 0; i < numJardines; i++) {
            jardinLibre[i] = true;
        }
    }
    public synchronized boolean entrarJardin(int jardin) {
        boolean conseguido = false;
        if (jardinLibre[jardin]) {
            jardinLibre[jardin] = false;
            conseguido = true;
        }
        return conseguido;
    }
    public void liberarJardin(int jardin) {
        jardinLibre[jardin] = true;
    }
}
