public class Main {

    public static void main(String[] args) {
        GenPrincipal fil1 = new GenPrincipal();
        GenSecundari fil2 = new GenSecundari(fil1);

        fil1.start();
        fil2.start();
    }
}
