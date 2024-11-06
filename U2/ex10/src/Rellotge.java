import java.util.List;
import java.util.Objects;

public class Rellotge extends Thread {
    boolean initalMiliSeg = false;
    long miliSegInici;
    int indexSo = 0;
    So[] sons = new So[3];

    Rellotge(){
        creaSons(new String[] {"Tic","Tac","Toc"});
    }



    @Override
    public void start() {
        miliSegInici = System.currentTimeMillis();
        for (So so : sons){
            so.start();
        }
        super.start();
    }

    @Override
    public void run() {
        long msDarrerSo = 0;
        while (!this.isInterrupted()){
            long msAra = System.currentTimeMillis();
            if (msAra - msDarrerSo >= 1000){
                msDarrerSo = msAra;
                sons[indexSo++].wait = false;
                indexSo %= 3;
            }
        }
    }

    public void creaSons(String[] noms) {
        for (int i = 0; i < 3; i++) {
            sons[i] = new So(noms[i], this);
        }
    }

    public String hora(){
        long miliSegDeFuncionament = System.currentTimeMillis() - miliSegInici;
        long seconds = miliSegDeFuncionament / 1000;
        long hours = seconds / 3600;
        long minutes = (seconds % 3600) / 60;
        seconds %= 60;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
