import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExemplesMultiprocesEntradaSortida_recursos {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            int read = Integer.parseInt(in.readLine());
            System.out.println(Math.sqrt(read));
        } catch (NumberFormatException nfe) {
            System.out.println("Error");
        }
        in.close();
    }
}