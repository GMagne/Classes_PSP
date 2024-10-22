import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class Ex1Thread extends Thread {
    private static List<Integer> suma = Arrays.asList(0);

    public void run(){
        System.out.println(this.getName()+" iniciat");

        // Generam un int random entre [1-100]
        Random rn = new Random();
        int randomInt = 1 + (int)(Math.random() * 100);
        System.out.println(this.getName()+": "+randomInt);

        // Suma randomInt a una variable comú a totes les instàncies de Ex1Thread
        synchronized (suma){
            suma.set(0,suma.get(0)+randomInt);
            System.out.println(this.getName()+": finalizat amb suma "+Integer.toString(suma.get(0)));
        }
    }

    public static void main(String[] args) {
        int n = 10;

        for (int i = 0; i<n; i++){
            Ex1Thread f = new Ex1Thread();
            f.setName("Fil "+Integer.toString(i));
            f.start();
        }
    }
}