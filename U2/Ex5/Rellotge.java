public class Rellotge {
    private boolean tacWait = true;

    public synchronized void tac() throws InterruptedException {
        while (tacWait) {
            wait();
        }
        System.out.println("Tac");
        Thread.sleep(500);
        tacWait = true;
        this.notify();
    }

    public synchronized void tic() throws InterruptedException {
        while (!tacWait) {
                wait();
        }
        System.out.println("Tic");
        Thread.sleep(1000);
        tacWait = false;
        // Notify the producer that the item has been consumed
        this.notify();
    }
}