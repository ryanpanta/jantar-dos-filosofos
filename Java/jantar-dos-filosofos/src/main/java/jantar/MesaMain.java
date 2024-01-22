package jantar;
import java.util.ArrayList;
public class MesaMain {
    private static final int FILOSOFOS = 5;
    public static void main(String[] args) throws InterruptedException {
        int numeroFilosofos = FILOSOFOS;

        ArrayList<Garfos> garfos = new ArrayList<Garfos>();
        ArrayList<Filosofos> filosofos = new ArrayList<Filosofos>();

        for (int i = 0; i < numeroFilosofos; i ++){ //starta o numero de garfos
            garfos.add(new Garfos(i));
        }

        for (int i = 0; i < numeroFilosofos; i++) { //starta/add os filosofos
            int garfoProximo;
            if(i == numeroFilosofos - 1){  //filoso1 = i = 0 garfo1 = 0 garfo2 = 1 --- filosofo2 = i = 1 -- garfo1 = 1 garfo2 = 2
                garfoProximo = 0;           //filosofo 3 = garfo 2 e 3 filosofo 4 vai ser os garfos 3 e 4 e filosofo 5 ele vai ter o garfo 4 e garfo 0
            }else{
                garfoProximo = i + 1;
            }
            filosofos.add(new Filosofos(i, garfos.get(i), garfos.get(garfoProximo)));
        }

        for (Filosofos f : filosofos){
            new Thread(f).start();
        }

    }
}
