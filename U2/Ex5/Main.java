public class Main {
    public static void main(String[] args)  {
        Rellotge rellotge = new Rellotge();
        ThreadGroup tictac = new ThreadGroup("tictac");

        Thread tic = new Thread(tictac, () -> {
            for (int i = 1; i <= 4; i++) {
                try {
                    rellotge.tic();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        tic.start();

        Thread tac = new Thread(tictac, () -> {
            for (int i = 1; i <= 4; i++) {
                try {
                    rellotge.tac();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        tac.start();

        while (tictac.activeCount()!= 0){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        /*
        try {
            tac.join();
            tic.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }//*/




        System.out.println("Rellotge fora corda.");
    }
}
