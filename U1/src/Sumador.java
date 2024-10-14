public class Sumador {
    public static int sumar(int n1, int n2){
        int resultat = 0;
        for(int i = n1; i<=n2; i++){
            resultat += i; // resultat = resultat + i;
        }
        return resultat;
    }

}
