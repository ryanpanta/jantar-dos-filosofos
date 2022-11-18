package jantar;

public class Garfos {
    private int numeroFilosofo;
    private Thread filosofo;
    public Garfos(int indice) {
            this.numeroFilosofo = indice;
            this.filosofo = null;
    }

    public synchronized void pegarGarfo() throws InterruptedException {

        if (this.filosofo != null){
            wait();
        }
        this.filosofo = Thread.currentThread();
    }

    public synchronized void soltarGarfo() {

        if (this.filosofo == Thread.currentThread()){
            this.filosofo = null;
        }
        notify();
    }
}

