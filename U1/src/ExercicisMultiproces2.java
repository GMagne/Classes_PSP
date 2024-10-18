import java.io.*;
import java.util.Scanner;

public class ExercicisMultiproces2 {

    static final String dirPath = "C:\\Users\\34667\\Desktop\\GS_DAM\\PPS\\Classes_PSP\\U1\\Ex2\\src";
    static final String [] commandProg= {
      "java",
      "ExercicisMultiproces2_ModificarString.java"
    };

    private static Process execPrograma(){
        ProcessBuilder programa = new ProcessBuilder(commandProg);
        programa.directory( new File(dirPath));
        Process proces = null;
        try {
            proces = programa.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return proces;
    }

    private static void enviar(Process proces, String input) throws IOException { //throws IOException
        OutputStream outS = proces.getOutputStream(); //Stream del procés pare,
        // està connectat per un pipe a l'entrada estàndard (Stdin) del procés fill.
        OutputStreamWriter outSW = new OutputStreamWriter(outS); // char to bytes
        BufferedWriter outBW = new BufferedWriter(outSW); // Permet usar un búfer per escriure

        outBW.write(input); //escriu
        outBW.newLine(); // nova linia
        outBW.flush(); // guardar
        outBW.close();
    }

    private static String llegir(Process proces) throws IOException {
        InputStream inS = proces.getInputStream();
        InputStreamReader inSR = new InputStreamReader(inS);
        BufferedReader inBR = new BufferedReader(inSR);
        return inBR.readLine(); // not close????
    }

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            while (true) {
                System.out.print("Pare: Introdueix text -> ");
                String value = scan.nextLine();

                if ("exit".equals(value)) return;

                Process proces = execPrograma();
                enviar(proces, value);
                System.out.println("Pare: Alive is "+proces.isAlive());
                System.out.println("Pare: ...");
                proces.waitFor(); //
                System.out.println("Pare: Alive is "+proces.isAlive());

                String retorn = llegir(proces);
                System.out.println("Pare: " + retorn);
                System.out.println("Pare: ==================");
            }
        } catch (IOException | InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}
