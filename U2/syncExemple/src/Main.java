public class Main {
    public static void main(String[] args) {
        Recurs recurs = new Recurs();

        Thread fil1 = new Thread(()->{
            recurs.acces();
        });
        Thread fil2 = new Thread(()->{
            recurs.setNoAutoritzat();
        });

        fil2.start();
        fil1.start();
    }
}