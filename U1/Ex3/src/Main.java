import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static final String dirPath = ".\\out\\production\\Ex3";
    static final String [] command = {
            "java",
            "Fill"
    };

    private static Process executarPrograma() throws IOException {
        ProcessBuilder programa = new ProcessBuilder(command);
        programa.directory(new File(dirPath));
        programa.redirectError(new File(dirPath + "\\errores.txt"));
        return programa.start();
    }

    private static void enviar(Process proces, String n) throws IOException {
        OutputStream outS = proces.getOutputStream();
        OutputStreamWriter outSW = new OutputStreamWriter(outS);
        BufferedWriter outBW = new BufferedWriter(outSW);

        outBW.write(n);
        outBW.newLine();
        outBW.flush();
        outBW.close();
    }

    private static List<String> llegir(Process proces) throws IOException {
        InputStream inS = proces.getInputStream();
        InputStreamReader iSR = new InputStreamReader(inS);
        BufferedReader iBR = new BufferedReader(iSR);

        List<String> toReturn = new ArrayList<String>();
        String linea = "";
        while ((linea = iBR.readLine()) != null) {
            toReturn.add(linea);
        }
        return toReturn;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Process fill = executarPrograma();

        System.out.println("Pare: envia missatge");
        enviar(fill, "Salutacions del pare");

        fill.waitFor();

        List<String> missatge = llegir(fill);
        System.out.println(missatge.get(0));
        System.out.println(missatge.get(1));
        System.out.println("Pare: rep missatge del fill: \"" + missatge.get(2) + "\"");
    }
}