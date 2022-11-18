package jantar;
import java.util.Random;
public class Filosofos implements Runnable {
    private int numeroFilosofo;
    private Garfos garfoEsquerdo;
    private Garfos garfoDireito;
    private Random rand = new Random();
    public Filosofos(int indice, Garfos esquerdo, Garfos direito) {
        this.numeroFilosofo = indice;
        this.garfoEsquerdo = esquerdo;
        this.garfoDireito = direito;
    }
    private void pensar() {
        System.out.println("Filosofo " + (numeroFilosofo + 1) + " esta pensando.");
        try {
            Thread.sleep(4000L);
        } catch (InterruptedException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void pegarGarfos() {
        try {
            if (rand.nextInt(2) == 1) { //sorteio 0, 1
                garfoEsquerdo.pegarGarfo();
                System.out.println("Filosofo " + (numeroFilosofo + 1) + " pegou o primeiro garfo (esquerdo).");
                garfoDireito.pegarGarfo();
                System.out.println("Filosofo " + (numeroFilosofo + 1) + " pegou o segundo garfo (direito).");
            } else {
                garfoDireito.pegarGarfo();
                System.out.println("Filosofo " + (numeroFilosofo + 1) + " pegou o primeiro garfo (direito).");
                garfoEsquerdo.pegarGarfo();
                System.out.println("Filosofo " + (numeroFilosofo + 1) + " pegou o segundo garfo (esquerdo).");
            }
        } catch (InterruptedException e) {
            System.out.println("Erro: " + e.getMessage());
        }

    }

    private void soltarGarfos() {
        if (rand.nextInt(2) == 1) { // sorteio numero 0 e 1
            garfoEsquerdo.soltarGarfo();
            System.out.println("Filosofo " + (numeroFilosofo + 1) + " largou o primerio (esquerdo).");
            garfoDireito.soltarGarfo();
            System.out.println("Filosofo " + (numeroFilosofo + 1) + " largou o segundo (direito).");
        } else {
            garfoDireito.soltarGarfo();
            System.out.println("Filosofo " + (numeroFilosofo + 1) + " largou o primeiro (direito).");
            garfoEsquerdo.soltarGarfo();
            System.out.println("Filosofo " + (numeroFilosofo + 1) + " largou o segundo (esquerdo).");
        }
    }

    private void comer() throws InterruptedException {
        System.out.println("Filosofo " + (numeroFilosofo + 1) + " esta comendo.");
        Thread.sleep(3000L);
    }

    @Override
    public void run() {

        try {
            while (true) {
                pensar();
                pegarGarfos();
                comer();
                soltarGarfos();
            }
        } catch (InterruptedException e) {
            System.out.println("Erro: " + e.getMessage());
        }

    }
}


