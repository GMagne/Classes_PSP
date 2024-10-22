import java.util.Random;

public class Ex1Runnable implements Runnable{
    public String nom;
    Ex1Runnable(String nom){
        super();
        this.nom = nom;
    }

    @Override
    public void run() {
        System.out.println(this.nom+": iniciat");

        Random rn = new Random();
        int randomNum = 1 + (int)(Math.random() * 100);
        System.out.println(this.nom+": valor "+randomNum);

        System.out.println(this.nom+": finalitzat");
    }

    public static void main(String[] args) {
        int n = 4;

        for (int i = 0; i<n; i++){
            String nom = "Fil "+Integer.toString(i);
            Ex1Runnable tasca = new Ex1Runnable(nom);
            Thread fil = new Thread(tasca);
            fil.start();
        }
    }
}
