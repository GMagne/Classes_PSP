public class Recurs {

    private boolean autoritzat = true;

    public synchronized void setNoAutoritzat(){
        try {
            System.out.println("Comença sleep.");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }//*/
        autoritzat = false;
        System.out.println("Set: accés al recurs no autoritzat");
    }

    synchronized public void acces(){
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
