import javax.imageio.spi.ImageInputStreamSpi;
import java.io.*;
import java.util.Scanner;

public class Lanzador{

    static final String dirPath = "C:\\Users\\34667\\Desktop\\GS_DAM\\PPS\\Classes_PSP\\U1\\Streams\\src";
    static final String [] command ={
            "java",
            "Sqrt.java"
    };

    private static Process execPrograma() throws IOException {
        ProcessBuilder programa = new ProcessBuilder(command);
        programa.directory( new File(dirPath));
        programa.redirectError(new File(dirPath+"error.txt"));
        return programa.start();
    }

    private static void enviar(Process proces, String n) throws IOException {
        OutputStream outS = proces.getOutputStream();
        OutputStreamWriter outSW = new OutputStreamWriter(outS);
        BufferedWriter outBW = new BufferedWriter(outSW);

        outBW.write(n);
        outBW.newLine();
        outBW.flush(); // guarda
        outBW.close();
    }

    private static String llegir(Process proces) throws IOException {
        InputStream inS = proces.getInputStream();
        InputStreamReader inSR = new InputStreamReader(inS);
        BufferedReader inBR = new BufferedReader(inSR);

        return inBR.readLine(); //
    }

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)){
            while(true){
                System.out.println("Pare: Esciu un int");
                String n = scan.nextLine();
;
                if("exit".equals(n)) return;

                Process proces = execPrograma();
                enviar(proces, n);
                System.out.println("Pare: Els fill is Alive -> "+ proces.isAlive());
                String retorn = llegir(proces);
                proces.waitFor();
                System.out.println("Pare: "+retorn);
                System.out.println("Pare: Els fill is Alive -> "+ proces.isAlive());


                System.out.println("Pare: Fi");
            }


        } catch (IOException | InterruptedException e ) {
            e.printStackTrace();
        }
    }
}