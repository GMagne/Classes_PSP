import java.util.Random;

public class Fils extends Thread {
    private static int total=1;
    private int num = total;
    private boolean esFil1;
    private int quantitatNombres=-1;
    private Fils filDependencia = null; // per al segon fil
    private Random random = new Random();

    // Constructor per a Fil1
    public Fils(int quantitatNombres) {
        this.esFil1 = true;
        this.quantitatNombres = quantitatNombres;
        total++;
    }

    // Constructor per a Fil2
    public Fils(Fils filDependencia) {
        this.esFil1 = false;
        this.filDependencia = filDependencia;
        total++;
    }

    @Override
    public void run() {
        if (esFil1) {
            // Comportament per a Fil1
            for (int i = 0; i < quantitatNombres; i++) {
                if(numRandom()) break;
            }
            System.out.println("Fil1 ha acabat.");
        } else {
            // Comportament per a Fil2
            while (filDependencia.isAlive()) {
                if(numRandom()) break;
            }
            System.out.println("Fil"+num+" ha acabat.");
        }
    }

    public boolean numRandom(){
        if (Thread.currentThread().isInterrupted()) {
            System.out.println("Fil interromput");
            return true;
        }
        System.out.println("Fil"+num+": " + random.nextInt(100));
        try {
            Thread.sleep(1000);  // Pausa d'1 segon
        } catch (InterruptedException e) {
            System.out.println("Fil interromput per una excepció");
            return true;
        }
        return false;
    }
}
