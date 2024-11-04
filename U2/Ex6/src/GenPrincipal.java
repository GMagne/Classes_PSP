import java.util.Random;

public class GenPrincipal extends Thread {
    public int n = 4;
    public boolean sleep = false;

    @Override
    public void run(){
        Random rnd = new Random();
        for (int i = 0; i < this.n; i++) {
            System.out.println("Principal: "+ Integer.toString(rnd.nextInt(10)));
            try {
                this.sleep = true;
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.sleep =false;
        }
    }
}
