public class MainFeliu {
    public static void main(String[] args) {
        Fils fil1 = new Fils(5);
        Fils fil2 = new Fils(fil1);
        Fils fil3 = new Fils(fil1);

        fil1.start();
        fil2.start();
        fil3.start();

        try {
            fil1.join();
        } catch (InterruptedException e) {
            System.out.println("Fil1 interromput des del principal");
            fil1.interrupt();
        }

        try {
            fil2.join();
        } catch (InterruptedException e) {
            System.out.println("Fil2 interromput des del principal");
            fil2.interrupt();
        }

        System.out.println("Programa finalitzat");
    }
}

