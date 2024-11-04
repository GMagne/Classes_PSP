public class Semafor { //mutex
    boolean lock = false;

    synchronized void lock(){
        while (lock){
            try {
                wait();
            } catch (InterruptedException e) { }
        }
        lock = true;
    }
    synchronized void unlock(){
        lock = false;
        notify();
    }
}
