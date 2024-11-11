public class Client {
    GestorCadires gestorSillas;
    public Client(GestorCadires g){
        this.gestorSillas = g;
    }
    public void entrarEnBarberia(){
        int posCadiraLliure = this.gestorSillas.getPosCadiraLliure();
        if (posCadiraLliure==-1){
            System.out.println("No hi ha lloc!");
            return ;
        }
        System.out.println("Assegut a la cadira: "+posCadiraLliure);
    }
}