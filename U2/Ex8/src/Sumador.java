public class Sumador extends Thread{
    static Comptador comptador = new Comptador();
    static Semafor semafor = new Semafor();

    Sumador(String nom){
        this.setName(nom);
    }

    @Override
    public void run() {
        semafor.lock();
        int valor = comptador.getCompte();
        valor = valor + 1;
        comptador.setCompte(valor);
        System.out.println(this.getName() + " - El valor del comptador és: " +comptador.getCompte());
        semafor.unlock();
    }
}
