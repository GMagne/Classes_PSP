public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Sumador("Fil "+Integer.toString(i)).start();
        }
    }
}