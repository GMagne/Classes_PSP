public class GestorCadires {
    private int MAX_CADIRES;
    private boolean[] cadiraLliure;
    private boolean[] clientAtes;
    private int seguentClientPerAtendre =0;
    GestorCadires(int num){
        MAX_CADIRES=num;
        cadiraLliure =new boolean[MAX_CADIRES];
        clientAtes =new boolean[MAX_CADIRES];
        for (int i=0; i<MAX_CADIRES; i++){
            cadiraLliure[i]       = true;
            clientAtes[i]  = false;
        }
    }

    public synchronized int getPosCadiraLliure(){
        int posCadira=-1;
        for (int pos=0; pos<MAX_CADIRES;pos++){
            if (cadiraLliure[pos]==true){
                cadiraLliure[pos]=false;
                return pos;
            }
        }
        return posCadira;
    }

    public void lliberarCadira(int pos){
        cadiraLliure[pos]=true;
        clientAtes[pos]=false;
    }
    public synchronized int getSeguentClient(){
        int pos=-1;
        boolean salir;
        int i;
        salir=false;
        i=this.seguentClientPerAtendre;
        while(!salir){
            if (
                    (this.cadiraLliure[i]==false) &&
                            (this.clientAtes[i]==false)
            )
            {
                this.clientAtes[i]=true;
                this.seguentClientPerAtendre = (i+1) % MAX_CADIRES;
                return i;

            }
            i++;
            if (i==this.MAX_CADIRES){
                i=0;
            }
            if (i==this.seguentClientPerAtendre) salir=true;

        }

        return pos;
    }
}