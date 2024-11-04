import java.util.Random;

public class GenSecundari extends Thread{
    GenPrincipal principal;

    GenSecundari(GenPrincipal principal){
        this.principal = principal;
    }

    @Override
    public void run(){
        Random rnd = new Random();
        while (principal.isAlive()) {
            try {
                while(!principal.sleep){
                    if (!principal.isAlive()) return;
                    Thread.sleep(50);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Secundari: "+ Integer.toString(rnd.nextInt(10)));
            principal.sleep = false;
        }
    }
}
