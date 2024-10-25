public class Recurs {

    private boolean autoritzat = true;

    synchronized public void setNoAutoritzat(){
        autoritzat = false;
        System.out.println("Set: accés al recurs no autoritzat");
    }

    public synchronized void acces(){
        if (autoritzat){
            try {
                System.out.println("Comença sleep.");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }//*/
            System.out.println("Accés realitzat.");
        } else{
            System.out.println("Accés no realitzat.");
        }
    }
}
