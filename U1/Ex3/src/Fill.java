import java.io.*;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Fill {



    public static void main(String[] args) throws IOException {

        String recibido = "";

        try(BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            recibido = in.readLine();
            System.out.println("\tFill: rep missatge del pare \"" + recibido+"\"");
            System.out.println("\tFill: envia missatge del pare");
            System.out.println("Salutacions de part del fill");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}