import java.util.Random;

public class Barber implements Runnable{
    GestorCadires gestorCadires;
    boolean barberiaAbierta;
    public Barber(GestorCadires g){
        gestorCadires=g;
        barberiaAbierta=true;
    }

    public void cerrarBarberia(){
        this.barberiaAbierta=false;
    }
    @Override
    public void run() {
        while(barberiaAbierta){
            int posSillaClienteSinAtender;
            posSillaClienteSinAtender=
                    this.gestorCadires.getSeguentClient();
            if (posSillaClienteSinAtender==-1){
                esperarTempsRnd(3);
            } else {
                System.out.println("Barber atendiendo silla:" +
                        posSillaClienteSinAtender);
                esperarTempsRnd(3);
                this.gestorCadires.lliberarCadira(posSillaClienteSinAtender);
            }
        }
    }

    public static void esperarTempsRnd(int max){
        Random generador=new Random();
        int min = 1;
        /* Se calculan unos milisegundos al azar*/
        int ms=(min+generador.nextInt(max-min))*1000;
        try {
            Thread.currentThread().sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}