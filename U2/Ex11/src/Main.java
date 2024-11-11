public class Main {
    public static void main(String[] args) throws InterruptedException {
        int MAX_BARBERS = 2;
        int MAX_CADIRES = 3;
        int MAX_CLIENTES = 1000;
        Barber[] barbers;
        Thread[]  hilos;

        barbers =new Barber[MAX_BARBERS];
        hilos   =new Thread [MAX_BARBERS];

        GestorCadires gestorCadires = new GestorCadires(MAX_CADIRES);

        for (int i=0; i<MAX_BARBERS; i++){
            barbers[i]=new Barber(gestorCadires);
            hilos[i]   =new Thread(barbers[i]);

            hilos[i].start();
        } //Fin del for


        for (int i=0; i< MAX_CLIENTES; i++){
            Client c=new Client(gestorCadires);
            c.entrarEnBarberia();
        }
        Barber.esperarTiempsAtzar(30);
        /* La jornada ha terminado, "cerramos" los barbers*/
        for (int i=0; i<MAX_BARBERS; i++){
            barbers[i].cerrarBarberia();
            hilos[i].join();
        }
        System.out.println("Barberia cerrada.");
    } //Fin del main
}