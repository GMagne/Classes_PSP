public class So extends Thread {
    boolean wait = true;
    Rellotge clock;

    So(String so, Rellotge clock ){
        super(so);
        this.clock = clock;
    }

    @Override
    public void run() {
        while(!this.isInterrupted()){
            while(wait){
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    return;
                }
            }
            System.out.println(this.getName()+ " " + clock.hora());
            wait = true;
        }
    }
}
