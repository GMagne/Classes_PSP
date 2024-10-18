import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class ExercicisMultiproces2_ModificarString {



    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader inBR = new BufferedReader(inputStreamReader);

        String inputStr = "";
        try {
            inputStr = inBR.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        inBR.close();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Fill: "+inputStr);
    }
}